package com.star.easyfun.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.star.easyfun.common.pojo.dto.TokenPayLoad;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

/**
 * @author ：Star
 * @description ：无描述
 * @date ：2026 3月 09 19:23
 */

@Component
@RequiredArgsConstructor
public class JWTHelper {
    private final ObjectMapper objectMapper;

    public TokenPayLoad getPayloadFromJWT(Jwt jwt) throws JsonProcessingException {
        if (jwt == null || jwt.getSubject() == null) {
            return null;
        }
        return objectMapper.readValue(jwt.getSubject(), TokenPayLoad.class);
    }
}