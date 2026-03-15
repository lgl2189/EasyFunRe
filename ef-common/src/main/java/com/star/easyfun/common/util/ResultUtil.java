package com.star.easyfun.common.util;

import com.star.easyfun.common.pojo.dto.Result;

/**
 * 该工具类用于创建不同状态的 Result 对象，统一处理接口响应结果
 * Result 对象包含数据、业务状态码、消息和时间戳，封装接口返回信息
 *
 * @author ：Star
 * @description ：业务码分层：1xxxx成功/2xxxx客户端错误/3xxxx认证授权错误/4xxxx资源错误
 * @date ：2024/10/27 下午2:15
 */
@SuppressWarnings("unused")
public class ResultUtil {

    // ====================== 1xxxx 成功模块 ======================

    /**
     * 创建状态码为10000的成功Result对象，操作成功
     *
     * @param data    要封装的业务数据
     * @param message 自定义返回消息
     * @return 状态码10000的成功Result对象
     */
    public static Result success_10000(Object data, String message) {
        return create(data, "10000", message);
    }

    /**
     * 创建状态码为10000的成功Result对象，操作成功（data固定为null）
     *
     * @param message 自定义返回消息
     * @return 状态码10000的成功Result对象
     */
    public static Result success_10000(String message) {
        return success_10000(null, message);
    }

    // ====================== 2xxxx 客户端错误模块 ======================

    /**
     * 创建状态码为20000的失败Result对象，通用参数错误
     *
     * @param data    要封装的业务数据
     * @param message 自定义返回消息
     * @return 状态码20000的失败Result对象
     */
    public static Result fail_20000(Object data, String message) {
        return create(data, "20000", message);
    }

    /**
     * 创建状态码为20000的失败Result对象，通用参数错误（data固定为null）
     *
     * @param message 自定义返回消息
     * @return 状态码20000的失败Result对象
     */
    public static Result fail_20000(String message) {
        return fail_20000(null, message);
    }

    /**
     * 创建状态码为20001的失败Result对象，缺少必填参数
     *
     * @param data    要封装的业务数据
     * @param message 自定义返回消息
     * @return 状态码20001的失败Result对象
     */
    public static Result fail_20001(Object data, String message) {
        return create(data, "20001", message);
    }

    /**
     * 创建状态码为20001的失败Result对象，缺少必填参数（data固定为null）
     *
     * @param message 自定义返回消息
     * @return 状态码20001的失败Result对象
     */
    public static Result fail_20001(String message) {
        return fail_20001(null, message);
    }

    /**
     * 创建状态码为20002的失败Result对象，参数格式错误
     *
     * @param data    要封装的业务数据
     * @param message 自定义返回消息
     * @return 状态码20002的失败Result对象
     */
    public static Result fail_20002(Object data, String message) {
        return create(data, "20002", message);
    }

    /**
     * 创建状态码为20002的失败Result对象，参数格式错误（data固定为null）
     *
     * @param message 自定义返回消息
     * @return 状态码20002的失败Result对象
     */
    public static Result fail_20002(String message) {
        return fail_20002(null, message);
    }

    /**
     * 创建状态码为20003的失败Result对象，参数值超出范围
     *
     * @param data    要封装的业务数据
     * @param message 自定义返回消息
     * @return 状态码20003的失败Result对象
     */
    public static Result fail_20003(Object data, String message) {
        return create(data, "20003", message);
    }

    /**
     * 创建状态码为20003的失败Result对象，参数值超出范围（data固定为null）
     *
     * @param message 自定义返回消息
     * @return 状态码20003的失败Result对象
     */
    public static Result fail_20003(String message) {
        return fail_20003(null, message);
    }

    /**
     * 创建状态码为20004的失败Result对象，重复提交
     *
     * @param data    要封装的业务数据
     * @param message 自定义返回消息
     * @return 状态码20004的失败Result对象
     */
    public static Result fail_20004(Object data, String message) {
        return create(data, "20004", message);
    }

    /**
     * 创建状态码为20004的失败Result对象，重复提交（data固定为null）
     *
     * @param message 自定义返回消息
     * @return 状态码20004的失败Result对象
     */
    public static Result fail_20004(String message) {
        return fail_20004(null, message);
    }

    /**
     * 创建状态码为20005的失败Result对象，提交的参数本身是错误的
     *
     * @param data    要封装的业务数据
     * @param message 自定义返回消息
     * @return 状态码20004的失败Result对象
     */
    public static Result fail_20005(Object data, String message) {
        return create(data, "20005", message);
    }

    /**
     * 创建状态码为20005的失败Result对象，提交的参数本身是错误的
     *
     * @param message 自定义返回消息
     * @return 状态码20004的失败Result对象
     */
    public static Result fail_20005(String message) {
        return fail_20005(null, message);
    }

    // ====================== 3xxxx 认证与授权错误模块 ======================

    /**
     * 创建状态码为30000的失败Result对象，无权限操作
     *
     * @param data    要封装的业务数据
     * @param message 自定义返回消息
     * @return 状态码30000的失败Result对象
     */
    public static Result fail_30000(Object data, String message) {
        return create(data, "30000", message);
    }

    /**
     * 创建状态码为30000的失败Result对象，无权限操作（data固定为null）
     *
     * @param message 自定义返回消息
     * @return 状态码30000的失败Result对象
     */
    public static Result fail_30000(String message) {
        return fail_30000(null, message);
    }

    /**
     * 创建状态码为30001的失败Result对象，未提供Token
     *
     * @param data    要封装的业务数据
     * @param message 自定义返回消息
     * @return 状态码30001的失败Result对象
     */
    public static Result fail_30001(Object data, String message) {
        return create(data, "30001", message);
    }

    /**
     * 创建状态码为30001的失败Result对象，未提供Token（data固定为null）
     *
     * @param message 自定义返回消息
     * @return 状态码30001的失败Result对象
     */
    public static Result fail_30001(String message) {
        return fail_30001(null, message);
    }

    /**
     * 创建状态码为30002的失败Result对象，Token无效
     *
     * @param data    要封装的业务数据
     * @param message 自定义返回消息
     * @return 状态码30002的失败Result对象
     */
    public static Result fail_30002(Object data, String message) {
        return create(data, "30002", message);
    }

    /**
     * 创建状态码为30002的失败Result对象，Token无效（data固定为null）
     *
     * @param message 自定义返回消息
     * @return 状态码30002的失败Result对象
     */
    public static Result fail_30002(String message) {
        return fail_30002(null, message);
    }

    /**
     * 创建状态码为30003的失败Result对象，Token已过期
     *
     * @param data    要封装的业务数据
     * @param message 自定义返回消息
     * @return 状态码30003的失败Result对象
     */
    public static Result fail_30003(Object data, String message) {
        return create(data, "30003", message);
    }

    /**
     * 创建状态码为30003的失败Result对象，Token已过期（data固定为null）
     *
     * @param message 自定义返回消息
     * @return 状态码30003的失败Result对象
     */
    public static Result fail_30003(String message) {
        return fail_30003(null, message);
    }

    /**
     * 创建状态码为30004的失败Result对象，用户账户已被禁止该操作
     *
     * @param data    要封装的业务数据
     * @param message 自定义返回消息
     * @return 状态码30004的失败Result对象
     */
    public static Result fail_30004(Object data, String message) {
        return create(data, "30004", message);
    }

    /**
     * 创建状态码为30004的失败Result对象，用户账户已被禁止该操作（data固定为null）
     *
     * @param message 自定义返回消息
     * @return 状态码30004的失败Result对象
     */
    public static Result fail_30004(String message) {
        return fail_30004(null, message);
    }

    // ====================== 4xxxx 资源错误模块 ======================

    /**
     * 创建状态码为40000的失败Result对象，资源不存在
     *
     * @param data    要封装的业务数据
     * @param message 自定义返回消息
     * @return 状态码40000的失败Result对象
     */
    public static Result fail_40000(Object data, String message) {
        return create(data, "40000", message);
    }

    /**
     * 创建状态码为40000的失败Result对象，资源不存在（data固定为null）
     *
     * @param message 自定义返回消息
     * @return 状态码40000的失败Result对象
     */
    public static Result fail_40000(String message) {
        return fail_40000(null, message);
    }

    // ====================== 5xxxx 资源错误模块 ======================

    /**
     * 创建状态码为50000的失败Result对象，系统内部错误
     *
     * @param data    要封装的业务数据
     * @param message 自定义返回消息
     * @return 状态码50000的失败Result对象
     */
    public static Result fail_50000(Object data, String message) {
        return create(data, "50000", message);
    }

    /**
     * 创建状态码为50000的失败Result对象，系统内部错误（data固定为null）
     *
     * @param message 自定义返回消息
     * @return 状态码50000的失败Result对象
     */
    public static Result fail_50000(String message) {
        return fail_50000(null, message);
    }

    /**
     * 底层通用创建方法，统一生成Result对象，自动填充毫秒级时间戳
     *
     * @param data    要封装在 Result 对象中的数据
     * @param status  业务状态码
     * @param message 要返回的消息
     * @return 包含指定数据、状态码和消息的 Result 对象
     */
    public static Result create(Object data, String status, String message) {
        return new Result(data, status, message, String.valueOf(System.currentTimeMillis()));
    }
}