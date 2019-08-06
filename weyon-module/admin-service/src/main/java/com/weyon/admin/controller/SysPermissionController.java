package com.weyon.admin.controller;

import com.weyon.admin.anno.MyLog;
import com.weyon.admin.entity.SysPermission;
import com.weyon.admin.serivce.SysPermissionService;
import com.weyon.common.handler.BaseController;
import com.weyon.framework.handler.ObjectResponse;
import com.weyon.framework.util.RecursionTreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuxu
 * @description 系统权限控制类
 * @date 2019-05-21
 **/
@RestController
@RequestMapping("/admin/perm")
public class SysPermissionController extends BaseController {

    @Autowired
    private SysPermissionService permissionService;


    // @PreAuthorize("hasAuthority('user:save66')")
    @GetMapping
    public ObjectResponse getList(){
        List<SysPermission> list = permissionService.selectAll();
        return ObjectResponse.ok(RecursionTreeUtil.defaultChangeTree(list, SysPermission.class));
    }

    @GetMapping("/menu")
    public ObjectResponse getMenuList(){
        List<SysPermission> list = permissionService.selectAll().stream().filter(p -> p.getPermissionType() == 1).collect(Collectors.toList());
        SysPermission permission = new SysPermission();
        permission.setId("0");
        permission.setPid("-1");
        permission.setName("顶级菜单");
        list.add(permission);
        return ObjectResponse.ok(RecursionTreeUtil.defaultChangeTree(list, SysPermission.class));
    }

    @GetMapping("/{id}")
    public ObjectResponse init(@PathVariable("id") String id) {
        SysPermission sysPermission =  permissionService.selectByKey(id);
        return ObjectResponse.ok(sysPermission);
    }


    @PostMapping
    @MyLog("添加权限")
    public ObjectResponse save(SysPermission sysPermission) {
        permissionService.saveNotNull(sysPermission);
        return ObjectResponse.ok("添加成功");
    }

    @PreAuthorize("hasAnyAuthority('perm:edit')")
    @PutMapping
    @MyLog("修改权限")
    public ObjectResponse update(SysPermission sysPermission) {
        permissionService.updateNotNull(sysPermission);
        return ObjectResponse.ok("修改成功");
    }

    @DeleteMapping("/{id}")
    @MyLog("删除权限")
    public ObjectResponse delete(@PathVariable("id") String id) {
        permissionService.delete(id);
        return ObjectResponse.ok("删除成功");
    }

}
