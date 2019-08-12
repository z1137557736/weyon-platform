package com.weyon.core.service.impl;

import com.weyon.common.model.BaseService;
import com.weyon.core.dao.CoreStudentEmployHistoryMapper;
import com.weyon.core.entity.CoreStudentEmployHistory;
import com.weyon.core.service.CoreStudentEmployHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreStudenEmployHistoryServiceImpl extends BaseService<CoreStudentEmployHistory> implements CoreStudentEmployHistoryService {
    @Autowired
    private CoreStudentEmployHistoryMapper coreStudentEmployHistoryMapper;
    public CoreStudentEmployHistory selectSecondNew(String studentKey){
        return coreStudentEmployHistoryMapper.selectSecondNew(studentKey);
    }
    public CoreStudentEmployHistory selectNew(String studentKey){
        return coreStudentEmployHistoryMapper.selectNew(studentKey);
    }
}
