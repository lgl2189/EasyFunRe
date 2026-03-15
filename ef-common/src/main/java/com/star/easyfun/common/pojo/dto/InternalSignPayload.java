package com.star.easyfun.common.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author ：Star
 * @description ：    存储了一段信息，用于微服务间内部通信安全校验，使用RSA加密这个类对象的Json，并将其设置到Easy-Fun-Internal-Sign-Payload请求头中
 * @date ：2026 3月 06 18:10
 */

@Data
@Accessors(chain = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class InternalSignPayload {
    private String issuer;
    // 使用SHA256进行摘要
    private String bodyHash;
    private String timestamp;
}