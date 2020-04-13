package com.weyon.security.hanlder;

import com.alibaba.fastjson.JSON;
import com.weyon.framework.handler.ObjectResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liuxu
 * @description 认证失败处理类，返回401
 * @date 2019-07-06
 **/
@Service
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        //验证为未登陆状态会进入此方法，认证错误
        response.setContentType(MediaType.APPLICATION_JSON_UTF8.toString());
        response.getWriter().write(JSON.toJSONString(ObjectResponse.custom(HttpStatus.UNAUTHORIZED.value())));
    }
}
