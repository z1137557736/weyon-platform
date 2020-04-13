package com.weyon.admin.client;

import com.weyon.framework.handler.ObjectResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liuxu
 * @description 操作日志调用类
 * @date 2019-07-25
 **/
@FeignClient(name = "admin-service")
@RequestMapping(SysOperationLogClient.PREFIX)
public interface SysOperationLogClient {

    String PREFIX = "/log";

    @GetMapping
    ObjectResponse getList(@RequestParam Map<String, Object> map);

    @DeleteMapping("/{id}")
    ObjectResponse delete(@PathVariable("id") String id);
}
