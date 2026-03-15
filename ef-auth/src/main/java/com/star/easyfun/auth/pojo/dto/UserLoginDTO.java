package com.star.easyfun.auth.pojo.dto;

import com.star.easyfun.common.pojo.dto.ResultStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author ：Star
 * @description ：    存储用户登录请求的数据
 * @date ：2026 2月 24 18:14
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO {

    @NotBlank(message = "用户名不能为空", payload = ResultStatus.Status20001.class)
    @Size(max = 50, message = "用户名长度不能超过50个字符", payload = ResultStatus.Status20003.class)
    private String username;

    @NotBlank(message = "密码不能为空", groups = {PassLogin.class, EmailLogin.class}, payload = ResultStatus.Status20001.class)
    @Size(min = 8, max = 18, message = "密码长度范围不符合8-18", groups = {PassLogin.class, EmailLogin.class}, payload = ResultStatus.Status20003.class)
    private String password;

    @NotBlank(message = "手机号不能为空", groups = {PhoneLogin.class, SmsGetCode.class, PassLogin.class}, payload = ResultStatus.Status20001.class)
    @Size(min = 11, max = 11, message = "手机号长度只能为11个字符", groups = {PhoneLogin.class, SmsGetCode.class, PassLogin.class}, payload = ResultStatus.Status20003.class)
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确", groups = {PhoneLogin.class, SmsGetCode.class, PassLogin.class}, payload = ResultStatus.Status20002.class)
    private String phone;

    @NotBlank(message = "手机验证码不能为空", groups = PhoneLogin.class, payload = ResultStatus.Status20001.class)
    @Pattern(regexp = "^\\d{6}$", message = "手机验证码必须是6位数字", groups = PhoneLogin.class, payload = ResultStatus.Status20002.class)
    private String smsCode;

    @NotBlank(message = "邮箱不能为空", groups = EmailLogin.class, payload = ResultStatus.Status20001.class)
    @Size(max = 100, message = "邮箱长度不能超过100个字符", groups = EmailLogin.class, payload = ResultStatus.Status20003.class)
    @Email(message = "邮箱格式不正确", groups = EmailLogin.class, payload = ResultStatus.Status20002.class)
    private String email;

    public interface PassLogin {
    }

    public interface SmsGetCode {
    }

    public interface PhoneLogin {
    }

    public interface EmailLogin {
    }
}