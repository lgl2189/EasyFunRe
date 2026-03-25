package com.star.easyfun.user.pojo.mapper;

import com.star.easyfun.user.pojo.dbo.UserBasicDBO;
import com.star.easyfun.user.pojo.dbo.UserProfileDBO;
import com.star.easyfun.user.pojo.dto.UserAllInfoDTO;
import com.star.easyfun.user.pojo.dto.UserPublicInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author ：Star
 * @description ：    与UserBasicDBO有关的数据转换
 * @date ：2026 3月 06 17:17
 */

@Mapper(componentModel = "spring")
public interface UserStructMapper {
    @Mapping(target = "userId",source = "userBasicDBO.userId")
    @Mapping(target = "username",source = "userBasicDBO.username")
    UserAllInfoDTO fromUserDBOUnit(UserBasicDBO userBasicDBO, UserProfileDBO userProfileDBO);

    UserPublicInfoDTO fromUserProfileDBO(UserProfileDBO userProfileDBO);

    UserBasicDBO fromUserAllInfoDTOToBasicDBO(UserAllInfoDTO userAllInfoDTO);

    UserProfileDBO fromUserAllInfoDTOToProfileDBO(UserAllInfoDTO userAllInfoDTO);
}