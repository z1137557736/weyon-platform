package com.weyon.core.dao;

import com.weyon.common.model.BaseMapper;
import com.weyon.core.entity.CoreFieldInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CoreFieldInfoMapper extends BaseMapper<CoreFieldInfo> {
    int updateBatch(List<CoreFieldInfo> CoreFieldInfos);
    int insertBatch(List<CoreFieldInfo> CoreFieldInfos);
    List<CoreFieldInfo> selectByOrgIdAndTableName(String orgId, String tableName);
}
