package com.weyon.admin.security.handler;

import com.alibaba.fastjson.JSON;
import com.weyon.admin.anno.MyLog;
import com.weyon.admin.security.MyUserAttemptService;
import com.weyon.framework.handler.ObjectResponse;
import com.weyon.security.model.MyUser;
import com.weyon.security.service.JwtTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liuxu
 * @description 继承会记住你访问时被拦截的路径，登陆后可以继续跳转你访问时的地址
 * @date 2019-05-17
 **/

@Service
@Slf4j
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private MyUserAttemptService myUserAttemptService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @MyLog("登录成功")
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        log.info( request.getParameter("username") + "登录成功！");
        myUserAttemptService.loginSuccess(request);
        response.setContentType("application/json;charset=UTF-8");
        MyUser myUser = (MyUser) authentication.getPrincipal();
        String token = jwtTokenService.generateToken(myUser);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8.toString());
        response.getWriter().write(JSON.toJSONString(ObjectResponse.ok(token, "登录成功")));
    }
}
