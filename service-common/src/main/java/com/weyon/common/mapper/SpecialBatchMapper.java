package com.weyon.common.mapper;

import com.weyon.common.mapper.provider.SpecialBatchProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.UpdateProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * @author liuxu
 * @description 特殊处理的批量操作
 * @date 2019-09-18
 **/
@RegisterMapper
public interface SpecialBatchMapper<T> {

    /**
     * 批量全列添加，数据库默认值失效，主键字段也需要手动插入
     * @param recordList
     * @return
     */
    @Options(useGeneratedKeys = true)
    @InsertProvider(type = SpecialBatchProvider.class, method = "dynamicSQL")
    int saveBatch(List<T> recordList);

    /**
     * 批量动态修改（属性不为null），使用case when的方式
     * @param recordList
     * @return
     */
    @UpdateProvider(type = SpecialBatchProvider.class, method = "dynamicSQL")
    int updateBatchNotNull(List<T> recordList);

    /**
     * 根据主键批量删除
     * @param ids
     * @return
     */
    @DeleteProvider(type = SpecialBatchProvider.class, method = "dynamicSQL")
    int deleteBatch(List<String> ids);
}
