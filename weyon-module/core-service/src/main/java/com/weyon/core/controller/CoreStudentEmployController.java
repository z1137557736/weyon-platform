//package com.weyon.core.controller;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.weyon.controller.handler.BaseController;
//import com.weyon.controller.handler.ObjectResponse;
//import com.weyon.controller.handler.PageRequest;
//import com.weyon.core.entity.core.CoreFieldInfo;
//import com.weyon.core.entity.core.CoreLog;
//import com.weyon.core.entity.core.CoreStudentEmploy;
//import com.weyon.core.entity.core.CoreStudentEmployHistory;
//import com.weyon.core.service.CoreFieldInfoService;
//import com.weyon.core.service.CoreLogService;
//import com.weyon.core.service.CoreStudentEmployHistoryService;
//import com.weyon.core.service.CoreStudentEmployService;
//import com.weyon.framework.model.MyUser;
//import com.weyon.security.service.RedisService;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//import tk.mybatis.mapper.util.StringUtil;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping(CoreStudentEmployController.PARENT)
//public class CoreStudentEmployController extends BaseController {
//    private static final String ME = "stuEmploy";
//
//    public static final String PARENT = "/core/" + ME;
//
//    private static final String PREFIX = "backstage" + PARENT + "/";
//
//    @Autowired
//    private CoreStudentEmployService studentEmployService;
//    @Autowired
//    private CoreStudentEmployHistoryService studentEmployHistoryService;
//    @Autowired
//    private CoreLogService coreLogService;
//    @Autowired
//    private RedisService redisService;
//    @Autowired
//    private CoreFieldInfoService coreFieldInfoService;
//
//    @RequestMapping(METHOD_GO_LIST)
//    public ModelAndView goList(){
//        return new ModelAndView(PREFIX + ME + "List");
//    }
//
//    /**
//     * 获取角色
//     * @return
//     */
//    @RequestMapping(METHOD_GET_LIST)
//    public ObjectResponse getList(PageRequest request){
//        MyUser myUser = getAuthentication();
//        if (myUser != null) {
//            PageInfo<Map<String, Object>> pageInfo;
//            PageHelper.startPage(request.getPage(), request.getLimit());
//            request.getParams().put("yxdm", myUser.getYxdm());
//            List<Map<String, Object>> studentEmployList = studentEmployService.selectStuEmployList(request.getParams());
//            pageInfo = new PageInfo<>(studentEmployList);
//            return ObjectResponse.ok(pageInfo);
//        } else {
//            return ObjectResponse.fail(CUR_USER_TIME_TO_LIVE);
//        }
//    }
//
//    @RequestMapping(METHOD_INIT)
//    public ModelAndView init(String id) {
//        ModelAndView mv = new ModelAndView(PREFIX + ME);
//        CoreStudentEmploy CoreStudentEmploy;
//        if (StringUtil.isNotEmpty(id)) {
//            CoreStudentEmploy = studentEmployService.selectByKey(id);
//        } else {
//            CoreStudentEmploy = new CoreStudentEmploy();
//        }
//        mv.addObject("entity", CoreStudentEmploy);
//        return mv;
//    }
//
//    @RequestMapping("/getStudentEmploy")
//    public ObjectResponse getStudentEmploy(String id){
//        Map<String,Object> inacStudentEmploy;
//        if (StringUtil.isNotEmpty(id)) {
//            inacStudentEmploy = studentEmployService.selectStuEmployById(id);
//        } else {
//            return ObjectResponse.fail("缺少id");
//        }
//        return ObjectResponse.ok(inacStudentEmploy);
//    }
//
//    @RequestMapping("/getFieldInfo")
//    public ObjectResponse getFieldInfo() {
//        List<CoreFieldInfo> coreFieldInfos = coreFieldInfoService.selectByOrgIdAndTableName(getAuthentication().getOrganizationId(), "tb_core_student_employ");
//        return ObjectResponse.ok(coreFieldInfos);
//    }
//
//    @RequestMapping("/getStudentEmployHistoryById")
//    public ObjectResponse getStudentEmployHistoryByid(String id){
//        CoreStudentEmployHistory coreStudentEmployHistory;
//        if (StringUtil.isNotEmpty(id)) {
//            coreStudentEmployHistory = studentEmployHistoryService.selectByKey(id);
//        } else {
//            return ObjectResponse.fail("缺少id");
//        }
//        return ObjectResponse.ok(coreStudentEmployHistory);
//    }
//
//    @RequestMapping(METHOD_SAVE_OR_UPDATE)
//    public ObjectResponse saveOrUpdate(CoreStudentEmploy CoreStudentEmploy) {
//        return saveOrUpdate(studentEmployService, CoreStudentEmploy.getId(), CoreStudentEmploy);
//    }
//
//    @RequestMapping(METHOD_DELETE)
//    public ObjectResponse delete(String[] keys) {
//        return deleteBatch(studentEmployService, keys);
//    }
//
//    @RequestMapping(value = "/import")
//    public ModelAndView importFile() {
//        return new ModelAndView(PREFIX  + "importStuEmploy");
//    }
//
//    @RequestMapping("/saveWithLog")
//    public ObjectResponse saveWithLog(CoreStudentEmploy coreStudentEmploy){
//        if(StringUtil.isEmpty(coreStudentEmploy.getId())){
//            return ObjectResponse.fail("id不能为空");
//        }
//        int num2 = studentEmployService.updateNotNull(coreStudentEmploy);
//        coreStudentEmploy = studentEmployService.selectByKey(coreStudentEmploy.getId());
//        CoreStudentEmployHistory beforeSave = studentEmployHistoryService.selectNew(coreStudentEmploy.getStudentKey());
//        CoreStudentEmployHistory coreStudentEmployHistory = new CoreStudentEmployHistory();
//        BeanUtils.copyProperties(coreStudentEmploy, coreStudentEmployHistory);
//        coreStudentEmployHistory.setId(null);
//        coreStudentEmployHistory.setCreateDate(new Date());
//        int num1 = studentEmployHistoryService.saveNotNullAutoProp(coreStudentEmployHistory);
//        if(num1==1 && num2 ==1){
//            CoreLog coreLog = new CoreLog();
//            coreLog.setOperator(getAuthentication().getCreator());
//            coreLog.setOperatorId(getAuthentication().getCreatorId());
//            coreLog.setOperateType("修改");
//            coreLog.setNote("");
//            coreLog.setCreateTime(new Date());
//            coreLog.setStudentId(coreStudentEmploy.getId());
//            coreLog.setNewDataId(coreStudentEmployHistory.getId());
//            if (beforeSave == null) {
//                coreLog.setOldDataId("");
//            } else {
//                coreLog.setOldDataId(beforeSave.getId());
//            }
//            coreLogService.saveAll(coreLog);
//            return ObjectResponse.ok("成功");
//        }else {
//            return ObjectResponse.fail("保存失败");
//        }
//    }
//
//    @RequestMapping("/getStudentSourceLastEdit")
//    public  ObjectResponse getStudentEmployBackup(String stuKey){
//        if(StringUtil.isEmpty(stuKey)){
//            return ObjectResponse.fail("请传入参数");
//        }
//        CoreStudentEmployHistory studentEmployHistory = studentEmployHistoryService.selectSecondNew(stuKey);
//        return ObjectResponse.ok(studentEmployHistory);
//    }
//}
