package com.star.easyfun.auth.service;

public interface DeviceService {

    /**
     * 检查设备码是否与该用户的其他设备码冲突
     *
     * @param userId 用户ID
     * @param deviceId 需要检查的设备码
     * @return true：设备码可用，false：设备码冲突
     */
    boolean checkDeviceId(String userId, String deviceId);

    /**
     * 缓存设备码
     * @param userId 用户ID
     * @param deviceId 设备码
     */
    void cacheDeviceId(String userId, String deviceId);

    /**
     * 生成新的设备码，保证生成的设备码不与已有的冲突
     * @param userId 用户ID
     * @return 新的设备码
     */
    String generateDeviceId(String userId);

    /**
     * 删除设备码
     * @param userId 用户ID
     * @param deviceId 设备码
     */
    void removeDeviceId(String userId, String deviceId);
}
