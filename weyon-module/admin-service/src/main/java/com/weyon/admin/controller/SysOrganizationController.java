package com.weyon.admin.controller;

import com.weyon.admin.anno.MyLog;
import com.weyon.admin.entity.SysOrganization;
import com.weyon.admin.serivce.SysOrganizationService;
import com.weyon.common.handler.BaseController;
import com.weyon.framework.handler.ObjectResponse;
import com.weyon.framework.util.RecursionTreeUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liuxu
 * @description 组织机构控制类
 * @date 2019-05-30
 **/
@RestController
@RequestMapping("/admin/org")
public class SysOrganizationController extends BaseController {


    @Autowired
    private SysOrganizationService organizationService;

    @ApiOperation("获取机构列表")
    @GetMapping
    public ObjectResponse getList(){
        List<SysOrganization> list = organizationService.selectAll();
        return ObjectResponse.ok(RecursionTreeUtil.defaultChangeTree(list, SysOrganization.class));
    }

    @ApiOperation("获取带有顶级机构的机构列表")
    @GetMapping("/tree")
    public ObjectResponse getListTree(){
        List<SysOrganization> list = organizationService.selectAll();
        SysOrganization organization = new SysOrganization();
        organization.setId("0");
        organization.setPid("-1");
        organization.setName("顶级机构");
        list.add(organization);
        return ObjectResponse.ok(RecursionTreeUtil.defaultChangeTree(list, SysOrganization.class));
    }

    @ApiOperation("查看单个机构")
    @GetMapping("/{id}")
    public ObjectResponse init(@PathVariable("id") String id) {
        SysOrganization sysOrganization =  organizationService.selectByKey(id);
        return ObjectResponse.ok(sysOrganization);
    }


    @PostMapping
    @MyLog("添加机构")
    public ObjectResponse save(SysOrganization sysOrganization) {
        organizationService.saveNotNull(sysOrganization);
        return ObjectResponse.ok("添加成功");
    }

    @PutMapping
    @MyLog("修改机构")
    public ObjectResponse update(SysOrganization sysOrganization) {
        organizationService.updateNotNull(sysOrganization);
        return ObjectResponse.ok("修改成功");
    }

    @DeleteMapping("/{id}")
    @MyLog("删除机构")
    public ObjectResponse delete(@PathVariable("id") String id) {
        organizationService.delete(id);
        return ObjectResponse.ok("删除成功");
    }

}
