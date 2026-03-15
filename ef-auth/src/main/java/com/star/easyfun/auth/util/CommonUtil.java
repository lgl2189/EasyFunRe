package com.star.easyfun.auth.util;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author ：Star
 * @description ：    存储一些通用的工具方法
 * @date ：2026 2月 25 22:21
 */

@Component
public class CommonUtil {
    public static String generateRandomUsername() {
        int length = 20;
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            // 生成 0-9 的随机数字
            int digit = new Random().nextInt(10);
            builder.append(digit);
        }
        return "easyfun_" + builder;
    }
}