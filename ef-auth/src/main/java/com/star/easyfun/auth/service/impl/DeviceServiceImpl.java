package com.star.easyfun.auth.service.impl;

import com.star.easyfun.auth.service.DeviceService;
import com.star.easyfun.auth.util.DeviceIdUtil;
import com.star.easyfun.common.constant.CommonRedisKey;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author ：Star
 * @description ：无描述
 * @date ：2026 3月 14 14:03
 */

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean checkDeviceId(String userId, String deviceId) {
        String key = CommonRedisKey.getDeviceIdKey(userId);
        if (!redisTemplate.hasKey(key)) {
            return true;
        }
        if (Boolean.FALSE.equals(redisTemplate.opsForSet().isMember(key, deviceId))) {
            return true;
        }
        return false;
    }

    @Override
    public void cacheDeviceId(String userId, String deviceId) {
        String key = CommonRedisKey.getDeviceIdKey(userId);
        redisTemplate.opsForSet().add(key, deviceId);
    }

    @Override
    public String generateDeviceId(String userId) {
        String newDeviceId = DeviceIdUtil.generate();
        while (!checkDeviceId(userId, newDeviceId)) {
            newDeviceId = DeviceIdUtil.generate();
        }
        cacheDeviceId(userId, newDeviceId);
        return newDeviceId;
    }

    @Override
    public void removeDeviceId(String userId, String deviceId) {
        String key = CommonRedisKey.getDeviceIdKey(userId);
        redisTemplate.opsForSet().remove(key, deviceId);
    }
}