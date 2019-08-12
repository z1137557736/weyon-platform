package com.weyon.core.client;

import com.weyon.framework.handler.ObjectResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "core-service")
@RequestMapping(CoreFieldInfoClient.PREFIX)
public interface CoreFieldInfoClient {

    String PREFIX = "/core/fieldInfo";

    @GetMapping("/test")
    ObjectResponse test();

    @GetMapping("/{tableName}")
    ObjectResponse getList(@PathVariable("tableName") String tableName);


    @PutMapping
    ObjectResponse saveOrUpdate(@RequestParam List<Map<String, Object>> maps);
}
