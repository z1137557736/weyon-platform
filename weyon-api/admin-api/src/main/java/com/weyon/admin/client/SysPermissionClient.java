package com.weyon.admin.client;

import com.weyon.framework.handler.ObjectResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liuxu
 * @description 系统权限调用类
 * @date 2019-07-25
 **/
@FeignClient(name = "admin-service")
@RequestMapping(SysPermissionClient.PREFIX)
public interface SysPermissionClient {

    String PREFIX = "/admin/perm";

    @GetMapping
    ObjectResponse getList(@RequestParam Map<String, Object> map);

    @GetMapping("/{id}")
    ObjectResponse init(@PathVariable("id") String id);

    @PostMapping
    ObjectResponse save(@RequestParam Map<String, Object> map);

    @PutMapping
    ObjectResponse update(@RequestParam Map<String, Object> map);

    @DeleteMapping("/{id}")
    ObjectResponse delete(@PathVariable("id") String id);

    @GetMapping("/menu")
    ObjectResponse getMenuList();
}
