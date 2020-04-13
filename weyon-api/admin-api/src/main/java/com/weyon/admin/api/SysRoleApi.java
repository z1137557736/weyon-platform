package com.weyon.admin.api;

import com.weyon.admin.client.SysRoleClient;
import com.weyon.framework.handler.ObjectResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liuxu
 * @description 系统角色接口类
 * @date 2019-07-25
 **/
@Api(tags = "系统角色接口")
@RestController
@RequestMapping(SysRoleClient.PREFIX)
public class SysRoleApi {

    @Autowired
    private SysRoleClient sysRoleClient;

    @ApiOperation("获取角色列表")
    @GetMapping
    public ObjectResponse getList(@RequestParam Map<String, Object> map) {
        return sysRoleClient.getList(map);
    }

    @ApiOperation("查看单个角色")
    @GetMapping("/{id}")
    public ObjectResponse init(@PathVariable("id") String id) {
        return sysRoleClient.init(id);
    }

    @ApiOperation("添加角色")
    @PostMapping
    public ObjectResponse save(@RequestParam Map<String, Object> map) {
        return sysRoleClient.save(map);
    }

    @ApiOperation("修改角色")
    @PutMapping
    public ObjectResponse update(@RequestParam Map<String, Object> map) {
        return sysRoleClient.update(map);
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/{id}")
    public ObjectResponse delete(@PathVariable("id") String id) {
        return sysRoleClient.delete(id);
    }

    @ApiOperation("获取所有角色")
    @GetMapping("/all")
    public ObjectResponse getAllList() {
        return sysRoleClient.getAllList();
    }

    @ApiOperation("获取指定角色的权限")
    @GetMapping("/getPermList/{roleId}")
    public ObjectResponse getRolePermList(@PathVariable("roleId") String roleId){
        return sysRoleClient.getRolePermList(roleId);
    }

    @ApiOperation("添加角色权限")
    @PostMapping("/saveRolePerm")
    public ObjectResponse saveRolePerm(String roleId, String[] perms){
        return sysRoleClient.saveRolePerm(roleId, perms);
    }

}
