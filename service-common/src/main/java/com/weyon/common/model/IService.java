package com.weyon.common.model;

import java.util.List;

/**
 * @author liuxu
 * @description 公共接口类
 * @date 2019-05-15
 **/
public interface IService<T> {

    /**
     * 根据主键查询实体
     * @param key
     * @return
     */
    T selectByKey(Object key);

    /**
     * 自定义条件查询实体
     * @param example
     * @return
     */
    List<T> selectByExample(Object example);

    /**
     * 自定义条件查询一个实体，多个实体返回时会报错
     * @param example
     * @return
     */
    T selectOneByExample(Object example);

    /**
     * 自定义条件查询实体数量
     * @param example
     * @return
     */
    int selectCountByExample(Object example);

    /**
     * 查询全部实体
     * @return
     */
    List<T> selectAll();

    /**
     * 保存一个实体，全字段添加，不会使用数据库的默认值
     * @param entity
     * @return
     */
    int saveAll(T entity);

    /**
     * 保存一个实体，null的属性不会保存（空字符串可以），会使用数据库默认值
     * @param entity
     * @return
     */
    int saveNotNull(T entity);

    /**
     * 保存多个实体，全字段添加，不会使用数据库的默认值
     * @param recordList
     * @return
     */
    int saveBatch(List<T> recordList);

    /**
     * 保存多个实体，全字段添加，不会使用数据库的默认值，按指定条数添加
     * @param recordList
     * @param count 指定条数添加
     * @return
     */
    int saveBatch(List<T> recordList, int count);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param entity
     * @return
     */
    int updateAll(T entity);

    /**
     * 根据主键更新属性不为null的值
     * @param entity
     * @return
     */
    int updateNotNull(T entity);

    /**
     * 自定义条件更新实体`record`包含的不是null的属性值
     * @param entity
     * @param object
     * @return
     */
    int updateByExampleNotNull(T entity, Object object);

    /**
     * 根据主键批量更新属性不为null的值
     * @param recordList
     * @return
     */
    int updateBatchNotNull(List<T> recordList);

    /**
     * 根据主键批量更新属性不为null的值，按指定条数更新
     * @param recordList
     * @param count 每次更新多少条
     * @return
     */
    int updateBatchNotNull(List<T> recordList, int count);

    /**
     * 根据主键删除实体
     * @param key
     * @return
     */
    int delete(Object key);

    /**
     * 根据主键批量删除实体
     * @param keys
     * @return
     */
    int deleteBatch(String[] keys);

    /**
     * 自定义条件删除实体
     * @param example
     * @return
     */
    int deleteByExample(Object example);
}
