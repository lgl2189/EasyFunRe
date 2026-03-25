package com.star.easyfun.user.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author ：Star
 * @description ：无描述
 * @date ：2026 3月 20 18:00
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserPublicInfoDTO {
    /**
     * 用户唯一标识，自增主键
     */
    private Long userId;
    /**
     * 用户登录用户名，唯一
     */
    private String username;

    /**
     * 用户头像图片地址
     */
    private String avatarUrl;
    /**
     * 0-未知，1-男，2-女
     */
    private Integer gender;
    /**
     * 用户个人简介，最多500字
     */
    private String introduction;
    /**
     * 用户当前常用ip所在地区
     */
    private String currentArea;
    /**
     * 用户当前常用ip（兼容IPv4/IPv6）
     */
    private String currentIp;
    /**
     * 个人主页背景图片地址
     */
    private String bgImageUrl;
}