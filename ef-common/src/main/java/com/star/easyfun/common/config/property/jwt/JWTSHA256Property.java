package com.star.easyfun.common.config.property.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ：Star
 * @description ：无描述
 * @date ：2026 3月 09 12:19
 */

@Data
@Component
@ConfigurationProperties(prefix = "easyfun.jwt.sha256")
public class JWTSHA256Property {
    private String key;
}