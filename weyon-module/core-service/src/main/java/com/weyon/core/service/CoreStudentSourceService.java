package com.weyon.core.service;

import com.alibaba.fastjson.JSONObject;
import com.weyon.core.entity.core.CoreStudentSource;
import com.weyon.framework.model.IService;

import java.util.List;
import java.util.Map;

public interface CoreStudentSourceService extends IService<CoreStudentSource> {
    /**
     * 根据院校代码查询院系列表的专业
     * @param yxdm 院校代码
     * @return
     */
    List<Map<String, Object>> selectSzyxZy(String yxdm);

    /**
     * 根据条件获取学历
     * @param studentSource 筛选条件
     * @return
     */
    List<Map<String, Object>> selectXlList(CoreStudentSource studentSource);

    /**
     * 根据条件获取专业
     * @param studentSource 筛选条件
     * @return
     */
    List<Map<String, Object>> selectZyList(CoreStudentSource studentSource);
    /**
     * 批量更新
     * @param list
     * @return
     */
    Integer updateBatch(List<CoreStudentSource> list);

    /**
     * 批量添加
     * @param list
     * @return
     */
    Integer saveBatch(List<CoreStudentSource> list);

    /**
     * 生源信息统计
     * @param object
     * @return
     */
    List<Map<String,Object>> selectStatistics(JSONObject object);

    List<Map<String,Object>> statisticsByZY(JSONObject object);

    List<Map<String,Object>> statisticsByXL(JSONObject object);


    /**
     * 生源错误信息统计
     * @param object
     * @return
     */
    List<Map<String,Object>> selectErrorStatistics(JSONObject object);

    List<Map<String,Object>> errorStatisticsByZY(JSONObject object);

    List<Map<String,Object>> errorStatisticsByXL(JSONObject object);

    CoreStudentSource selectByOpenId(String openId);
}
