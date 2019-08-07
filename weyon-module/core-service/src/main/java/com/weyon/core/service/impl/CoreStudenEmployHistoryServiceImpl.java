package com.weyon.core.service.impl;

import com.weyon.core.dao.core.CoreStudentEmployHistoryMapper;
import com.weyon.core.entity.core.CoreStudentEmployHistory;
import com.weyon.core.service.core.CoreStudentEmployHistoryService;
import com.weyon.framework.model.BaseService;
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
