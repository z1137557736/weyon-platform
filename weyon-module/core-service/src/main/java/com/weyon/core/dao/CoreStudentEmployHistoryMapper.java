package com.weyon.core.dao;

import com.weyon.common.model.BaseMapper;
import com.weyon.core.entity.CoreStudentEmployHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreStudentEmployHistoryMapper extends BaseMapper<CoreStudentEmployHistory> {
    CoreStudentEmployHistory selectSecondNew(String studentKey);
    CoreStudentEmployHistory selectNew(String studentKey);
}
