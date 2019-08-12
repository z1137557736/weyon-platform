package com.weyon.core.dao;

import com.weyon.common.model.BaseMapper;
import com.weyon.core.entity.CoreStudentEmploy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface CoreStudentEmployMapper extends BaseMapper<CoreStudentEmploy> {
    List<Map<String, Object>> selectStuEmployList(Map<String, Object> conditions);
    Map<String, Object> selectStuEmployById(String id);

    Integer updateBatch(List<CoreStudentEmploy> list);

    Integer saveBatch(List<CoreStudentEmploy> list);
}
