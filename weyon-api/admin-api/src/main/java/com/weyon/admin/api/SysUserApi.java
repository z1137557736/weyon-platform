package com.weyon.admin.api;

import com.weyon.admin.client.SysUserClient;
import com.weyon.framework.handler.ObjectResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liuxu
 * @description 基础用户接口类
 * @date 2019-07-25
 **/
@Api(tags = "基础用户接口")
@RestController
@RequestMapping(SysUserClient.PREFIX)
public class SysUserApi {

    @Autowired
    private SysUserClient sysUserClient;

    @ApiOperation("获取用户列表")
    @GetMapping
    public ObjectResponse getList(@RequestParam Map<String, Object> map) {
        return sysUserClient.getList(map);
    }

    @ApiOperation("查看单个用户")
    @GetMapping("/{id}")
    public ObjectResponse init(@PathVariable("id") String id) {
        return sysUserClient.init(id);
    }

    @ApiOperation("添加用户")
    @PostMapping
    public ObjectResponse save(@RequestParam Map<String, Object> map) {
        return sysUserClient.save(map);
    }

    @ApiOperation("修改用户")
    @PutMapping
    public ObjectResponse update(@RequestParam Map<String, Object> map) {
        return sysUserClient.update(map);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public ObjectResponse delete(@PathVariable("id") String id) {
        return sysUserClient.delete(id);
    }

    @ApiOperation("根据token查看当前用户信息")
    @GetMapping("/curUser")
    public ObjectResponse curUser() {
        return sysUserClient.curUser();
    }

    @ApiOperation("获取指定用户的角色")
    @GetMapping("/getUserRoleList/{id}")
    public ObjectResponse getUserRoleList(@PathVariable("id") String id){
        return sysUserClient.getUserRoleList(id);
    }

    @ApiOperation("添加用户角色")
    @PostMapping("/saveUserRole")
    public ObjectResponse saveUserRole(String userId, String[] roles) {
        return sysUserClient.saveUserRole(userId, roles);
    }

    @ApiOperation("修改密码")
    @PutMapping("/updatePassword")
    public ObjectResponse updatePassword(String oldPwd, String newPwd) {
        return sysUserClient.updatePassword(oldPwd, newPwd);
    }
}
