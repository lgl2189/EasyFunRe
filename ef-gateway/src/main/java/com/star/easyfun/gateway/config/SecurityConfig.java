package com.star.easyfun.gateway.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.star.easyfun.common.service.JWTCommonService;
import com.star.easyfun.common.util.JWTHelper;
import com.star.easyfun.gateway.constant.RequestUrlConstant;
import com.star.easyfun.gateway.filter.AuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * @author ：Star
 * @description ：配置SpringSecurity相关配置
 * @date ：2026 2月 24 21:09
 */

@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final ObjectMapper objectMapper;
    private final JWTCommonService jwtCommonService;
    private final JWTHelper jwtHelper;
    private final RedisTemplate<String, Object> redisTemplate;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        // 选择手动创建对象，是因为如果将Filter作为SpringBean，Spring会自动将其加入Spring的过滤器链
        // 会导致过滤器同时存在于Spring的过滤器链和SpringSecurity的过滤器链，最终导致每个请求被处理两次
        // 目前没有找到方式在WebFlux中手动关闭一个过滤器的自动注册
        final AuthFilter authFilter = new AuthFilter(objectMapper,jwtCommonService,jwtHelper,redisTemplate);
        http
                .authorizeExchange(exchange -> exchange
                        .pathMatchers(RequestUrlConstant.gatewaySecurityIgnoreUrlList).permitAll()
                        .anyExchange().authenticated()
                )
                .formLogin(ServerHttpSecurity.FormLoginSpec::disable)
                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .logout(ServerHttpSecurity.LogoutSpec::disable)
                .addFilterBefore(authFilter, SecurityWebFiltersOrder.AUTHORIZATION);
        return http.build();
    }

    /**
     * 跨域具体配置
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(Arrays.asList(
                "http://localhost:5173", // Vue/Vite 本地
                "http://192.168.150.105"
        ));
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 对所有路径应用此配置
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}