package com.weyon.core.dao;

import com.weyon.common.model.BaseMapper;
import com.weyon.core.entity.CoreStudentSourceHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreStudentSourceHistoryMapper extends BaseMapper<CoreStudentSourceHistory> {

    CoreStudentSourceHistory selectSecondNew(String studentKey);
    CoreStudentSourceHistory selectNew(String studentKey);
}
