package com.weyon.admin.api;

import com.weyon.admin.client.SysOrganizationClient;
import com.weyon.framework.handler.ObjectResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liuxu
 * @description 组织机构接口类
 * @date 2019-07-25
 **/
@Api(tags = "组织机构接口")
@RestController
@RequestMapping(SysOrganizationClient.PREFIX)
public class SysOrganizationApi {

    @Autowired
    private SysOrganizationClient sysOrganizationClient;

    @ApiOperation("获取机构列表")
    @GetMapping
    public ObjectResponse getList(@RequestParam Map<String, Object> map) {
        return sysOrganizationClient.getList(map);
    }

    @ApiOperation("查看单个机构")
    @GetMapping("/{id}")
    public ObjectResponse init(@PathVariable("id") String id) {
        return sysOrganizationClient.init(id);
    }

    @ApiOperation("添加机构")
    @PostMapping
    public ObjectResponse save(@RequestParam Map<String, Object> map) {
        return sysOrganizationClient.save(map);
    }

    @ApiOperation("修改机构")
    @PutMapping
    public ObjectResponse update(@RequestParam Map<String, Object> map) {
        return sysOrganizationClient.update(map);
    }

    @ApiOperation("删除机构")
    @DeleteMapping("/{id}")
    public ObjectResponse delete(@PathVariable("id") String id) {
        return sysOrganizationClient.delete(id);
    }

    @ApiOperation("获取带有顶级机构的机构列表")
    @GetMapping("/tree")
    public ObjectResponse getListTree() {
        return sysOrganizationClient.getListTree();
    }
}
