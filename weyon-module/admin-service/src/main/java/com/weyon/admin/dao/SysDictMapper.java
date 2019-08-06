package com.weyon.admin.dao;

import com.weyon.admin.entity.SysDict;
import com.weyon.common.model.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wuyuelong
 * @description 数据字典Dao类
 * @date 2019-07-05
 **/
@Mapper
public interface SysDictMapper extends BaseMapper<SysDict> {
    int insertBatch(List<SysDict> list);
}
