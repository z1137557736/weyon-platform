package com.weyon.admin.security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weyon.admin.entity.SysOrganization;
import com.weyon.admin.entity.SysPermission;
import com.weyon.admin.entity.SysUser;
import com.weyon.admin.serivce.SysOrganizationService;
import com.weyon.admin.serivce.SysPermissionService;
import com.weyon.admin.serivce.SysUserService;
import com.weyon.framework.constant.RedisConstant;
import com.weyon.security.model.MyPermission;
import com.weyon.security.model.MyUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author liuxu
 * @description 自定义UserDetailsService接口
 * @date 2019-05-17
 **/
@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysPermissionService permissionService;

    @Autowired
    SysOrganizationService organizationService;

    @Autowired
    private MyUserAttemptService myUserAttemptService;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Integer loginCnt = myUserAttemptService.getLoginCnt(request);
        if (loginCnt >= RedisConstant.LOGIN_FAIL_CNT) {
            throw new BadCredentialsException("当前ip已被锁定，20分钟后方可重新登录");
        }
        SysUser user = sysUserService.selectByUsername(username);
        if (user != null) {
            if (user.getLocked().equals(MyUser.Status.LOCKED)) {
                throw new AuthenticationCredentialsNotFoundException("用户已被锁定，请联系管理员");
            }
            List<SysPermission> permissions = permissionService.findByUserId(user.getId());
            MyUser myUser = new MyUser();
            // 把用户的基本信息与权限储存起来
            BeanUtils.copyProperties(user, myUser);
            // 添加权限
            List<MyPermission> myPermissions = JSONObject.parseArray(JSON.toJSONString(permissions), MyPermission.class);
            myUser.setPermissions(myPermissions);
            // 添加机构名
            SysOrganization organization = organizationService.selectByKey(user.getOrganizationId());
            if (organization != null) {
                myUser.setOrgName(organization.getName());
            }
            return myUser;
        } else {
            throw new BadCredentialsException("用户名" + username + "不存在");
        }
    }
}
