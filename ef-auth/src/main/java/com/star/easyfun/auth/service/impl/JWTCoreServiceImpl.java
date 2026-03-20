package com.star.easyfun.auth.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.star.easyfun.auth.pojo.dbo.UserBasicDBO;
import com.star.easyfun.auth.service.JWTCoreService;
import com.star.easyfun.auth.util.JWTCoreHelper;
import com.star.easyfun.common.config.property.jwt.JWTProperty;
import com.star.easyfun.common.constant.CommonRedisKey;
import com.star.easyfun.common.pojo.dto.JWTPairDTO;
import com.star.easyfun.common.pojo.dto.TokenPayLoad;
import com.star.easyfun.common.service.JWTCommonService;
import com.star.easyfun.common.util.JWTHelper;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * @author ：Star
 * @description ：无描述
 * @date ：2026 3月 03 17:57
 */

@Service
@RequiredArgsConstructor
public class JWTCoreServiceImpl implements JWTCoreService {
    private final JWTCoreHelper jwtCoreHelper;
    private final JWTHelper jwtHelper;
    private final RedisTemplate<String, Object> redisTemplate;
    private final JWTProperty jwtProperty;
    private final JWTCommonService commonJWTService;
    private static final Logger logger = LogManager.getLogger(JWTCoreServiceImpl.class);

    @Override
    public JWTPairDTO generateJWTPair(UserBasicDBO userBasicDBO, String deviceId) throws Exception {
        JWTPairDTO jwtPairDTO = jwtCoreHelper.generateJWT(userBasicDBO);
        // 缓存refreshToken
        String jwtRefreshTokenKey = CommonRedisKey.getJwtRefreshTokenKey(String.valueOf(userBasicDBO.getUserId()), deviceId);
        redisTemplate.opsForValue().set(jwtRefreshTokenKey, jwtPairDTO.getRefreshToken());
        redisTemplate.expire(jwtRefreshTokenKey, jwtProperty.getRefreshToken().getExpirationTime(), TimeUnit.SECONDS);
        return jwtPairDTO;
    }

    @Override
    public JWTPairDTO refreshToken(String expectRefreshToken, String deviceId) throws Exception {
        Jwt jwt = commonJWTService.validateToken(expectRefreshToken);
        if (jwt == null) {
            return null;
        }
        TokenPayLoad tokenPayLoad = jwtHelper.getPayloadFromJWT(jwt);
        String jwtRefreshTokenKey = CommonRedisKey.getJwtRefreshTokenKey(tokenPayLoad.getUserId(), deviceId);
        String actualRefreshToken = (String) redisTemplate.opsForValue().get(jwtRefreshTokenKey);
        if (!expectRefreshToken.equals(actualRefreshToken)) {
            return null;
        }
        JWTPairDTO jwtPairDTO = generateJWTPair(new UserBasicDBO().setUserId(Long.valueOf(tokenPayLoad.getUserId())), deviceId);
        redisTemplate.opsForValue().set(jwtRefreshTokenKey, jwtPairDTO.getRefreshToken());
        redisTemplate.expire(jwtRefreshTokenKey, jwtProperty.getRefreshToken().getExpirationTime(), TimeUnit.SECONDS);
        return jwtPairDTO;
    }

    @Override
    public boolean deactivateToken(String accessToken, String refreshToken, String deviceId) {
        // 验证令牌本身是否有效
        Jwt accessJwt = commonJWTService.validateToken(accessToken);
        if (accessJwt == null) {
            return false;
        }
        Jwt refreshJwt = commonJWTService.validateToken(refreshToken);
        if (refreshJwt == null) {
            return false;
        }
        TokenPayLoad accessTokenPayLoad;
        TokenPayLoad refreshTokenPayLoad;
        try {
            accessTokenPayLoad = jwtHelper.getPayloadFromJWT(accessJwt);
            refreshTokenPayLoad = jwtHelper.getPayloadFromJWT(refreshJwt);
        }
        catch (JsonProcessingException e) {
            logger.error("ef-auth中，json解析时出现JsonProcessingException错误，导致json解析失败", e);
            return false;
        }
        if (!accessTokenPayLoad.getUserId().equals(refreshTokenPayLoad.getUserId())) {
            return false;
        }
        // 从缓存验证刷新令牌
        String jwtRefreshTokenKey = CommonRedisKey.getJwtRefreshTokenKey(refreshTokenPayLoad.getUserId(), deviceId);
        if (!redisTemplate.hasKey(jwtRefreshTokenKey)) {
            return false;
        }
        String jwtAccessTokenKey = CommonRedisKey.getJwtBlackAccessTokenKey(accessTokenPayLoad.getUserId(), deviceId);
        Instant expiresAt = accessJwt.getExpiresAt();
        Duration duration = Duration.between(Instant.now(), expiresAt);
        long expirationSeconds = duration.getSeconds();
        // 令牌已过期，无需放入黑名单
        if (expirationSeconds <= 0) {
            return false;
        }
        redisTemplate.opsForValue().set(jwtAccessTokenKey, accessToken);
        redisTemplate.expire(jwtAccessTokenKey, expirationSeconds, TimeUnit.SECONDS);
        redisTemplate.delete(jwtRefreshTokenKey);
        return true;
    }

}