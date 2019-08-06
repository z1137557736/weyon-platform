package com.weyon.admin.client;

import com.weyon.framework.handler.ObjectResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liuxu
 * @description 基础用户请求类
 * @date 2019-07-25
 **/
@FeignClient(name = "admin-service")
@RequestMapping(SysUserClient.PREFIX)
public interface SysUserClient {

    String PREFIX = "/admin/user";

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

    @GetMapping("/curUser")
    ObjectResponse curUser();

    @GetMapping("/getUserRoleList/{id}")
    ObjectResponse getUserRoleList(@PathVariable("id") String id);

    @PostMapping("/saveUserRole")
    ObjectResponse saveUserRole(@RequestParam("userId") String userId,@RequestParam("roles") String[] roles);

    @PutMapping("/updatePassword")
    ObjectResponse updatePassword(@RequestParam("oldPwd") String oldPwd,@RequestParam("newPwd") String newPwd);

}
