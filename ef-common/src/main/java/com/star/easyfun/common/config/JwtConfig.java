package com.star.easyfun.common.config;

import com.star.easyfun.common.config.property.jwt.JWTProperty;
import com.star.easyfun.common.pojo.entity.CustomRSAKeyPair;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.security.interfaces.RSAPublicKey;

/**
 * @author ：Star
 * @description ：    JWT相关配置
 * @date ：2026 3月 06 12:24
 */

@Configuration
@RequiredArgsConstructor
public class JwtConfig {

    private final JWTProperty jwtProperty;
    private final com.star.easyfun.common.util.RSAHelper rsaHelper;

    /**
     * 初始化 JwtDecoder（RS256 非对称验签）
     */
    @Bean
    public JwtDecoder jwtDecoder() {
        // 获取 RSA 公钥（从自定义的密钥对中提取）
        CustomRSAKeyPair rsaKeyPair;
        try {
            rsaKeyPair = rsaHelper.getRSAKeyPair();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        RSAPublicKey publicKey = (RSAPublicKey) rsaKeyPair.getPublicKey();

        // 2. 构建 NimbusJwtDecoder（Spring Security 底层基于 Nimbus 实现）
        NimbusJwtDecoder decoder = NimbusJwtDecoder.withPublicKey(publicKey)
                .signatureAlgorithm(SignatureAlgorithm.RS256) // 指定算法为 RS256
                .build();

        // 3. 配置 JWT 验证规则（可选，强制验证签发方、过期时间等）
        OAuth2TokenValidator<Jwt> validatorBuilder = JwtValidators.createDefaultWithIssuer(jwtProperty.getIssuer());
        decoder.setJwtValidator(validatorBuilder);
        return decoder;
    }
}