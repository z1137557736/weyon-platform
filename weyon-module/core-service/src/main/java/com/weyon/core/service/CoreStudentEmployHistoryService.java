package com.weyon.core.service;

import com.weyon.common.model.IService;
import com.weyon.core.entity.CoreStudentEmployHistory;


public interface CoreStudentEmployHistoryService extends IService<CoreStudentEmployHistory> {
    CoreStudentEmployHistory selectSecondNew(String studentKey);
    CoreStudentEmployHistory selectNew(String studentKey);
}
