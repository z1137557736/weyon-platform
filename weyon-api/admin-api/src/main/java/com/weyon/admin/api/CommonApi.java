package com.weyon.admin.api;

import com.weyon.admin.client.CommonClient;
import com.weyon.framework.handler.ObjectResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxu
 * @description 公共接口类
 * @date 2019-07-25
 **/
@Api(tags = "用户登录注销接口类")
@RestController
@RequestMapping
public class CommonApi {

    @Autowired
    private CommonClient commonClient;

    @ApiOperation("登录")
    @PostMapping("/login")
    public ObjectResponse login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return commonClient.login(username, password);
    }

    @ApiOperation("注销")
    @PostMapping("/logout")
    public ObjectResponse logout() {
        return commonClient.logout();
    }

}
