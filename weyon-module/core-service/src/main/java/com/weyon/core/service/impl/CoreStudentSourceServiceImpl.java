package com.weyon.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.weyon.common.model.BaseService;
import com.weyon.core.dao.CoreStudentSourceMapper;
import com.weyon.core.entity.CoreStudentSource;
import com.weyon.core.service.CoreStudentSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class CoreStudentSourceServiceImpl extends BaseService<CoreStudentSource> implements CoreStudentSourceService {
    @Autowired
    private CoreStudentSourceMapper studentSourceMapper;

    @Override
    public List<Map<String, Object>> selectSzyxZy(String yxdm) {
        return studentSourceMapper.selectSzyxZy(yxdm);
    }

    @Override
    public List<Map<String, Object>> selectXlList(CoreStudentSource studentSource) {
        return studentSourceMapper.selectXlList(studentSource);
    }

    @Override
    public List<Map<String, Object>> selectZyList(CoreStudentSource studentSource) {
        return studentSourceMapper.selectZyList(studentSource);
    }


    @Override
    public Integer updateBatch(List<CoreStudentSource> list) {
        return studentSourceMapper.updateBatch(list);
    }

    @Override
    public Integer saveBatch(List<CoreStudentSource> list) {
        return studentSourceMapper.saveBatch(list);
    }

    @Override
    public List<Map<String, Object>> selectStatistics(JSONObject object) {
        return studentSourceMapper.selectStatistics(object);
    }

    @Override
    public List<Map<String, Object>> statisticsByZY(JSONObject object) {
        return studentSourceMapper.statisticsByZY(object);
    }

    @Override
    public List<Map<String, Object>> statisticsByXL(JSONObject object) {
        return studentSourceMapper.statisticsByXL(object);
    }

    @Override
    public List<Map<String, Object>> selectErrorStatistics(JSONObject object) {
        return studentSourceMapper.selectErrorStatistics(object);
    }

    @Override
    public List<Map<String, Object>> errorStatisticsByZY(JSONObject object) {
        return studentSourceMapper.errorStatisticsByZY(object);
    }

    @Override
    public List<Map<String, Object>> errorStatisticsByXL(JSONObject object) {
        return studentSourceMapper.errorStatisticsByXL(object);
    }

    @Override
    public CoreStudentSource selectByOpenId(String openId) {
        Example example = new Example(CoreStudentSource.class);
        example.createCriteria().andEqualTo("openId",openId);
        return this.selectOneByExample(example);
    }
}
