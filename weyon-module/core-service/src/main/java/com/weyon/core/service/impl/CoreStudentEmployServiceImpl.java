package com.weyon.core.service.impl;

import com.weyon.common.model.BaseService;
import com.weyon.core.dao.CoreStudentEmployMapper;
import com.weyon.core.entity.CoreStudentEmploy;
import com.weyon.core.service.CoreStudentEmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class CoreStudentEmployServiceImpl extends BaseService<CoreStudentEmploy> implements CoreStudentEmployService {
    @Autowired
    private CoreStudentEmployMapper studentEmployMapper;

    @Override
    public List<Map<String, Object>> selectStuEmployList(Map<String, Object> conditions) {
        return studentEmployMapper.selectStuEmployList(conditions);
    }

    @Override
    public Map<String, Object> selectStuEmployById(String id) {
        return studentEmployMapper.selectStuEmployById(id);
    }

    @Override
    public Integer updateBatch(List<CoreStudentEmploy> list) {
        return studentEmployMapper.updateBatch(list);
    }

    @Override
    public Integer saveBatch(List<CoreStudentEmploy> list) {
        return studentEmployMapper.saveBatch(list);
    }
    @Override
    public CoreStudentEmploy selectByStuKey(String stuKey) {
        Example example = new Example(CoreStudentEmploy.class);
        example.createCriteria().andEqualTo("studentKey",stuKey);
        return this.selectOneByExample(example);
    }
}
