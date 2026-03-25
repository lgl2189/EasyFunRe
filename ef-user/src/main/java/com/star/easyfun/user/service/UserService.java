package com.star.easyfun.user.service;


import com.star.easyfun.user.pojo.dto.UserAllInfoDTO;
import com.star.easyfun.user.pojo.dto.UserPasswordDTO;
import com.star.easyfun.user.pojo.dto.UserPublicInfoDTO;

/**
 * 存储用户的个人信息，包括昵称、头像、简介等扩展信息服务接口
 *
 * @author Star
 * @since 2026-02-24 14:47:13
 * @description 
 */
public interface UserService {
    /**
     * 获取用户所有信息，不包括敏感信息（密码）
     * @param userId 用户ID
     * @return 用户所有信息，不包括敏感信息（密码）
     */
    UserAllInfoDTO getUserAllInfo(String userId);

    /**
     * 获取用户的公开信息，包括昵称、头像、简介等
     * @param userId 用户ID
     * @return 用户的公开信息，包括昵称、头像、简介等
     */
    UserPublicInfoDTO getUserPublicInfo(String userId);

    /**
     * 更新用户所有信息
     *
     * @param userAllInfoDTO 用户所有需要更改的信息和userId，不需要修改需要设置为null
     * @return 是否更新成功
     */
    boolean updateUserAllInfo(UserAllInfoDTO userAllInfoDTO);

    /**
     * 更新用户密码
     * @param userPasswordDTO 包含用户id、用户旧密码和新密码的对象
     */
    boolean updateUserPassword(UserPasswordDTO userPasswordDTO);
}