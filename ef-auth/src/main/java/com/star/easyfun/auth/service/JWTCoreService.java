package com.star.easyfun.auth.service;

import com.star.easyfun.auth.pojo.dbo.UserBasicDBO;
import com.star.easyfun.common.pojo.dto.JWTPairDTO;

public interface JWTCoreService {
    /**
     * 根据提供的用户信息，生成AccessToken和RefreshToken
     *
     * @param userLoginDTO 要生成JWT对的用户的信息
     * @param deviceId     设备ID
     * @return 生成的JWT对
     */
    JWTPairDTO generateJWTPair(UserBasicDBO userLoginDTO, String deviceId) throws Exception;

    /**
     * 刷新AccessToken
     *
     * @param refreshToken 要解析的RefreshToken
     * @return 刷新成功，返回新的Token。如果刷新失败，则返回null
     */
    JWTPairDTO refreshToken(String refreshToken, String deviceId) throws Exception;

    /**
     * 使Token无效化
     *
     * @param accessToken  访问令牌
     * @param refreshToken 刷新令牌
     * @return 是否成功
     */
    boolean deactivateToken(String accessToken, String refreshToken, String deviceId);
}
