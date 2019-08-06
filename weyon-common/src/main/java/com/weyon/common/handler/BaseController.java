package com.weyon.common.handler;

import com.alibaba.fastjson.JSONObject;
import com.weyon.framework.handler.ObjectResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuxu
 * @description 控制层服务类
 * @date 2019-05-21
 **/
@RestControllerAdvice
public class BaseController {

    /**
     * like条件筛选
     * @param criteria
     * @param params
     * @param conditions
     */
    public void exampleLike(Example.Criteria criteria, JSONObject params, String... conditions) {
        defaultExample(2, criteria, params, conditions);
    }

    /**
     * 条件筛选 前台传来的参数必须与实体类的属性对应
     * @param criteria
     * @param params
     * @param conditions
     */
    public void exampleEquals(Example.Criteria criteria, JSONObject params, String... conditions) {
        defaultExample(1, criteria, params, conditions);
    }

    private void defaultExample(Integer type, Example.Criteria criteria, JSONObject params, String... conditions) {
        if (conditions != null && conditions.length > 0 && params != null) {
            for (String str : conditions) {
                if (StringUtil.isNotEmpty(params.getString(str))) {
                    switch (type) {
                        case 1:
                            criteria.andEqualTo(str, params.getString(str));
                            break;
                        case 2:
                            criteria.andLike(str, "%" + params.getString(str) + "%");
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    /**
     * 筛选开始时间与结束时间 默认属性为startDate,endDate
     * @param criteria
     * @param params
     * @param date 指定筛选的日期属性（实体类的日期属性）
     */
    public void exampleGtAndLtDate(Example.Criteria criteria, JSONObject params, String date) {
        criteria.andGreaterThanOrEqualTo(date, params.getDate("startDate"));
        criteria.andLessThanOrEqualTo(date, params.getDate("endDate"));
    }

    /**
     * 获取文件流
     * @param filePath 文件路径
     * @param fileName 文件名称
     * @return
     */
    public static Resource getFile(String filePath , String fileName) {
        Resource resource = new ClassPathResource(filePath + fileName);
        if (resource.exists()) {
            return resource;
        }
        return null;
    }

    public static HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取class目录绝对路径
     * @return
     */
    public static String getResourcePath(){
        return ClassUtils.getDefaultClassLoader().getResource("").getPath();
    }
}
