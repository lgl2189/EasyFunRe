package util;

import com.star.easyfun.common.util.RSAHelper;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 * @author ：Star
 * @description ：    测试RSAUtil工具类
 * @date ：2026 3月 03 17:37
 */


public class TestRSAUtil {
    public static void main(String[] args) {
        // 1. 生成 RSA 密钥对
        KeyPair keyPair = RSAHelper.generateRSAKeyPair(2048);

        // 2. 获取公钥和私钥
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // 3. 转换为 PEM 格式字符串（带头部和尾部）
        String publicKeyPem = "-----BEGIN PUBLIC KEY-----\n" +
                Base64.getMimeEncoder(64, "\n".getBytes()).encodeToString(publicKey.getEncoded()) +
                "\n-----END PUBLIC KEY-----";

        String privateKeyPem = "-----BEGIN PRIVATE KEY-----\n" +
                Base64.getMimeEncoder(64, "\n".getBytes()).encodeToString(privateKey.getEncoded()) +
                "\n-----END PRIVATE KEY-----";

        // 4. 输出，复制到配置中心
        System.out.println("公钥：\n" + publicKeyPem);
        System.out.println("\n私钥：\n" + privateKeyPem);
    }
}