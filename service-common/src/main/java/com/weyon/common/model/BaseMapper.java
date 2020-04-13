package com.weyon.common.model;

import com.weyon.common.mapper.SpecialBatchMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author liuxu
 * @description 通用mapper
 * @date 2019-03-31
 **/
public interface BaseMapper<T> extends Mapper<T>, SpecialBatchMapper<T> {
}