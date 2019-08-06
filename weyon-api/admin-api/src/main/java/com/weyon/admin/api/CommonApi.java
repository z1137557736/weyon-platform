package com.weyon.admin.api;

import com.weyon.admin.client.CommonClient;
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
 * @description 公共接口类
 * @date 2019-07-25
 **/
@Api(tags = "用户登录注销接口类")
@RestController
@RequestMapping(Constant.API_PREFIX)
public class CommonApi {

    @Autowired
    private CommonClient commonClient;

    @ApiOperation("登录")
    @PostMapping("/admin/login")
    public ObjectResponse login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return commonClient.login(username, password);
    }

    @ApiOperation("注销")
    @PostMapping("/admin/logout")
    public ObjectResponse logout() {
        return commonClient.logout();
    }

}
