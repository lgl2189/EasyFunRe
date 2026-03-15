package com.star.easyfun.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.star.easyfun.auth.mapper.UserBasicMapper;
import com.star.easyfun.auth.pojo.dbo.UserBasicDBO;
import com.star.easyfun.auth.pojo.dto.UserLoginDTO;
import com.star.easyfun.auth.service.UserBasicService;
import com.star.easyfun.auth.util.CommonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 存储平台注册用户的基础信息，是所有用户行为的关联核心服务接口实现
 *
 * @author Star
 * @description
 * @since 2026-02-24 14:47:13
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class UserBasicServiceImpl implements UserBasicService {

    private final UserBasicMapper userBasicMapper;

    @Override
    public boolean checkPhoneExist(String phone) {
        LambdaQueryWrapper<UserBasicDBO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserBasicDBO::getPhone, phone);
        UserBasicDBO userBasicDBO = userBasicMapper.selectOne(queryWrapper);
        return userBasicDBO != null;
    }

    @Override
    public boolean register(String phone) {
        String username = CommonUtil.generateRandomUsername();
        UserBasicDBO userBasicDBO = new UserBasicDBO()
                .setUsername(username)
                .setPhone(phone)
                .setStatus(1)
                .setRegisterDatetime(LocalDateTime.now())
                .setIsDelete(0);
        int isSuccess = userBasicMapper.insert(userBasicDBO);
        return isSuccess == 1;
    }

    @Override
    public UserBasicDBO login(UserLoginDTO userLoginDTO) {
        if (userLoginDTO.getPhone() != null) {
            LambdaQueryWrapper<UserBasicDBO> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(UserBasicDBO::getPhone, userLoginDTO.getPhone());
            UserBasicDBO result = userBasicMapper.selectOne(queryWrapper);
            if (result != null) {
                return result;
            }
        }
        if (userLoginDTO.getUsername() != null) {
            LambdaQueryWrapper<UserBasicDBO> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(UserBasicDBO::getUsername, userLoginDTO.getUsername());
            UserBasicDBO result = userBasicMapper.selectOne(queryWrapper);
            if (result != null) {
                return result;
            }
        }
        if (userLoginDTO.getEmail() != null) {
            LambdaQueryWrapper<UserBasicDBO> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(UserBasicDBO::getEmail, userLoginDTO.getEmail());
            return userBasicMapper.selectOne(queryWrapper);
        }
        return null;
    }
}