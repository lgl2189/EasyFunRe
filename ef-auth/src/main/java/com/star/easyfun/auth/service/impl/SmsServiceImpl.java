package com.star.easyfun.auth.service.impl;

import com.star.easyfun.auth.constant.RedisKeyConstant;
import com.star.easyfun.auth.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author ：Star
 * @description ：    与Sms相关服务接口实现
 * @date ：2026 2月 24 20:10
 */

@Service
@RequiredArgsConstructor
public class SmsServiceImpl implements SmsService {

    private final RedisTemplate<String, Object> redisTemplate;

    private static final int countDuration = 86400;
    private static final int maxCount = 40;
    private static final int codeDuration = 300;

    @Override
    public boolean postSmsCode(String phone, String ip, String fingerprint) {
        // 验证码计数
        String key = RedisKeyConstant.getSmsCountKey(ip, fingerprint, phone);
        Long currentCount = redisTemplate.opsForValue().increment(key);
        if (currentCount == null || currentCount > maxCount) {
            return false;
        }
        else if (redisTemplate.getExpire(key) < 0) {
            redisTemplate.expire(key, countDuration, TimeUnit.SECONDS);
        }
        // 模拟发送验证码
        int code = new Random().nextInt(900000) + 100000;
        redisTemplate.opsForValue().set(RedisKeyConstant.getSmsCodeKey(ip, fingerprint, phone), String.valueOf(code), codeDuration, TimeUnit.SECONDS);
        return true;
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    public boolean verifySmsCode(String phone, String ip, String fingerprint, String inputCode) {
        String key = RedisKeyConstant.getSmsCodeKey(ip, fingerprint, phone);
        String realCode = (String) redisTemplate.opsForValue().get(key);
        if (realCode == null) {
            return false;
        }
        redisTemplate.delete(key);
        // 模拟验证码
        inputCode = "123456";
        realCode = "123456";
        return realCode.equals(inputCode);
    }
}