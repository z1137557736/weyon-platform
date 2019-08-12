package com.weyon.admin.config;

import com.weyon.admin.security.MyFilterSecurityInterceptor;
import com.weyon.admin.security.MyUserService;
import com.weyon.admin.security.handler.*;
import com.weyon.framework.util.MD5Util;
import com.weyon.security.filter.JwtTokenFilter;
import com.weyon.security.hanlder.MyAuthenticationAccessDeniedHandler;
import com.weyon.security.hanlder.MyAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import tk.mybatis.mapper.util.StringUtil;

/**
 * @author liuxu
 * @description security配置文件类
 * @date 2019-05-16
 **/

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Autowired
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailHandler authenticationFailHandler;

    @Autowired
    private MyAuthenticationLogoutHandler authenticationLogoutHandler;

    @Autowired
    private MyAuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    @Autowired
    private MyAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private MyUserService myUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 基于token，所以不需要session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers("/", "/*.html", "/druid/**")
                .permitAll()
                .anyRequest()
                .authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailHandler)
                .permitAll() //登录页面用户任意访问
                .and()
                .logout()
                .logoutSuccessHandler(authenticationLogoutHandler)
                .permitAll() //注销行为任意访问
                .and()
                //解决iframe不可引用
                .headers().frameOptions().disable()
                .and()
                .addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class)
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                //关闭跨网站请求保护
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .exceptionHandling().accessDeniedHandler(authenticationAccessDeniedHandler);
    }

    /**
     * 构建自定义的DaoAuthenticationProvider
     * @return
     */
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider bean = new DaoAuthenticationProvider();
        bean.setHideUserNotFoundExceptions(false);
        bean.setUserDetailsService(myUserService);
        bean.setPasswordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                try {
                    return MD5Util.encode((String)rawPassword);
                } catch (Exception e) {
                    throw new BadCredentialsException("调用加密算法对密码进行加密时异常", e);
                }
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                if (rawPassword == null) {
                    throw new BadCredentialsException("没有提供密码");
                } else if (StringUtil.isEmpty(encodedPassword)) {
                    throw new BadCredentialsException("系统中密码密文是空白字符串");
                } else if (!this.encode(rawPassword).equals(encodedPassword)){
                    throw new BadCredentialsException("用户名或密码错误");
                } else {
                    return true;
                }
            }
        });

        return bean;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        //user Details Service验证
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    public void configure(WebSecurity web){
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/static/**", "/kaptcha", "/favicon.ico");
    }

    /**
     * AuthenticationManager
     * @return
     * @throws Exception
     */
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
