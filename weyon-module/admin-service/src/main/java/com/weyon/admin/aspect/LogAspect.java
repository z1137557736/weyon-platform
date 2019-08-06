package com.weyon.admin.aspect;

import com.alibaba.fastjson.JSONObject;
import com.weyon.admin.anno.MyLog;
import com.weyon.admin.entity.SysOperationLog;
import com.weyon.admin.serivce.SysOperationLogService;
import com.weyon.common.handler.BaseController;
import com.weyon.framework.handler.ObjectResponse;
import com.weyon.framework.util.ClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author liuxu
 * @description 切面日志配置
 * @date 2019-06-10
 **/
@Component
@Aspect
@Slf4j
public class LogAspect {

    @Autowired
    private SysOperationLogService operationLogService;

    private final static String[] sysArr = {".security.handler.MyAuthentication",".Sys"};

    /**
     * 表示匹配带有自定义注解的方法
     */
    @Pointcut("@annotation(com.weyon.admin.anno.MyLog)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            result = point.proceed();
            long endTime = System.currentTimeMillis();
            ObjectResponse myResult;
            if (result != null) {
                if (result instanceof ObjectResponse) {
                    myResult = (ObjectResponse) result;
                } else {
                    myResult = ObjectResponse.ok();
                }
            } else {
                myResult = ObjectResponse.ok();
            }
            insertLog(point, endTime - beginTime, myResult.getCode());
        } catch (Throwable e) {
            log.error("around目标方法中抛出的异常:" + e.getMessage());
        }
        return result;
    }

    /**
     *
     * @param point 切入点参数
     * @param time 响应时间
     * @param code 成功与否
     */
    private void insertLog(ProceedingJoinPoint point, long time, Integer code) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        MyLog myLog = method.getAnnotation(MyLog.class);
        SysOperationLog operationLog = new SysOperationLog();
        if (myLog != null) {
            // 注解上的描述
            operationLog.setOperation(myLog.value());
        }
        // 请求的类名
        String className = point.getTarget().getClass().getName();
        operationLog.setClassName(className);
        // 请求的方法名
        String methodName = signature.getName();
        operationLog.setMethod(methodName);
        // 请求的方法参数值
        String args = className.indexOf(sysArr[0]) == -1 && myLog.param() ? JSONObject.toJSONString(point.getArgs()) : null;
        operationLog.setLogType(2);
        for (String obj : sysArr) {
            if (className.indexOf(obj) != -1) {
                operationLog.setLogType(1);
                break;
            }
        }
        operationLog.setParams(args);
        // 设置执行时间
        operationLog.setTime(time);
        // 设置执行状态
        operationLog.setSuccess(code == 200 ? "成功" : "失败");
        // 为true才获取request
        if(myLog.request()) {
            // 获取request
            HttpServletRequest request = BaseController.getRequest();
            // 设置IP地址
            operationLog.setIp(ClientUtil.getClientIP(request));
            operationLogService.saveNotNull(operationLog);
        } else {
            operationLogService.saveNotNull(operationLog);
        }
        log.info("类名:{},方法名:{},参数：{},执行时间：{}", className, methodName, args, time);
    }
}
