package com.star.easyfun.user.pojo.dbo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 存储用户的详细个人信息，包括昵称、头像、简介等扩展信息(user_profile)实体类
 *
 * @author Star
 * @since 2026-02-24 14:47:13
 * @description 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("user_profile")
public class UserProfileDBO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 资料记录唯一标识，自增主键
     */
    @TableId
	private Long profileId;
    /**
     * 关联用户基础信息表的user_id
     */
    private Long userId;
    /**
     * 用户显示昵称
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
     * 用户出生日期
     */
    private LocalDate birthday;
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
     * 用户兴趣标签，用逗号分隔
     */
    private String interestTags;
    /**
     * 个人主页背景图片地址
     */
    private String bgImageUrl;
    /**
     * 资料最后更新时间
     */
    private LocalDateTime updateDatetime;
    /**
     * 0-正常，1-已删除
     */
    private Integer isDelete;

}