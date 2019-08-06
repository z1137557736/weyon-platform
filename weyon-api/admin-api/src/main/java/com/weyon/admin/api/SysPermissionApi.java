package com.weyon.admin.api;

import com.weyon.admin.client.SysPermissionClient;
import com.weyon.admin.client.SysUserClient;
import com.weyon.framework.constant.Constant;
import com.weyon.framework.handler.ObjectResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liuxu
 * @description 系统权限接口类
 * @date 2019-07-25
 **/
@Api(tags = "系统权限接口")
@RestController
@RequestMapping(Constant.API_PREFIX + SysPermissionClient.PREFIX)
public class SysPermissionApi {

    @Autowired
    private SysPermissionClient sysPermissionClient;

    @ApiOperation("获取菜单与权限")
    @GetMapping
    public ObjectResponse getList(@RequestParam Map<String, Object> map) {
        return sysPermissionClient.getList(map);
    }

    @ApiOperation("查看单个权限")
    @GetMapping("/{id}")
    public ObjectResponse init(@PathVariable("id") String id) {
        return sysPermissionClient.init(id);
    }

    @ApiOperation("添加权限")
    @PostMapping
    public ObjectResponse save(@RequestParam Map<String, Object> map) {
        return sysPermissionClient.save(map);
    }

    @ApiOperation("修改权限")
    @PutMapping
    public ObjectResponse update(@RequestParam Map<String, Object> map) {
        return sysPermissionClient.update(map);
    }

    @ApiOperation("删除权限")
    @DeleteMapping("/{id}")
    public ObjectResponse delete(@PathVariable("id") String id) {
        return sysPermissionClient.delete(id);
    }

    @ApiOperation("获取菜单")
    @GetMapping("/menu")
    public ObjectResponse getMenuList() {
        return sysPermissionClient.getMenuList();
    }
}
