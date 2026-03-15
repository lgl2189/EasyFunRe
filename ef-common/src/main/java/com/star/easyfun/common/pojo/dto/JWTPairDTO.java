package com.star.easyfun.common.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author ：Star
 * @description ：    存储AccessToken和RefreshToken
 * @date ：2026 3月 03 20:38
 */


@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class JWTPairDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 访问令牌
     */
    private String accessToken;
    /**
     * 刷新令牌
     */
    private String refreshToken;
}