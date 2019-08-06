package com.weyon.admin.client;

import com.weyon.framework.handler.ObjectResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liuxu
 * @description 系统角色请求类
 * @date 2019-07-25
 **/
@FeignClient(name = "admin-service")
@RequestMapping(SysRoleClient.PREFIX)
public interface SysRoleClient {

    String PREFIX = "/admin/role";

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

    @GetMapping("/all")
    ObjectResponse getAllList();

    @GetMapping("/getPermList/{roleId}")
    ObjectResponse getRolePermList(@PathVariable("roleId") String roleId);

    @PostMapping("/saveRolePerm")
    ObjectResponse saveRolePerm(@RequestParam("roleId") String roleId,@RequestParam("perms") String[] perms);
}
