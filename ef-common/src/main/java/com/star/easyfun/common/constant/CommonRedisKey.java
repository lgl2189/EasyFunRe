package com.star.easyfun.common.constant;

/**
 * @author ：Star
 * @description ：各模块共用的Redis Key的常量类
 * @date ：2026 3月 04 19:12
 */


public class CommonRedisKey {
    public static final String JWT_BLACK_ACCESS_TOKEN = "jwt:access_token:blacklist";
    public static final String JWT_REFRESH_TOKEN = "jwt:refresh_token";
    public static final String DEVICE_ID = "device:id";

    /**
     * 获取AccessToken黑名单的redis key
     *
     * @param userId   用户id
     * @param deviceId 设备
     * @return AccessToken的Redis key
     */
    public static String getJwtBlackAccessTokenKey(String userId, String deviceId) {
        return JWT_BLACK_ACCESS_TOKEN + ":" + userId + ":" + deviceId;
    }

    /**
     * 获取RefreshToken的redis key
     *
     * @param userId   用户id
     * @param deviceId 设备
     * @return RefreshToken的Redis key
     */
    public static String getJwtRefreshTokenKey(String userId, String deviceId) {
        return JWT_REFRESH_TOKEN + ":" + userId + ":" + deviceId;
    }

    /**
     * 获取设备id的redis key
     * @param userId 用户id
     * @return 设备id的Redis key
     */
    public static String getDeviceIdKey(String userId) {
        return DEVICE_ID + ":" + userId;
    }
}