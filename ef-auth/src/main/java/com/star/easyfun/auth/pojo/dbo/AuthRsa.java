package com.star.easyfun.auth.pojo.dbo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 存储平台注册用户的基础信息，是所有用户行为的关联核心(auth_rsa)实体类
 *
 * @author Star
 * @since 2026-03-01 21:48:41
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("auth_rsa")
public class AuthRsa implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * RSA记录唯一标识，自增主键
     */
    @TableId
	private Long rsaId;
    /**
     * 存储RSA密钥对序列化后的二进制对象
     */
    private Object rasBlob;
    /**
     * 该RSA密钥生成时间
     */
    private LocalDateTime createDatetime;
    /**
     * 该RSA密钥被设置为失效的时间
     */
    private LocalDateTime deleteDatetime;
    /**
     * 0 - 正常，1 - 已删除
     */
    private Integer isDelete;

}