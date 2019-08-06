package com.weyon.admin.client;

import com.weyon.framework.handler.ObjectResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liuxu
 * @description 公共调用类
 * @date 2019-07-26
 **/
@FeignClient(name = "admin-service")
public interface CommonClient {

    @PostMapping("/login")
    ObjectResponse login(@RequestParam("username") String username, @RequestParam("password") String password);

    @PostMapping("/logout")
    ObjectResponse logout();

}
