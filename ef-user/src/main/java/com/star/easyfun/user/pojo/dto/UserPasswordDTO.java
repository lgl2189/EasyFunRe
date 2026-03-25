package com.star.easyfun.user.pojo.dto;

import com.star.easyfun.common.pojo.dto.ResultStatus;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author ：Star
 * @description ：无描述
 * @date ：2026 3月 20 23:03
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserPasswordDTO {
    /**
     * 用户唯一标识，自增主键
     */
    private String userId;
    /**
     * 旧用户密码
     */
    private String oldPassword;
    /**
     * 新用户密码
     */
    @Size(min = 8, max = 18, message = "新密码长度范围不符合8-18", payload = ResultStatus.Status20003.class)
    private String newPassword;
}