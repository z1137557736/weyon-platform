package com.weyon.core.service;

import com.weyon.common.model.IService;
import com.weyon.core.entity.CoreStudentSourceHistory;

public interface CoreStudentSourceHistoryService extends IService<CoreStudentSourceHistory> {

    CoreStudentSourceHistory selectSecondNew(String studentKey);
    CoreStudentSourceHistory selectNew(String studentKey);
}
