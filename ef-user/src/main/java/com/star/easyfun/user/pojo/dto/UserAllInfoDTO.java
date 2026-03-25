package com.star.easyfun.user.pojo.dto;

import com.star.easyfun.common.pojo.dto.ResultStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * @author ：Star
 * @description ：无描述
 * @date ：2026 3月 20 18:00
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserAllInfoDTO {
    /**
     * 用户唯一标识，自增主键
     */
    private String userId;
    /**
     * 用户登录用户名，唯一
     */
    @Size(max = 50, message = "用户名长度不能超过50个字符", groups = {UpdateInfo.class}, payload = ResultStatus.Status20003.class)
    private String username;
    /**
     * 用户密码（使用Bcrypt加密）
     */
    @Size(min = 8, max = 18, message = "密码长度范围不符合8-18", groups = {PasswordVerify.class}, payload = ResultStatus.Status20003.class)
    private String password;
    /**
     * 用户注册手机号，必须
     */
    @Size(min = 11, max = 11, message = "手机号长度只能为11个字符", groups = {UpdateInfo.class}, payload = ResultStatus.Status20003.class)
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确", groups = {UpdateInfo.class}, payload = ResultStatus.Status20002.class)
    private String phone;
    /**
     * 用户注册邮箱，可选
     */
    @Size(max = 100, message = "邮箱长度不能超过100个字符", groups = UpdateInfo.class, payload = ResultStatus.Status20003.class)
    @Email(message = "邮箱格式不正确", groups = UpdateInfo.class, payload = ResultStatus.Status20002.class)
    private String email;

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

    public interface PasswordVerify {
    }

    public interface UpdateInfo {
    }
}