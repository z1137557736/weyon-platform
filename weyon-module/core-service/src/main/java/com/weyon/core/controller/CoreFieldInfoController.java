package com.weyon.core.controller;

import com.weyon.common.handler.BaseController;
import com.weyon.core.entity.CoreFieldInfo;
import com.weyon.core.service.CoreFieldInfoService;
import com.weyon.framework.constant.RedisConstant;
import com.weyon.framework.handler.ObjectResponse;
import com.weyon.security.model.MyUser;
import com.weyon.security.service.JwtTokenService;
import com.weyon.security.service.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core/fieldInfo")
public class CoreFieldInfoController extends BaseController {
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private CoreFieldInfoService coreFieldInfoService;
    @Autowired
    private RedisService redisService;

    @GetMapping("/test")
    public ObjectResponse test(){
        return ObjectResponse.ok("ok");
    }


    @GetMapping("/{tableName}")
    public ObjectResponse getList(@PathVariable("tableName")String tableName) {
        if (StringUtils.isEmpty(tableName)) {
            return ObjectResponse.fail("请指定表");
        }
        MyUser myUser = jwtTokenService.getAuthentication();
        String orgId = myUser.getOrganizationId();
        List<CoreFieldInfo> CorecurateFieldInfos = coreFieldInfoService.selectByOrgIdAndTableName(orgId, tableName);
        if (CorecurateFieldInfos.size() == 0) {
            insertDefaultinfo(orgId, tableName);
            CorecurateFieldInfos = coreFieldInfoService.selectByOrgIdAndTableName(orgId, tableName);
        }
        return ObjectResponse.ok(CorecurateFieldInfos);
    }


    public void insertDefaultinfo(String orgId, String tableName) {
        List<CoreFieldInfo> CorecurateFieldInfos = coreFieldInfoService.selectByOrgIdAndTableName("-1", tableName);
        System.out.println(CorecurateFieldInfos.size());
        for (CoreFieldInfo CoreFieldInfo : CorecurateFieldInfos) {
            CoreFieldInfo.setId(null);
            CoreFieldInfo.setOrgId(orgId);
        }
        coreFieldInfoService.insertBatch(CorecurateFieldInfos);
    }

    @PutMapping
    public ObjectResponse saveOrUpdate(@RequestBody List<CoreFieldInfo> CoreFieldInfos) {
        if (CoreFieldInfos == null || CoreFieldInfos.size() == 0) {
            return ObjectResponse.fail("无数据");
        }
        coreFieldInfoService.updateBatch(CoreFieldInfos);
        MyUser myUser = jwtTokenService.getAuthentication();
        if (redisService.hasKeyHashItem(RedisConstant.CORE_FIELD_INFO_MAP_KEY, myUser.getOrganizationId() + CoreFieldInfos.get(0).getTableName())) {
            redisService.deleteHashItem(RedisConstant.CORE_FIELD_INFO_MAP_KEY, myUser.getOrganizationId() + CoreFieldInfos.get(0).getTableName());
        }
        return ObjectResponse.ok();
    }


}
