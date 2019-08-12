package com.weyon.core.service.impl;

import com.weyon.common.model.BaseService;
import com.weyon.core.dao.CoreStudentSourceHistoryMapper;
import com.weyon.core.entity.CoreStudentSourceHistory;
import com.weyon.core.service.CoreStudentSourceHistoryService;
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
