package com.weyon.core.service.impl;

import com.weyon.core.dao.core.CoreStudentSourceHistoryMapper;
import com.weyon.core.entity.core.CoreStudentSourceHistory;
import com.weyon.core.service.core.CoreStudentSourceHistoryService;
import com.weyon.framework.model.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreStudentSourceHistoryServiceImpl extends BaseService<CoreStudentSourceHistory> implements CoreStudentSourceHistoryService {
    @Autowired
    private CoreStudentSourceHistoryMapper studentSourceMapper;

    public CoreStudentSourceHistory selectSecondNew(String studentKey){
        return studentSourceMapper.selectSecondNew(studentKey);
    }
    public CoreStudentSourceHistory selectNew(String studentKey){
        return studentSourceMapper.selectNew(studentKey);
    }
}
