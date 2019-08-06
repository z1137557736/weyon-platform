package com.weyon.framework.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuxu
 * @description 客户端工具类
 * @date 2019-05-19
 **/
public class ClientUtil {

    public static String getClientIP(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null){
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }

}
