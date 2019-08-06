package com.weyon.security.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weyon.framework.constant.RedisConstant;
import com.weyon.common.handler.BaseController;
import com.weyon.framework.util.DateUtil;
import com.weyon.security.model.MyUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.util.StringUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxu
 * @description jwt工具类
 * @date 2019-07-06
 **/
@Component
public class JwtTokenService implements Serializable {

    private static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";

    @Autowired
    private RedisService redisService;

    /**
     * 过期时间是3600秒，既是1个小时 单位（秒）
     */
    @Value("${token.expire.seconds}")
    private long EXPIRATION_TIME;
    /**
     * JWT密码
     */
    @Value("${token.jwtSecret}")
    private String SECRET;


    /**
     * 生成永久token
     */
    public String generateToken(MyUser myUser) {
        // 用来标识唯一用户
        String uuid = getUuidStr(myUser.getId());
        myUser.setUuid(uuid);
        cacheUser(myUser);
        Map<String, Object> claims = new HashMap<>(16);
        // 通过uuid来寻找用户
        claims.put(LOGIN_USER_KEY, myUser.getUuid());
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setClaims(claims)
                .setExpiration(null)
                .compact();
    }

    public MyUser getAuthentication() {
        String token = BaseController.getRequest().getHeader(RedisConstant.HEADER_TOKEN);
        if (StringUtil.isNotEmpty(token)) {
            MyUser myUser = getUser(token);
            return myUser;
        }
        return null;
    }

    public String getUuidStr(String userId) {
        return "access_token:" + userId;
    }

    /**
     * 删除redis中的token
     */
    public boolean deleteToken(String token) {
        MyUser myUser = getUser(token);
        if (myUser != null) {
            redisService.deleteHashItem(LOGIN_USER_KEY, myUser.getUuid());
            return true;
        }
        return false;
    }

    /**
     * 缓存到redis中
     * @param myUser
     */
    private void cacheUser(MyUser myUser) {
        myUser.setLoginTime(DateUtil.getDate());
        // 标识过期时间
        myUser.setExpireTime(myUser.getLoginTime().getTime() + EXPIRATION_TIME * 1000);
        redisService.setHashItem(LOGIN_USER_KEY, myUser.getUuid(), JSONObject.parseObject(JSON.toJSONString(myUser)), EXPIRATION_TIME);
    }

    /**
     * 刷新缓存的用户信息
     * @param myUser
     */
    public void refreshUser(MyUser myUser) {
        cacheUser(myUser);
    }

    public MyUser getUser(String token) {
        String uuid = getUuidFromToken(token);
        if (StringUtil.isNotEmpty(uuid)) {
            return JSONObject.parseObject(JSON.toJSONString(redisService.getHashItem(LOGIN_USER_KEY, uuid)), MyUser.class);
        }
        return null;
    }

    /**
     * 根据token获取uuid
     */
    public String getUuidFromToken(String token) {
        String uuid = getClaimsFromToken(token).get(LOGIN_USER_KEY) + "";
        return uuid;
    }

    /**
     * 解析JWT
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }
}