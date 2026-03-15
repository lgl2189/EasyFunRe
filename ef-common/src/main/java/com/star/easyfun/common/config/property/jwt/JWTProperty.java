package com.star.easyfun.common.config.property.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ：Star
 * @description ：无描述
 * @date ：2026 3月 03 17:52
 */


@Data
@Component
@ConfigurationProperties(prefix = "easyfun.jwt")
public class JWTProperty {
    private JWTRSAProperty rsa;
    private String issuer;
    private JWTAccessTokenProperty accessToken;
    private JWTRefreshTokenProperty refreshToken;
}