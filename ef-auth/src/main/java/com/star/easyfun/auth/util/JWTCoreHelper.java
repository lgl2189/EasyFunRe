package com.star.easyfun.auth.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.star.easyfun.auth.pojo.dbo.UserBasicDBO;
import com.star.easyfun.auth.pojo.mapper.UserStructMapper;
import com.star.easyfun.common.config.property.jwt.JWTProperty;
import com.star.easyfun.common.pojo.dto.JWTPairDTO;
import com.star.easyfun.common.pojo.dto.TokenPayLoad;
import com.star.easyfun.common.pojo.entity.CustomRSAKeyPair;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;


/**
 * @author ：Star
 * @description ： JWT密钥配置：用于签名Access Token（非对称加密）
 * @date ：2026 2月 25 23:33
 */
@Component
@RequiredArgsConstructor
public class JWTCoreHelper {

    private final com.star.easyfun.common.util.RSAHelper rsaHelper;
    private final JWTProperty jwtProperty;
    private final ObjectMapper objectMapper;
    private final UserStructMapper userStructMapper;

    /**
     * 生成JWT，包含AccessToken和RefreshToken
     *
     * @param userBasicDBO 用户信息，请在传入前去除敏感信息
     * @return JWT Token对
     * @throws Exception 生成时发生JWT异常
     */
    public JWTPairDTO generateJWT(UserBasicDBO userBasicDBO) throws Exception {
        RSAKey rsaKey = getRSAKey(rsaHelper.getRSAKeyPair());
        // 1. 构建JWS头：指定算法+写入kid（keyId）
        JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS256)
                .keyID(rsaKey.getKeyID()) // 把keyId写入JWT头的kid字段
                .type(JOSEObjectType.JWT)
                .build();
        // 2. 构建AccessJWT声明
        TokenPayLoad tokenPayLoad = userStructMapper.userBasicDBOToJWTPayLoad(userBasicDBO);
        Date accessExpireDatetime = new Date(System.currentTimeMillis() + jwtProperty.getAccessToken().getExpirationTime() * 1000);
        Date refreshExpireDatetime = new Date(System.currentTimeMillis() + jwtProperty.getRefreshToken().getExpirationTime() * 1000);
        JWTClaimsSet accessTokenClaim = new JWTClaimsSet.Builder()
                .subject(objectMapper.writeValueAsString(tokenPayLoad)) // 用户名
                .issuer(jwtProperty.getIssuer()) // 签发方
                .issueTime(new Date()) // 签发时间
                .expirationTime(accessExpireDatetime) // 1小时过期
                .build();
        JWTClaimsSet refreshTokenClaim = new JWTClaimsSet.Builder()
                .subject(objectMapper.writeValueAsString(tokenPayLoad)) // 用户名
                .issuer(jwtProperty.getIssuer()) // 签发方
                .issueTime(new Date()) // 签发时间
                .expirationTime(refreshExpireDatetime) // 7天过期
                .build();
        // 3. 用RSA私钥签名
        SignedJWT accessSignedJWT = new SignedJWT(header, accessTokenClaim);
        accessSignedJWT.sign(new RSASSASigner(rsaKey.toRSAPrivateKey()));
        SignedJWT refreshSignedJWT = new SignedJWT(header, refreshTokenClaim);
        refreshSignedJWT.sign(new RSASSASigner(rsaKey.toRSAPrivateKey()));
        // 4. 返回JWT Token对
        return new JWTPairDTO()
                .setAccessToken(accessSignedJWT.serialize())
                .setRefreshToken(refreshSignedJWT.serialize());
    }

    /**
     * 获取RSA密钥
     * @param keyPair 密钥对
     * @return RSAKey
     */
    private static RSAKey getRSAKey(CustomRSAKeyPair keyPair) {
        // 构建RSAKey对象，是一种实现 JWK（JSON Web Key） 标准的对象：
        // - 传入公钥：从密钥对中强转为RSAPublicKey（RSA算法的公钥接口）
        // - 传入私钥：从密钥对中强转为RSAPrivateKey（RSA算法的私钥接口）
        // - 设置KeyID：UUID随机生成，用于标识该密钥（多密钥场景下区分不同密钥）
        return new RSAKey.Builder((RSAPublicKey) keyPair.getPublicKey())
                .privateKey((RSAPrivateKey) keyPair.getPrivateKey())
                .keyID(keyPair.getKeyID())
                .build();
    }
}