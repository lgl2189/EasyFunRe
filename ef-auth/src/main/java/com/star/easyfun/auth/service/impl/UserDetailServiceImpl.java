package com.star.easyfun.auth.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author ：Star
 * @description ：仅用于占位的UserDetailService实现类，用于关闭自动生成随机密码的默认账户
 * @date ：2026 3月 12 11:13
 */

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        throw new RuntimeException("仅占位，不查询用户");
    }
}