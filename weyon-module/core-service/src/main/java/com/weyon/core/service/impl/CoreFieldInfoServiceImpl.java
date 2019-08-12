package com.weyon.core.service.impl;

import com.weyon.common.model.BaseService;
import com.weyon.core.dao.CoreFieldInfoMapper;
import com.weyon.core.entity.CoreFieldInfo;
import com.weyon.core.service.CoreFieldInfoService;
import com.weyon.framework.constant.RedisConstant;
import com.weyon.security.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoreFieldInfoServiceImpl extends BaseService<CoreFieldInfo> implements CoreFieldInfoService {
    @Autowired
    private CoreFieldInfoMapper coreFieldInfoMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public int updateBatch(List<CoreFieldInfo> CoreFieldInfos){
        return coreFieldInfoMapper.updateBatch(CoreFieldInfos);
    }

    @Override
    public int insertBatch(List<CoreFieldInfo> CoreFieldInfos){
        return coreFieldInfoMapper.insertBatch(CoreFieldInfos);
    }

    @Override
    public List<CoreFieldInfo> selectByOrgIdAndTableName(String orgId, String tableName){
        if(redisService.hasKeyHashItem(RedisConstant.CORE_FIELD_INFO_MAP_KEY,orgId+tableName)){
            return (List<CoreFieldInfo>) redisService.getHashItem(RedisConstant.CORE_FIELD_INFO_MAP_KEY,orgId+tableName);
        }else {
            List<CoreFieldInfo> CoreFieldInfos = coreFieldInfoMapper.selectByOrgIdAndTableName(orgId,tableName);
            if(CoreFieldInfos.size()!=0) {
                redisService.setHashItem(RedisConstant.CORE_FIELD_INFO_MAP_KEY, orgId + tableName, CoreFieldInfos);
            }
            return CoreFieldInfos;
        }
    }

}
