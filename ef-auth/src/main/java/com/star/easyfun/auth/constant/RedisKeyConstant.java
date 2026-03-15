package com.star.easyfun.auth.constant;

import lombok.Data;

/**
 * @author ：Star
 * @description ：    用于储存Redis的key的常量类
 * @date ：2025 11月 17 16:49
 */

@Data
public class RedisKeyConstant {
    public static final String SMS_COUNT = "sms:count";
    public static final String SMS_CODE = "sms:code";

    /**
     * 获取SMS验证码计数的redis key，使用ip作为key
     *
     * @param ip       用户的ip
     * @param fingerprint 设备环境指纹
     * @return sms缓存的Redis key
     */
    public static String getSmsCountKey(String ip, String fingerprint, String phone) {
        return SMS_COUNT + ":" + ip + ":" + fingerprint + ":" + phone;
    }

    /**
     * 获取SMS验证码的redis key，使用ip作为key
     *
     * @param ip       用户的ip
     * @param fingerprint 设备环境指纹
     * @param phone    手机号
     * @return sms缓存的Redis key
     */
    public static String getSmsCodeKey(String ip, String fingerprint, String phone) {
        return SMS_CODE + ":" + ip + ":" + fingerprint + ":" + phone;
    }
}