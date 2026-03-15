package com.star.easyfun.auth.util;

import com.star.easyfun.common.constant.CommonRequestHeader;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @author ：Star
 * @description ：    跟请求有关的工具方法
 * @date ：2026 2月 25 20:42
 */


public class RequestUtil {
    /**
     * 获取客户端真实 IP 地址
     * 处理了 Nginx 等反向代理的情况
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP
        if (ip != null && ip.contains(",")) {
            return ip.split(",")[0].trim();
        }
        return ip;
    }

    public static String getDeviceId(HttpServletRequest request){
        return request.getHeader(CommonRequestHeader.HEADER_DEVICE_ID);
    }

    public static String getFingerprint(HttpServletRequest request){
        return request.getHeader(CommonRequestHeader.HEADER_FINGERPRINT);
    }
}