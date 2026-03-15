package com.star.easyfun.gateway.service.impl;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author ：Star
 * @description ：仅用于占位的UserDetailService实现类，用于关闭自动生成随机密码的默认账户
 * @date ：2026 3月 12 11:13
 */

@Service
public class UserDetailServiceImpl implements ReactiveUserDetailsService {


    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return Mono.error(new UsernameNotFoundException("仅占位，不查询用户"));
    }
}