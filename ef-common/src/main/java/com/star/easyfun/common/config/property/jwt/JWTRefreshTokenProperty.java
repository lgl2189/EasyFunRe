package com.star.easyfun.common.config.property.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ：Star
 * @description ：无描述
 * @date ：2026 3月 04 15:15
 */

@Data
@Component
@ConfigurationProperties(prefix = "easyfun.jwt.refresh-token")
public class JWTRefreshTokenProperty {
    private Integer expirationTime;
}