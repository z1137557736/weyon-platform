package com.weyon.core.service.impl;

import com.weyon.controller.constant.RedisConstant;
import com.weyon.core.dao.core.CoreFieldInfoMapper;
import com.weyon.core.entity.core.CoreFieldInfo;
import com.weyon.core.service.core.CoreFieldInfoService;
import com.weyon.framework.model.BaseService;
import com.weyon.framework.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoreFieldInfoServiceImpl extends BaseService<CoreFieldInfo> implements CoreFieldInfoService  {
    @Autowired
    private CoreFieldInfoMapper CoreFieldInfoMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public int updateBatch(List<CoreFieldInfo> CoreFieldInfos){
        return CoreFieldInfoMapper.updateBatch(CoreFieldInfos);
    }

    @Override
    public int insertBatch(List<CoreFieldInfo> CoreFieldInfos){
        return CoreFieldInfoMapper.insertBatch(CoreFieldInfos);
    }

    @Override
    public List<CoreFieldInfo> selectByOrgIdAndTableName(String orgId, String tableName){
        if(redisService.hasKeyHashItem(RedisConstant.CORE_FIELD_INFO_MAP_KEY,orgId+tableName)){
            return (List<CoreFieldInfo>) redisService.getHashItem(RedisConstant.CORE_FIELD_INFO_MAP_KEY,orgId+tableName);
        }else {
            List<CoreFieldInfo> CoreFieldInfos = CoreFieldInfoMapper.selectByOrgIdAndTableName(orgId,tableName);
            if(CoreFieldInfos.size()!=0) {
                redisService.setHashItem(RedisConstant.CORE_FIELD_INFO_MAP_KEY, orgId + tableName, CoreFieldInfos);
            }
            return CoreFieldInfos;
        }
    }

}
