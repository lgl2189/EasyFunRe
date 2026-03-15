package com.star.easyfun.auth.service;


import com.star.easyfun.auth.pojo.dbo.UserBasicDBO;
import com.star.easyfun.auth.pojo.dto.UserLoginDTO;

/**
 * 存储平台注册用户的基础信息，是所有用户行为的关联核心服务接口
 *
 * @author Star
 * @description
 * @since 2026-02-24 14:47:13
 */
public interface UserBasicService {
    /**
     * 检查手机号是否已注册
     *
     * @param phone 手机号
     * @return true 已存在，false 不存在
     */
    boolean checkPhoneExist(String phone);

    /**
     * 注册用户
     *
     * @param phone 手机号
     * @return true 注册成功，false 注册失败
     */
    boolean register(String phone);

    /**
     * 对完成验证的用户进行登录，返回用户信息，与登陆方式无关
     * @param userLoginDTO 包含用户手机号或账号的UserBasicDTO对象，至少要包含一种登陆方式标志身份的信息，否则无法查询。
     *                     如果提供了多种可以标志身份的信息，以手机号、uid、邮箱的顺序进行查询，如果查询到用户，则不再使用下一个信息进行查询。
     * @return 查询到的用户信息
     */
    UserBasicDBO login(UserLoginDTO userLoginDTO);

}
