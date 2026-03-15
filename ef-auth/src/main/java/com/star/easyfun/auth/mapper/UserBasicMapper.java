package com.star.easyfun.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.star.easyfun.auth.pojo.dbo.UserBasicDBO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 存储平台注册用户的基础信息，是所有用户行为的关联核心(user_basic)数据Mapper
 *
 * @author Star
 * @since 2026-02-24 14:47:13
 * @description 
*/
@Mapper
public interface UserBasicMapper extends BaseMapper<UserBasicDBO> {

}
