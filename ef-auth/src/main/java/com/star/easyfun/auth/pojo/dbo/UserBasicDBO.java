package com.star.easyfun.auth.pojo.dbo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 存储平台注册用户的基础信息，是所有用户行为的关联核心(user_basic)实体类
 *
 * @author Star
 * @since 2026-02-24 14:47:13
 * @description 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("user_basic")
public class UserBasicDBO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户唯一标识，自增主键
     */
    @TableId
	private Long userId;
    /**
     * 用户登录用户名，唯一
     */
    private String username;
    /**
     * 用户密码（支持bcrypt/Argon2等安全算法，MD5仅作兼容）
     */
    private String password;
    /**
     * 用户注册手机号，必须
     */
    private String phone;
    /**
     * 用户注册邮箱，可选
     */
    private String email;
    /**
     * 1-正常，2-禁用，3-待审核
     */
    private Integer status;
    /**
     * 用户注册时间
     */
    private LocalDateTime registerDatetime;
    /**
     * 用户最后登录时间
     */
    private LocalDateTime lastLoginDatetime;
    /**
     * 0-正常，1-已删除
     */
    private Integer isDelete;

}