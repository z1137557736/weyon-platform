package com.weyon.core.service;

import com.weyon.common.model.IService;
import com.weyon.core.entity.CoreStudentEmploy;

import java.util.List;
import java.util.Map;

public interface CoreStudentEmployService extends IService<CoreStudentEmploy> {
    List<Map<String, Object>> selectStuEmployList(Map<String, Object> conditions);

    Integer updateBatch(List<CoreStudentEmploy> list);

    Integer saveBatch(List<CoreStudentEmploy> list);
    Map<String,Object> selectStuEmployById(String id);

    CoreStudentEmploy selectByStuKey(String stuKey);
}
