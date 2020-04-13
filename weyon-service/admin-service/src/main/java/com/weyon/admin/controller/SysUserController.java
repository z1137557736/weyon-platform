package com.weyon.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weyon.admin.anno.MyLog;
import com.weyon.admin.entity.SysUser;
import com.weyon.admin.serivce.SysUserService;
import com.weyon.common.handler.BaseController;
import com.weyon.framework.handler.ObjectResponse;
import com.weyon.framework.handler.PageRequest;
import com.weyon.framework.util.MD5Util;
import com.weyon.security.model.MyUser;
import com.weyon.security.service.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liuxu
 * @description 基础用户控制类
 * @date 2019-05-16
 **/

@RestController
@RequestMapping("/user")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @GetMapping
    public ObjectResponse getList(PageRequest request) {
        PageInfo<SysUser> pageInfo;
        PageHelper.startPage(request.getPage(), request.getLimit());
        Example example = example(request.getParams(), SysUser.class);
        List<SysUser> userList = sysUserService.selectByExample(example);
        pageInfo = new PageInfo<>(userList);
        return ObjectResponse.ok(pageInfo);
    }

    /**
     * 定义筛选条件
     * @param params
     * @return
     */
    public Example example(JSONObject params, Class clazz){
        Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();
        exampleLike(criteria, params,"username", "realName");
        exampleEquals(criteria, params, "organizationId");
        example.orderBy("createDate").desc();
        return example;
    }

    @GetMapping("/{id}")
    public ObjectResponse init(@PathVariable("id") String id) {
        SysUser sysUser =  sysUserService.selectByKey(id);
        return ObjectResponse.ok(sysUser);
    }

    @GetMapping("/curUser")
    public ObjectResponse curUser() {
        MyUser myUser =  jwtTokenService.getAuthentication();
        return ObjectResponse.ok(myUser);
    }

    @PostMapping
    @MyLog(value = "添加用户", param = false)
    public ObjectResponse save(SysUser sysUser) {
        SysUser user = sysUserService.selectByUsername(sysUser.getUsername());
        if (user != null) {
            return ObjectResponse.fail("用户名已存在");
        }
        sysUser.setPassword(MD5Util.encode(sysUser.getPassword()));
        sysUserService.saveNotNull(sysUser);
        return ObjectResponse.ok("添加成功");
    }

    @PutMapping
    @MyLog(value = "修改用户", param = false)
    public ObjectResponse update(SysUser sysUser) {
        sysUserService.updateNotNull(sysUser);
        return ObjectResponse.ok("修改成功");
    }

    @DeleteMapping("/{id}")
    @MyLog("删除用户")
    public ObjectResponse delete(@PathVariable("id") String id) {
        sysUserService.delete(id);
        return ObjectResponse.ok("删除成功");
    }

    @GetMapping("/getUserRoleList/{id}")
    public ObjectResponse getUserRoleList(@PathVariable("id") String id) {
        return ObjectResponse.ok(sysUserService.selectRoleByUserId(id));
    }

    @PostMapping("/saveUserRole")
    public ObjectResponse saveUserRole(String userId, String[] roles) {
        sysUserService.saveUserRole(userId, roles);
        return ObjectResponse.ok("角色分配成功");
    }

    @MyLog(value = "修改密码", param = false)
    @PutMapping("/updatePassword")
    public ObjectResponse updatePassword(String oldPwd, String newPwd) {
        MyUser myUser = jwtTokenService.getAuthentication();
        if (!MD5Util.encode(oldPwd).equals(myUser.getPassword())) {
            return ObjectResponse.fail("原密码错误");
        }
        SysUser user = new SysUser();
        user.setPassword(MD5Util.encode(newPwd));
        user.setId(myUser.getId());
        sysUserService.updateNotNull(user);
        return ObjectResponse.ok("修改密码成功");
    }

}
