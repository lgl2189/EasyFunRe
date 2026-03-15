package com.star.easyfun.auth.service;

/**
 * @author ：Star
 * @description ：    与Sms相关服务接口实现
 * @date ：2026 2月 24 20:10
 */

public interface SmsService {

    /**
     * 首先检验验证码发送次数是否超过上限，若未超过上限发送一条手机短信验证码，并缓存验证码到Redis。
     *
     * @param ip          用户的 ip
     * @param fingerprint 用户的设备 id
     * @return true 表示发送成功，false 表示验证码发送次数超过上限
     */
    boolean postSmsCode(String phone, String ip, String fingerprint);

    /**
     * 验证短信验证码
     *
     * @param phone       手机号
     * @param ip          用户的 ip
     * @param fingerprint 用户的设备 id
     * @param inputCode   用户输入的验证码
     * @return true 验证成功，false 验证失败
     */
    boolean verifySmsCode(String phone, String ip, String fingerprint, String inputCode);
}
