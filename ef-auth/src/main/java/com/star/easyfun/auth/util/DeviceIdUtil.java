package com.star.easyfun.auth.util;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author ：Star
 * @description ：设备Id相关工具类
 * @date ：2026 3月 14 13:58
 */

public class DeviceIdUtil {
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    /**
     * 生成设备码
     * 格式：Base64URL(SHA256(时间戳-随机数))
     * @return 设备码 (约43字符)
     */
    public static String generate() {
        // 1. 获取当前时间戳（毫秒）
        long timestamp = System.currentTimeMillis();

        // 2. 生成一个强随机的长整型数
        long randomNum = SECURE_RANDOM.nextLong();

        // 3. 拼接原始字符串
        String rawInput = timestamp + "-" + randomNum;

        // 4. 使用 Guava 进行 SHA-256 哈希
        byte[] hashBytes = Hashing.sha256()
                .hashString(rawInput, StandardCharsets.UTF_8)
                .asBytes();

        // 5. 转换为 URL 安全的 Base64 字符串（去掉填充字符 '='）
        return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(hashBytes);
    }

    public static void main(String[] args) {
        String deviceCode = DeviceIdUtil.generate();
        System.out.println("生成的设备码: " + deviceCode);
        System.out.println("设备码长度: " + deviceCode.length());
    }
}