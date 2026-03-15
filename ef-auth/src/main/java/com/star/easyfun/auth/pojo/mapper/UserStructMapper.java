package com.star.easyfun.auth.pojo.mapper;

import com.star.easyfun.auth.pojo.dbo.UserBasicDBO;
import com.star.easyfun.common.pojo.dto.TokenPayLoad;
import org.mapstruct.Mapper;

/**
 * @author ：Star
 * @description ：    与UserBasicDBO有关的数据转换
 * @date ：2026 3月 06 17:17
 */

@Mapper(componentModel = "spring")
public interface UserStructMapper {

    TokenPayLoad userBasicDBOToJWTPayLoad(UserBasicDBO userBasicDBO);
}