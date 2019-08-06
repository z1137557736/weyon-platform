package com.weyon.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weyon.admin.anno.MyLog;
import com.weyon.admin.entity.SysOperationLog;
import com.weyon.admin.serivce.SysOperationLogService;
import com.weyon.common.handler.BaseController;
import com.weyon.framework.handler.ObjectResponse;
import com.weyon.framework.handler.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liuxu
 * @description 操作日志控制类
 * @date 2019-05-30
 **/
@RestController
@RequestMapping("/admin/log")
public class SysOperationLogController extends BaseController {

    @Autowired
    private SysOperationLogService operationLogService;

    /**
     * 获取菜单与权限
     * @return
     */
    @GetMapping
    public ObjectResponse getList(PageRequest request){
        PageInfo<SysOperationLog> pageInfo;
        PageHelper.startPage(request.getPage(), request.getLimit());
        Example example = example(request.getParams(), SysOperationLog.class);
        List<SysOperationLog> userList = operationLogService.selectByExample(example);
        pageInfo = new PageInfo<>(userList);
        return ObjectResponse.ok(pageInfo);
    }

    /**
     * 定义筛选条件
     * @param clazz
     * @return
     */
    public Example example(JSONObject params, Class clazz){
        String createDate = "createDate";
        Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();
        exampleLike(criteria, params,"operation");
        exampleEquals(criteria, params, "logType");
        exampleGtAndLtDate(criteria, params, createDate);
        example.orderBy(createDate).desc();
        return example;
    }

    @DeleteMapping("/{id}")
    @MyLog("删除操作日志")
    public ObjectResponse delete(@PathVariable("id") String id) {
        operationLogService.delete(id);
        return ObjectResponse.ok("删除成功");
    }
}
