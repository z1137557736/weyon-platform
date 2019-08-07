package com.weyon.core.service;
import com.weyon.common.model.IService;
import com.weyon.core.entity.CoreFieldInfo;

public interface CoreFieldInfoService extends IService<CoreFieldInfo> {
    int updateBatch(List<CoreFieldInfo> CoreFieldInfoList);
    int insertBatch(List<CoreFieldInfo> CoreFieldInfos);
    List<CoreFieldInfo> selectByOrgIdAndTableName(String orgId, String tableName);
}
