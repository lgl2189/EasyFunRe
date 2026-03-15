package com.star.easyfun.common.service.impl;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.star.easyfun.common.config.property.jwt.JWTSHA256Property;
import com.star.easyfun.common.service.JWTCommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * @author ：Star
 * @description ：无描述
 * @date ：2026 3月 03 17:57
 */

@Service
@RequiredArgsConstructor
public class JWTCommonServiceImpl implements JWTCommonService {
    private final JwtDecoder jwtDecoder;
    private final JWTSHA256Property jwtSHA256Property;

    @Override
    public Jwt validateToken(String token) {
        if(token == null){
            return null;
        }
        Jwt decode;
        try {
            decode = jwtDecoder.decode(token);
        }
        catch (JwtException e) {
            return null;
        }
        return decode;
    }

    @Override
    public String generateHmacSHA256(String payload) {
        return Hashing
                .hmacSha256(jwtSHA256Property.getKey().getBytes(StandardCharsets.UTF_8))
                .hashString(payload, StandardCharsets.UTF_8).toString();
    }

    @Override
    public boolean validateHmacSHA256(String payload, String expectedHmacHexStr) {
        // 1. 用相同密钥重新计算 HMAC
        HashCode expectedHmacHex = HashCode.fromString(expectedHmacHexStr);
        HashCode actualHmacHex = HashCode.fromString(generateHmacSHA256(payload));
        // 2. 常量时间对比
        return actualHmacHex.equals(expectedHmacHex);
    }
}