package com.star.easyfun.common.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author ：Star
 * @description ：    自定义的RSA密钥对象，包含公钥、私钥和KeyID
 * @date ：2026 3月 04 14:54
 */

@Data
@Accessors(chain = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class CustomRSAKeyPair {
    private PublicKey publicKey;
    private PrivateKey privateKey;
    private String keyID;
}