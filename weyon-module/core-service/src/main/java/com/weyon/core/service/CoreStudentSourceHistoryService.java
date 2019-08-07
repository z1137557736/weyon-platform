package com.weyon.core.service;

import com.weyon.core.entity.core.CoreStudentSourceHistory;
import com.weyon.framework.model.IService;

public interface CoreStudentSourceHistoryService extends IService<CoreStudentSourceHistory> {

    CoreStudentSourceHistory selectSecondNew(String studentKey);
    CoreStudentSourceHistory selectNew(String studentKey);
}
