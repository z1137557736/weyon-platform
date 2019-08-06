package com.weyon.common.model;

import java.util.List;

/**
 * @author liuxu
 * @description 公共接口类
 * @date 2019-05-15
 **/
public interface IService<T> {

    T selectByKey(Object key);

    int saveAll(T entity);

    int saveNotNull(T entity);

    int delete(Object key);

    void deleteBatch(String[] keys);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

    List<T> selectAll();

    T selectOneByExample(Object example);

}
