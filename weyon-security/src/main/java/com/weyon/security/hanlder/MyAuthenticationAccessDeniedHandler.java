package com.weyon.security.hanlder;

import com.alibaba.fastjson.JSON;
import com.weyon.framework.constant.HttpStatus;
import com.weyon.framework.handler.ObjectResponse;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liuxu
 * @description 403自定义处理类
 * @date 2019-05-29
 **/
@Service
public class MyAuthenticationAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException {
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8.toString());
        httpServletResponse.getWriter().write(JSON.toJSONString(ObjectResponse.custom(HttpStatus.SC_FORBIDDEN, "您无权限操作")));
    }
}
