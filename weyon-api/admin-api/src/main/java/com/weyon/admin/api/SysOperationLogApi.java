package com.weyon.admin.api;

import com.weyon.admin.client.SysOperationLogClient;
import com.weyon.framework.constant.Constant;
import com.weyon.framework.handler.ObjectResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liuxu
 * @description 操作日志接口类
 * @date 2019-07-25
 **/
@Api(tags = "操作日志接口")
@RestController
@RequestMapping(Constant.API_PREFIX + SysOperationLogClient.PREFIX)
public class SysOperationLogApi {

    @Autowired
    private SysOperationLogClient sysOperationLogClient;

    @ApiOperation("获取操作日志列表")
    @GetMapping
    public ObjectResponse getList(@RequestParam Map<String, Object> map) {
        return sysOperationLogClient.getList(map);
    }

    @ApiOperation("删除操作日志")
    @DeleteMapping("/{id}")
    public ObjectResponse delete(@PathVariable("id") String id) {
        return sysOperationLogClient.delete(id);
    }

}
