package com.weyon.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weyon.admin.anno.MyLog;
import com.weyon.admin.entity.SysRole;
import com.weyon.admin.serivce.SysRoleService;
import com.weyon.common.handler.BaseController;
import com.weyon.framework.handler.ObjectResponse;
import com.weyon.framework.handler.PageRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liuxu
 * @description 系统角色控制类
 * @date 2019-06-07
 **/
@RestController
@RequestMapping("/role")
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService roleService;

    @GetMapping
    public ObjectResponse getList(PageRequest request){
        PageInfo<SysRole> pageInfo;
        PageHelper.startPage(request.getPage(), request.getLimit());
        Example example = example(request.getParams(), SysRole.class);
        List<SysRole> sysRoleList = roleService.selectByExample(example);
        pageInfo = new PageInfo<>(sysRoleList);
        return ObjectResponse.ok(pageInfo);
    }

    @GetMapping("/all")
    public ObjectResponse getAllList(){
        List<SysRole> sysRoleList = roleService.selectByExample(example(null,SysRole.class));
        return ObjectResponse.ok(sysRoleList);
    }

    /**
     * 定义筛选条件
     * @param params
     * @return
     */
    public Example example(JSONObject params, Class clazz){
        Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();
        exampleLike(criteria, params,"name", "roleCode");
        example.orderBy("sort").asc();
        return example;
    }

    @GetMapping("/{id}")
    public ObjectResponse init(@PathVariable("id") String id) {
        SysRole sysRole =  roleService.selectByKey(id);
        return ObjectResponse.ok(sysRole);
    }


    @PostMapping
    @MyLog("添加角色")
    public ObjectResponse save(SysRole sysRole) {
        roleService.saveNotNull(sysRole);
        return ObjectResponse.ok("添加成功");
    }

    @PutMapping
    @MyLog("修改角色")
    public ObjectResponse update(SysRole sysRole) {
        roleService.updateNotNull(sysRole);
        return ObjectResponse.ok("修改成功");
    }

    @DeleteMapping("/{id}")
    @MyLog("删除角色")
    public ObjectResponse delete(@PathVariable("id") String id) {
        roleService.delete(id);
        return ObjectResponse.ok("删除成功");
    }

    @ApiOperation("获取指定角色的权限")
    @GetMapping("/getPermList/{roleId}")
    public ObjectResponse getRolePermList(@PathVariable("roleId") String roleId) {
        List<String> result = roleService.selectPermByRoleId(roleId);
        return ObjectResponse.ok(result);
    }

    @ApiOperation("添加角色权限")
    @PostMapping("/saveRolePerm")
    public ObjectResponse saveRolePerm(String roleId, String[] perms) {
        roleService.saveRolePerm(roleId, perms);
        return ObjectResponse.ok("权限分配成功");
    }
}
