package com.weyon.core.dao;

import com.alibaba.fastjson.JSONObject;
import com.weyon.common.model.BaseMapper;
import com.weyon.core.entity.CoreStudentSource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface CoreStudentSourceMapper extends BaseMapper<CoreStudentSource> {
    List<Map<String, Object>> selectSzyxZy(@Param("yxdm") String yxdm);

    List<Map<String, Object>> selectXlList(CoreStudentSource studentSource);

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

    /**
     * 根据专业统计生源信息
     * @param object
     * @return
     */
    List<Map<String,Object>> statisticsByZY(JSONObject object);
    /**
     * 根据学历统计生源信息
     * @param object
     * @return
     */
    List<Map<String,Object>> statisticsByXL(JSONObject object);

    /**
     * 生源错误信息统计
     * @param object
     * @return
     */
    List<Map<String,Object>> selectErrorStatistics(JSONObject object);
    /**
     * 根据专业统计错误生源信息
     * @param object
     * @return
     */
    List<Map<String,Object>> errorStatisticsByZY(JSONObject object);
    /**
     * 根据学历统计错误生源信息
     * @param object
     * @return
     */
    List<Map<String,Object>> errorStatisticsByXL(JSONObject object);
}
