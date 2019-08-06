package com.weyon.admin.security.handler;

import com.alibaba.fastjson.JSON;
import com.weyon.admin.anno.MyLog;
import com.weyon.framework.constant.RedisConstant;
import com.weyon.framework.handler.ObjectResponse;
import com.weyon.security.service.JwtTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liuxu
 * @description 自定义注销
 * @date 2019-06-10
 **/

@Service
@Slf4j
public class MyAuthenticationLogoutHandler implements LogoutSuccessHandler {

    @Autowired
    private JwtTokenService tokenService;

    @MyLog("注销成功")
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String token = request.getHeader(RedisConstant.HEADER_TOKEN);
        if (StringUtil.isNotEmpty(token)) {
            tokenService.deleteToken(token);
        }
        response.setContentType(MediaType.APPLICATION_JSON_UTF8.toString());
        response.getWriter().write(JSON.toJSONString(ObjectResponse.ok("注销成功")));
    }
}
