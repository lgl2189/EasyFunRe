package com.star.easyfun.common.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author ：Star
 * @description ：    用户所有需要存储到jwt中的信息
 * @date ：2026 3月 06 15:19
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class TokenPayLoad implements UserDetails {
    private String userId;
    private String phone;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}