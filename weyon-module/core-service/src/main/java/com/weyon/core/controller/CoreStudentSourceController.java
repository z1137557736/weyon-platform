package com.weyon.core.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weyon.controller.constant.Constant;
import com.weyon.controller.handler.BaseController;
import com.weyon.controller.handler.ObjectResponse;
import com.weyon.controller.handler.PageRequest;
import com.weyon.core.entity.core.CoreFieldInfo;
import com.weyon.core.entity.core.CoreLog;
import com.weyon.core.entity.core.CoreStudentSource;
import com.weyon.core.entity.core.CoreStudentSourceHistory;
import com.weyon.core.entity.inac.InacStudentSourceTemp;
import com.weyon.core.service.core.CoreFieldInfoService;
import com.weyon.core.service.core.CoreLogService;
import com.weyon.core.service.core.CoreStudentSourceHistoryService;
import com.weyon.core.service.core.CoreStudentSourceService;
import com.weyon.framework.model.MyUser;
import com.weyon.wecaht.WeChatService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(CoreStudentSourceController.PARENT)
public class CoreStudentSourceController extends BaseController {
    private static final String ME = "stuSource";

    public static final String PARENT = "/core/" + ME;

    private static final String PREFIX = "backstage" + PARENT + "/";

    private static final String JSON_NAME = "name";

    private static final String JSON_LABEL = "label";

    private static final String JSON_SZYX = "szyx";

    private static final String JSON_XL = "xl";

    private static final String JSON_ZY = "zy";

    @Autowired
    private CoreStudentSourceService studentSourceService;
    @Autowired
    private CoreStudentSourceHistoryService studentSourceHistoryService;
    @Autowired
    private CoreFieldInfoService coreFieldInfoService;
    @Autowired
    private CoreLogService coreLogService;

    @RequestMapping(METHOD_GO_LIST)
    public ModelAndView goList() {

        return new ModelAndView(PREFIX + ME + "List");
    }

    @RequestMapping("/toList")
    public ModelAndView toList() {
        return new ModelAndView(PREFIX + "statisticsList");
    }

    /**
     * 为0则是顶级账号，不进行yxdm筛选
     */
    public void addCondition(PageRequest request, String yxdm) {
        if (!Constant.STR_ZERO.equals(yxdm)) {
            request.getParams().put("yxdm", yxdm);
        }
    }

    /**
     * 获取学生生源信息
     *
     * @return
     */
    @RequestMapping(METHOD_GET_LIST)
    public ObjectResponse getList(PageRequest request) {
        MyUser myUser = getAuthentication();
        if (myUser != null) {
            PageInfo<CoreStudentSource> pageInfo;
            PageHelper.startPage(request.getPage(), request.getLimit());
            addCondition(request, myUser.getYxdm());
            Example example = example(request.getParams(), CoreStudentSource.class);
            List<CoreStudentSource> studentSourceList = studentSourceService.selectByExample(example);
            pageInfo = new PageInfo<>(studentSourceList);
            return ObjectResponse.ok(pageInfo);
        } else {
            return ObjectResponse.fail(CUR_USER_TIME_TO_LIVE);
        }
    }

    @RequestMapping("/getStatisticsInfo")
    public ObjectResponse getStatisticsInfo(PageRequest request) {
        MyUser myUser = getAuthentication();
        if (myUser != null) {
            PageInfo<Map<String, Object>> pageInfo;
            addCondition(request, myUser.getYxdm());
            PageHelper.startPage(request.getPage(), request.getLimit());
            List<Map<String, Object>> list = studentSourceService.selectStatistics(request.getParams());
            pageInfo = new PageInfo<>(list);
            return ObjectResponse.ok(pageInfo);
        } else {
            return ObjectResponse.fail(CUR_USER_TIME_TO_LIVE);
        }
    }

    @RequestMapping("/goStatisticsByZy")
    public ModelAndView goStatisticsByZy() {
        return new ModelAndView(PREFIX + "statisticsByZy");
    }

    @RequestMapping("/goStatisticsByXl")
    public ModelAndView goStatisticsByXl() {
        return new ModelAndView(PREFIX + "statisticsByXl");
    }

    @RequestMapping("/getStatisticsByZy")
    public ObjectResponse getStatisticsByZy(PageRequest request) {
        MyUser myUser = getAuthentication();
        if (myUser != null) {
            PageInfo<Map<String, Object>> pageInfo;
            addCondition(request, myUser.getYxdm());
            PageHelper.startPage(request.getPage(), request.getLimit());
            List<Map<String, Object>> list = studentSourceService.statisticsByZY(request.getParams());
            pageInfo = new PageInfo<>(list);
            return ObjectResponse.ok(pageInfo);
        } else {
            return ObjectResponse.fail(CUR_USER_TIME_TO_LIVE);
        }
    }

    @RequestMapping("/getStatisticsByXl")
    public ObjectResponse getStatisticsByXl(PageRequest request) {
        MyUser myUser = getAuthentication();
        if (myUser != null) {
            PageInfo<Map<String, Object>> pageInfo;
            addCondition(request, myUser.getYxdm());
            PageHelper.startPage(request.getPage(), request.getLimit());
            List<Map<String, Object>> list = studentSourceService.statisticsByXL(request.getParams());
            pageInfo = new PageInfo<>(list);
            return ObjectResponse.ok(pageInfo);
        } else {
            return ObjectResponse.fail(CUR_USER_TIME_TO_LIVE);
        }
    }


    @RequestMapping("/getErrorStatisticsInfo")
    public ObjectResponse getErrorStatisticsInfo(PageRequest request) {
        MyUser myUser = getAuthentication();
        if (myUser != null) {
            PageInfo<Map<String, Object>> pageInfo;
            addCondition(request, myUser.getYxdm());
            PageHelper.startPage(request.getPage(), request.getLimit());
            List<Map<String, Object>> list = studentSourceService.selectErrorStatistics(request.getParams());
            pageInfo = new PageInfo<>(list);
            return ObjectResponse.ok(pageInfo);
        } else {
            return ObjectResponse.fail(CUR_USER_TIME_TO_LIVE);
        }
    }

    @RequestMapping("goErrorStatisticsByZy")
    public ModelAndView goErrorStatisticsByZy() {
        return new ModelAndView(PREFIX + "errorStatisticsByZy");
    }

    @RequestMapping("goErrorStatisticsByXl")
    public ModelAndView goErrorStatisticsByXl() {
        return new ModelAndView(PREFIX + "errorStatisticsByXl");
    }

    @RequestMapping("/getErrorStatisticsByZy")
    public ObjectResponse getErrorStatisticsByZy(PageRequest request) {
        MyUser myUser = getAuthentication();
        if (myUser != null) {
            PageInfo<Map<String, Object>> pageInfo;
            addCondition(request, myUser.getYxdm());
            PageHelper.startPage(request.getPage(), request.getLimit());
            List<Map<String, Object>> list = studentSourceService.errorStatisticsByZY(request.getParams());
            pageInfo = new PageInfo<>(list);
            return ObjectResponse.ok(pageInfo);
        } else {
            return ObjectResponse.fail(CUR_USER_TIME_TO_LIVE);
        }
    }

    @RequestMapping("/getErrorStatisticsByXl")
    public ObjectResponse getErrorStatisticsByXl(PageRequest request) {
        MyUser myUser = getAuthentication();
        if (myUser != null) {
            PageInfo<Map<String, Object>> pageInfo;
            addCondition(request, myUser.getYxdm());
            PageHelper.startPage(request.getPage(), request.getLimit());
            List<Map<String, Object>> list = studentSourceService.errorStatisticsByXL(request.getParams());
            pageInfo = new PageInfo<>(list);
            return ObjectResponse.ok(pageInfo);
        } else {
            return ObjectResponse.fail(CUR_USER_TIME_TO_LIVE);
        }
    }

    @RequestMapping("/audit")
    public ObjectResponse audit(CoreStudentSource coreStudentSource) {
        if (null == coreStudentSource) {
            return ObjectResponse.fail("coreStudentSource 为空");
        }
        // 查找到当前审核哪个学生的openId
        CoreStudentSource source = studentSourceService.selectByKey(coreStudentSource.getId());
        String openId = source.getOpenId();
        if (StringUtil.isEmpty(openId)) {
            return ObjectResponse.fail("openId为空");
        }
        Byte status = coreStudentSource.getAuditStatus();
        Integer audit_status = 1;
        if (null != status)
            coreStudentSource.setAuditStatus(status);
        String title = "您好，您的生源信息修改申请已经审核通过，请您后期关注信息更新结果。";
        String desc = "\n感谢您的配合。";
        if (status == 3) {
            audit_status = 2;
            title = "您好，您的生源信息修改申请没有通过审核。";
            desc = "\n请进入个人中心，再次进行生源核验，确认信息是否填写有误。";
        }
        Integer affectRowNum1 = studentSourceService.updateNotNull(coreStudentSource);
        if (affectRowNum1 >= 1) {
            InacStudentSourceTemp inacStudentSource = new InacStudentSourceTemp();
            BeanUtils.copyProperties(coreStudentSource, inacStudentSource);
            WeChatService.sendTemplate1(openId, inacStudentSource, audit_status, title, desc, null);
            return ObjectResponse.ok("操作成功!");
        } else {
            return ObjectResponse.ok("操作失败!");
        }
    }

    @RequestMapping(METHOD_INIT)
    public ModelAndView init(String id) {
        ModelAndView mv = new ModelAndView(PREFIX + ME);
        CoreStudentSource CoreStudentSource;
        if (StringUtil.isNotEmpty(id)) {
            CoreStudentSource = studentSourceService.selectByKey(id);
        } else {
            CoreStudentSource = new CoreStudentSource();
        }
        mv.addObject("entity", CoreStudentSource);
        return mv;
    }

    @RequestMapping("/getStudentSource")
    public ObjectResponse getStudentSource(String id) {
        CoreStudentSource coreStudentSource;
        if (StringUtil.isNotEmpty(id)) {
            coreStudentSource = studentSourceService.selectByKey(id);
        } else {
            return ObjectResponse.fail("缺少id");
        }
        return ObjectResponse.ok(coreStudentSource);
    }

    @RequestMapping("/getStudentSourceHistoryById")
    public ObjectResponse getStudentSourceHistoryById(String id) {
        CoreStudentSourceHistory coreStudentSourceHistory;
        if (StringUtil.isNotEmpty(id)) {
            coreStudentSourceHistory = studentSourceHistoryService.selectByKey(id);
        } else {
            return ObjectResponse.fail("缺少id");
        }
        return ObjectResponse.ok(coreStudentSourceHistory);
    }


    @RequestMapping("/getStudentSourceLastEdit")
    public ObjectResponse getStudentSouce(String stuKey) {
        if (StringUtil.isEmpty(stuKey)) {
            return ObjectResponse.fail("请传入参数");
        }
        CoreStudentSourceHistory coreStudentSourceHistory = studentSourceHistoryService.selectSecondNew(stuKey);
        return ObjectResponse.ok(coreStudentSourceHistory);
    }

    @RequestMapping("/getFieldInfo")
    public ObjectResponse getFieldInfo() {
        List<CoreFieldInfo> coreFieldInfos = coreFieldInfoService.selectByOrgIdAndTableName(getAuthentication().getOrganizationId(), "tb_core_student_source");
        return ObjectResponse.ok(coreFieldInfos);
    }

    @RequestMapping(METHOD_SAVE_OR_UPDATE)
    public ObjectResponse saveOrUpdate(CoreStudentSource CoreStudentSource) {
        return saveOrUpdate(studentSourceService, CoreStudentSource.getId(), CoreStudentSource);
    }

    @RequestMapping("/saveWithLog")
    public ObjectResponse saveWithLog(CoreStudentSource coreStudentSource) {
        if (StringUtil.isEmpty(coreStudentSource.getId())) {
            return ObjectResponse.fail("id不能为空");
        }
        int num2 = studentSourceService.updateNotNull(coreStudentSource);
        coreStudentSource = studentSourceService.selectByKey(coreStudentSource.getId());
        CoreStudentSourceHistory beforeSave = studentSourceHistoryService.selectNew(coreStudentSource.getStudentKey());
        CoreStudentSourceHistory coreStudentSourceHistory = new CoreStudentSourceHistory();
        BeanUtils.copyProperties(coreStudentSource, coreStudentSourceHistory);
        coreStudentSourceHistory.setId(null);
        int num1 = studentSourceHistoryService.saveNotNullAutoProp(coreStudentSourceHistory);
        if (num1 == 1 && num2 == 1) {
            CoreLog coreLog = new CoreLog();
            coreLog.setOperator(getAuthentication().getCreator());
            coreLog.setOperatorId(getAuthentication().getCreatorId());
            coreLog.setOperateType("修改");
            coreLog.setNote("");
            coreLog.setCreateTime(new Date());
            coreLog.setStudentId(coreStudentSource.getId());
            coreLog.setNewDataId(coreStudentSourceHistory.getId());
            if (beforeSave == null) {
                coreLog.setOldDataId("");
            } else {
                coreLog.setOldDataId(beforeSave.getId());
            }
            coreLogService.saveAll(coreLog);
            return ObjectResponse.ok("成功");
        } else {
            return ObjectResponse.fail("保存失败");
        }
    }


    @RequestMapping(METHOD_DELETE)
    public ObjectResponse delete(String[] keys) {
        return deleteBatch(studentSourceService, keys);
    }


    /**
     * 根据院校代码查询院系列表的专业
     *
     * @return
     */
    @RequestMapping("/getSzyxZy")
    public ObjectResponse getSzyxZy() {
        MyUser myUser = getAuthentication();
        if (myUser != null) {
            List<Map<String, Object>> resultMap = studentSourceService.selectSzyxZy(myUser.getYxdm());
            JSONArray resultArr = loadSzyxZyTree(resultMap);
            return ObjectResponse.ok(resultArr);
        } else {
            return ObjectResponse.fail(CUR_USER_TIME_TO_LIVE);
        }
    }

    /**
     * 获取学历列表
     *
     * @param studentSource
     * @return
     */
    @RequestMapping("/getStuXlList")
    public ObjectResponse getStuXlList(CoreStudentSource studentSource) {
        MyUser myUser = getAuthentication();
        if (myUser != null) {
            studentSource.setYxdm(myUser.getYxdm());
            return ObjectResponse.ok(studentSourceService.selectXlList(studentSource));
        } else {
            return ObjectResponse.fail("当前用户信息不存在");
        }
    }

    /**
     * 获取专业列表
     *
     * @param studentSource
     * @return
     */
    @RequestMapping("/getStuZyList")
    public ObjectResponse getStuZyList(CoreStudentSource studentSource) {
        MyUser myUser = getAuthentication();
        if (myUser != null) {
            studentSource.setYxdm(myUser.getYxdm());
            return ObjectResponse.ok(studentSourceService.selectZyList(studentSource));
        } else {
            return ObjectResponse.fail("当前用户信息不存在");
        }
    }

    /**
     * 把院校列表转成树形结构图
     *
     * @param resultMap
     * @return
     */
    private JSONArray loadSzyxZyTree(List<Map<String, Object>> resultMap) {
        List<Map<String, Object>> distinctResult = resultMap.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.get(JSON_NAME).toString()))), ArrayList::new));
        // 过滤掉不需要的字段
        PropertyFilter filter = (object, name, value) -> {
            if (JSON_NAME.equalsIgnoreCase(name)) {
                return true;
            }
            return false;
        };
        JSONArray distinctArr = JSONArray.parseArray(JSON.toJSONString(distinctResult, filter));
        JSONArray resultArr = JSONArray.parseArray(JSON.toJSONString(resultMap).replaceAll(JSON_NAME, JSON_SZYX).replaceAll(JSON_LABEL, JSON_NAME));
        for (int i = 0; i < distinctArr.size(); i++) {
            JSONObject parent = distinctArr.getJSONObject(i);
            parent.put("id", i + 1);
            JSONArray j = new JSONArray();
            for (int k = 0; k < resultArr.size(); k++) {
                JSONObject child = resultArr.getJSONObject(k);
                if (parent.getString(JSON_NAME).equals(child.getString(JSON_SZYX))) {
                    JSONObject basicData = new JSONObject();
                    basicData.put(JSON_ZY, child.getString(JSON_ZY));
                    basicData.put(JSON_XL, child.getString(JSON_XL));
                    basicData.put(JSON_SZYX, child.getString(JSON_SZYX));
                    child.put("basicData", basicData);
                    child.put("pid", i + 1);
                    j.add(child);
                }
            }
            parent.put("children", j);
        }
        return distinctArr;
    }

    private InacStudentSourceTemp totemp(CoreStudentSource coreStudentSource) {
        InacStudentSourceTemp inacStudentSourceTemp = new InacStudentSourceTemp();
        BeanUtils.copyProperties(coreStudentSource, inacStudentSourceTemp);
        return inacStudentSourceTemp;
    }
}
