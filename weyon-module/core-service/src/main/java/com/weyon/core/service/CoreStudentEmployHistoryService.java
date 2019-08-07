package com.weyon.core.service;

import com.weyon.core.entity.core.CoreStudentEmployHistory;
import com.weyon.framework.model.IService;

public interface CoreStudentEmployHistoryService extends IService<CoreStudentEmployHistory> {
    CoreStudentEmployHistory selectSecondNew(String studentKey);
    CoreStudentEmployHistory selectNew(String studentKey);
}
