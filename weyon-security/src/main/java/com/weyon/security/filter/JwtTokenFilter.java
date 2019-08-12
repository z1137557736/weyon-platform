package com.weyon.security.filter;

import com.weyon.framework.constant.RedisConstant;
import com.weyon.security.model.MyUser;
import com.weyon.security.service.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liuxu
 * @description jwt过滤器
 * @date 2019-07-06
 **/
@Service
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String token = request.getHeader(RedisConstant.HEADER_TOKEN);
        if (StringUtil.isNotEmpty(token)) {
            MyUser myUser = jwtTokenService.getUser(token);
            if (myUser != null) {
                myUser = checkLoginTime(myUser);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(myUser,
                        null, myUser.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                        request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }

    /**
     * 校验时间
     * 过期时间与当前时间对比，临近过期10分钟内的话，自动刷新缓存
     * @param myUser
     * @return
     */
   private MyUser checkLoginTime(MyUser myUser) {
        long expireTime = myUser.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= RedisConstant.MINUTES_10) {
            /*String uuid = myUser.getUuid();
            myUser = (MyUser) userDetailsService.loadUserByUsername(myUser.getUsername());
            myUser.setUuid(uuid);*/
            jwtTokenService.refreshUser(myUser);
        }
        return myUser;
    }
}
