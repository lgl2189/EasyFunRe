package com.star.easyfun.common.service;

import org.springframework.security.oauth2.jwt.Jwt;

public interface JWTCommonService {

    /**
     * 验证 Token
     *
     * @param token 要解析的token
     * @return 解析后的JWT
     */
    Jwt validateToken(String token);

    /**
     * 生成微服务内部通信使用的摘要信息，放在请求头，使用HMAC-SHA256进行签名，保证请求体没有被篡改
     *
     * @param payload 请求体，建议使用Json序列化后的String。
     * @return 生成的内部签名Token
     */
    String generateHmacSHA256(String payload);

    /**
     * 校验HMAC-SHA256摘要信息是否正确
     *
     * @param payload         待校验的数据
     * @param expectedHmacHex 待校验的摘要信息
     * @return 校验结果
     */
    boolean validateHmacSHA256(String payload, String expectedHmacHex);

}
