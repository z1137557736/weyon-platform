package com.weyon.common.handler;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author liuxu
 * @description 控制层服务类
 * @date 2019-05-21
 **/
public class BaseController {

    protected JSONObject conditions = new JSONObject();

    /**
     * 获取筛选条件
     * @return
     */
    public JSONObject getConditions() {
        conditions = new JSONObject();
        Map<String, String[]> maps = this.getRequest().getParameterMap();
        if (!maps.isEmpty()) {
            for (String key : maps.keySet()) {
                if (StringUtil.isEmpty(key)) {
                    continue;
                }
                if ((conditions.containsKey(key))) {
                    continue;
                }
                conditions.put(key, maps.get(key)[0]);
            }
        }
        return conditions;
    }

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

    public HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
