package com.star.easyfun.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.star.easyfun.user.pojo.dbo.UserProfileDBO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 存储用户的详细个人信息，包括昵称、头像、简介等扩展信息(user_profile)数据Mapper
 *
 * @author Star
 * @since 2026-02-24 14:47:13
 * @description 
*/
@Mapper
public interface UserProfileMapper extends BaseMapper<UserProfileDBO> {

}
