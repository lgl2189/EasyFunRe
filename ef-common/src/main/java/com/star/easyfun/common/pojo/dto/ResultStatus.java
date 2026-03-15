package com.star.easyfun.common.pojo.dto;

import jakarta.validation.Payload;
import lombok.Getter;

/**
 * 业务状态码 Payload 容器
 * 所有校验注解的 payload 参数都使用这里的内部接口
 */
@SuppressWarnings("unused")
public final class ResultStatus {

    // 私有构造，防止实例化
    private ResultStatus() {
    }

    // ===================== 2xxxx 客户端错误 =====================
    /**
     * 通用参数错误
     */
    public static class Status20000 implements Payload {
        @Getter
        private static final String code = "20000";
    }

    /**
     * 缺少必填参数
     */
    public static class Status20001 implements Payload {
        @Getter
        private static final String code = "20001";
    }

    /**
     * 参数格式错误
     */
    public static class Status20002 implements Payload {
        @Getter
        private static final String code = "20002";
    }

    /**
     * 参数值超出范围
     */
    public static class Status20003 implements Payload {
        @Getter
        private static final String code = "20003";
    }

    /**
     * 重复提交
     */
    public static class Status20004 implements Payload {
        @Getter
        private static final String code = "20004";
    }

    /**
     * 值本身错误
     */
    public static class Status20005 implements Payload {
        @Getter
        private static final String code = "20005";
    }

    // ===================== 3xxxx 认证与授权错误 =====================

    /**
     * 无权限操作
     */
    public static class Status30000 implements Payload {
        @Getter
        private static final String code = "30000";
    }

    /**
     * 未提供Token
     */
    public static class Status30001 implements Payload {
        @Getter
        private static final String code = "30001";
    }

    /**
     * Token无效
     */
    public static class Status30002 implements Payload {
        @Getter
        private static final String code = "30002";
    }

    /**
     * Token已过期
     */
    public static class Status30003 implements Payload {
        @Getter
        private static final String code = "30003";
    }

    /**
     * 用户账户被禁止操作
     */
    public static class Status30004 implements Payload {
        @Getter
        private static final String code = "30004";
    }

    // ===================== 4xxxx 资源错误模块 =====================

    /**
     * 资源不存在
     */
    public static class Status40000 implements Payload {
        @Getter
        private static final String code = "40000";
    }
}