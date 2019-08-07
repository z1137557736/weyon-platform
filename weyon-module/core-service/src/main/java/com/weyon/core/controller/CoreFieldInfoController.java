package com.weyon.core.controller;

import com.weyon.common.handler.BaseController;
import com.weyon.core.service.CoreFieldInfoService;
import com.weyon.framework.handler.ObjectResponse;
import com.weyon.security.service.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(CoreFieldInfoController.PARENT)
public class CoreFieldInfoController extends BaseController {
    private static final String ME = "field";

    public static final String PARENT = "/core/" + ME;

    private static final String PREFIX = "backstage" + PARENT + "/";

    @Autowired
    private CoreFieldInfoService coreFieldInfoService;
    @Autowired
    private RedisService redisService;

    @RequestMapping(METHOD_GO_LIST)
    public ModelAndView goList() {
        return new ModelAndView(PREFIX + ME + "List");
    }

    @RequestMapping(METHOD_GET_LIST)
    public ObjectResponse getList(String tableName) {
        if (StringUtils.isEmpty(tableName)) {
            return ObjectResponse.fail("请指定表");
        }
        String orgId = getAuthentication().getOrganizationId();
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

    @RequestMapping(METHOD_SAVE_OR_UPDATE)
    public ObjectResponse saveOrUpdate(@RequestBody List<CoreFieldInfo> CoreFieldInfos) {
        if (CoreFieldInfos == null || CoreFieldInfos.size() == 0) {
            return ObjectResponse.fail("无数据");
        }
        coreFieldInfoService.updateBatch(CoreFieldInfos);
        if (redisService.hasKeyHashItem(RedisConstant.CORE_FIELD_INFO_MAP_KEY, getAuthentication().getOrganizationId() + CoreFieldInfos.get(0).getTableName())) {
            redisService.deleteHashItem(RedisConstant.CORE_FIELD_INFO_MAP_KEY, getAuthentication().getOrganizationId() + CoreFieldInfos.get(0).getTableName());
        }
        return ObjectResponse.ok();
    }

    // 获取对应的字段权限列表
    @RequestMapping("/getStudentFieldInfo")
    public ObjectResponse getList(HttpServletRequest request, String yxdm, String tableName) {
        if (StringUtils.isEmpty(yxdm) || StringUtils.isEmpty(tableName)) {
            yxdm = CookieUtil.getCookie(request, "yxdm");
            if (StringUtil.isEmpty(yxdm)) {
                return ObjectResponse.fail("请传递正确的参数");
            }
        }
        Example example = new Example(SysOrganization.class);
        example.createCriteria().andEqualTo("yxdm", yxdm);
        SysOrganization sysOrganization = sysOrganizationService.selectOneByExample(example);
        List<CoreFieldInfo> coreFieldInfos = coreFieldInfoService.selectByOrgIdAndTableName(sysOrganization.getId(), tableName);
        return ObjectResponse.ok(coreFieldInfos);
    }

}
