package com.weyon.admin.serivce.impl;

import com.weyon.admin.dao.SysDictMapper;
import com.weyon.admin.entity.SysDict;
import com.weyon.admin.serivce.SysDictService;
import com.weyon.framework.constant.RedisConstant;
import com.weyon.common.model.BaseService;
import com.weyon.security.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuyuelong
 * @description 数据字典接口实现类
 * @date 2019-07-05
 **/
@Service
public class SysDictServiceImpl extends BaseService<SysDict> implements SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public List<SysDict> selectAll(){
       List<SysDict> list = (List<SysDict>) redisService.get(RedisConstant.DICT_DATA_KEY);
       if(null == list || list.isEmpty()){
           list = sysDictMapper.selectAll();

           redisService.set(RedisConstant.DICT_DATA_KEY, list);
           //值存放在redis Map存储结构 用于上传检验
           Map<String,Integer> map = new HashMap<>();
           list.stream().filter(l->!l.getPid().equals("0")).forEach(l->map.put(l.getName(), l.getCode()));
           redisService.setHash(RedisConstant.DICT_DATA_MAP_KEY, map);
       }
        return list;
    }

    @Override
    public int insertBatch(List<SysDict> sysDicts){
        return sysDictMapper.insertBatch(sysDicts);
    }
}
