package com.weyon.admin.security.handler;

import com.alibaba.fastjson.JSON;
import com.weyon.admin.security.MyUserAttemptService;
import com.weyon.framework.constant.Constant;
import com.weyon.framework.constant.RedisConstant;
import com.weyon.framework.handler.ObjectResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liuxu
 * @description 自定义登录失败处理器
 * @date 2019-05-17
 **/

@Service
@Slf4j
public class MyAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private MyUserAttemptService myUserAttemptService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        log.info(request.getParameter("username") + "登录失败！");
        myUserAttemptService.loginFail(request);
        Integer loginCnt = myUserAttemptService.getLoginCnt(request);
        String error = exception.getMessage();
        if (loginCnt >= Constant.INT_TWO && loginCnt < RedisConstant.LOGIN_FAIL_CNT) {
            error = "您还有" + (RedisConstant.LOGIN_FAIL_CNT - loginCnt) + "次登录机会";
        }
        response.setContentType(MediaType.APPLICATION_JSON_UTF8.toString());
        response.getWriter().write(JSON.toJSONString(ObjectResponse.fail(error)));
    }
}