package com.weyon.admin.security;

import com.weyon.framework.constant.RedisConstant;
import com.weyon.framework.util.ClientUtil;
import com.weyon.security.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuxu
 * @description 防止暴力登录接口类
 * @date 2019-05-20
 **/
@Service
@Slf4j
public class MyUserAttemptService {

    @Autowired
    private RedisService redisService;

    /**
     * 记录用户客户端登录失败次数
     * @param request
     */
    public void loginFail(HttpServletRequest request) {
        String ip = ClientUtil.getClientIP(request);
        boolean hasKey = redisService.hasKeyHashItem(RedisConstant.USER_LOGIN_KEY, ip);
        if (hasKey) {
            Integer count = (Integer) redisService.getHashItem(RedisConstant.USER_LOGIN_KEY, ip);
            redisService.setHashItem(RedisConstant.USER_LOGIN_KEY, ip, ++count);
        } else {
            //第一次缓存设置cache存活时间为20分钟
            redisService.setHashItem(RedisConstant.USER_LOGIN_KEY, ip, 1, 60 * 20);
        }
    }

    /**
     * 客户端登录成功清空登录失败次数
     * @param request
     */
    public void loginSuccess(HttpServletRequest request) {
        String ip = ClientUtil.getClientIP(request);
        boolean hasKey = redisService.hasKeyHashItem(RedisConstant.USER_LOGIN_KEY, ip);
        if (hasKey) {
            redisService.deleteHashItem(RedisConstant.USER_LOGIN_KEY, ip);
        }
    }

    /**
     * 获取当前ip登录失败的次数
     * @param request
     * @return
     */
    public Integer getLoginCnt(HttpServletRequest request) {
        String ip = ClientUtil.getClientIP(request);
        boolean hasKey = redisService.hasKeyHashItem(RedisConstant.USER_LOGIN_KEY, ip);
        if (hasKey) {
            return (Integer) redisService.getHashItem(RedisConstant.USER_LOGIN_KEY, ip);
        } else {
            return 0;
        }
    }
}
