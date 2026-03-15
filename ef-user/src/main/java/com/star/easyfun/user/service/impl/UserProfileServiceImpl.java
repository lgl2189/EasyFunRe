package com.star.easyfun.user.service.impl;

import com.star.easyfun.user.mapper.UserProfileMapper;
import com.star.easyfun.user.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 存储用户的详细个人信息，包括昵称、头像、简介等扩展信息服务接口实现
 *
 * @author Star
 * @since 2026-02-24 14:47:13
 * @description 
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileMapper userProfileMapper;

}