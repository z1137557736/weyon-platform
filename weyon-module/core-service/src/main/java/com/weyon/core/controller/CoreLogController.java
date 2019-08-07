package com.weyon.core.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weyon.controller.handler.BaseController;
import com.weyon.controller.handler.ObjectResponse;
import com.weyon.controller.handler.PageRequest;
import com.weyon.core.entity.core.CoreLog;
import com.weyon.core.service.core.CoreLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RestController
@RequestMapping(CoreLogController.PARENT)
public class CoreLogController extends BaseController {
    private static final String ME = "log";

    public static final String PARENT = "/core/" + ME;

    private static final String PREFIX = "backstage" + PARENT + "/";

    @Autowired
    private CoreLogService coreLogService;

    @RequestMapping("getByStudentId")
    public ObjectResponse getCoreListByStudentId(String studentId, PageRequest request){
        PageInfo<CoreLog> pageInfo;
        PageHelper.startPage(request.getPage(),request.getLimit());
        Example example =  new Example(CoreLog.class);
        example.createCriteria().andEqualTo("studentId",studentId);
        example.orderBy("createTime").desc();
        List<CoreLog> coreLogs = coreLogService.selectByExample(example);
        pageInfo = new PageInfo<>(coreLogs);
        return ObjectResponse.ok(pageInfo);
    }

    @RequestMapping("getSourceLogDetailview")
    public ModelAndView getSourceLogDetailview(String id){
        ModelAndView mv = new ModelAndView("backstage/core/stuSource/logDetail");
        CoreLog coreLog = coreLogService.selectByKey(id);
        mv.addObject("entity",coreLog);
        return mv;
    }
    @RequestMapping("getEmployLogDetailview")
    public ModelAndView getEmployLogDetailview(String id){
        ModelAndView mv = new ModelAndView("backstage/core/stuEmploy/logDetail");
        CoreLog coreLog = coreLogService.selectByKey(id);
        mv.addObject("entity",coreLog);
        return mv;
    }

}
