package com.star.easyfun.common.config.property.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ：Star
 * @description ：无描述
 * @date ：2026 3月 04 15:13
 */

@Data
@Component
@ConfigurationProperties(prefix = "easyfun.jwt.rsa")
public class JWTRSAProperty {
    private String publicKey;
    private String privateKey;
    private String keyId;
}