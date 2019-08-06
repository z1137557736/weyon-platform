package com.weyon.admin.serivce;

import com.weyon.admin.entity.SysDict;
import com.weyon.common.model.IService;

import java.util.List;

/**
 *@author wuyuelong
 * * @description 数据字典接口类
 * @date 2019-07-5
 */
public interface SysDictService extends IService<SysDict> {
    int insertBatch(List<SysDict> sysDicts);
}
