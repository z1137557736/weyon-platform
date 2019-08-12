package com.weyon.core.api;

import com.weyon.core.client.CoreFieldInfoClient;
import com.weyon.framework.constant.Constant;
import com.weyon.framework.handler.ObjectResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "字段信息接口")
@RestController
@RequestMapping(Constant.API_PREFIX + CoreFieldInfoClient.PREFIX)
public class CoreFieldInfoApi {
    @Autowired
    private CoreFieldInfoClient coreFieldInfoClient;

    @ApiOperation("获取字段信息列表")
    @GetMapping("/{tableName}")
    public ObjectResponse getList(@PathVariable("tableName") String tableName){
        ObjectResponse objectResponse = coreFieldInfoClient.getList(tableName);
        return objectResponse;
    }

    @ApiOperation("test")
    @GetMapping("/test")
    public ObjectResponse test(){
        return coreFieldInfoClient.test();
    }

    @ApiOperation("修改字段信息列表")
    @PutMapping
    public ObjectResponse saveOrUpdate(@RequestBody List<Map<String, Object>> maps){
        return coreFieldInfoClient.saveOrUpdate(maps);
    }
}
