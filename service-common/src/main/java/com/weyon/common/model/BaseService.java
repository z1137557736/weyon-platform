package com.weyon.common.model;

import com.weyon.common.mapper.SpecialBatchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.additional.dialect.oracle.OracleMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.Arrays;
import java.util.List;

/**
 * @author liuxu
 * @description 通用service抽象类
 * @date 2019-05-15
 **/
@Transactional(rollbackFor = Exception.class)
public abstract class BaseService<T> implements IService<T> {

    @Autowired
    protected Mapper<T> mapper;

    @Autowired
    protected SpecialBatchMapper<T> specialBatchMapper;

    @Override
    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public int selectCountByExample(Object example) {
        return mapper.selectCountByExample(example);
    }
    @Override
    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    @Override
    public T selectOneByExample(Object example) {
        return mapper.selectOneByExample(example);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }


    @Override
    public int saveAll(T entity) {
        return mapper.insert(entity);
    }

    @Override
    public int saveNotNull(T entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public int saveBatch(List<T> recordList) {
        return insertList(recordList);
    }

    @Override
    public int saveBatch(List<T> recordList, int count) {
        if (recordList.isEmpty()) {
            return 0;
        }
        // 数据没超过指定数量，直接添加
        if (recordList.size() <= count) {
            return insertList(recordList);
        }
        // 执行次数
        int number = recordList.size() % count == 0 ? recordList.size() / count : recordList.size() / count + 1;
        // 按批次添加数据
        int result = 0;
        for (int i = 0; i < number; i++) {
            // 循环到最后一次时toIndex等于list.size()
            int toIndex = i != number - 1 ? (i + 1) * count : recordList.size();
            result += insertList(recordList.subList(i * count, toIndex));
        }
        return result;
    }

    public int insertList(List<T> recordList) {
        return specialBatchMapper.saveBatch(recordList);
    }

    @Override
    public int updateAll(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }
    @Override
    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int updateByExampleNotNull(T entity, Object object) {
        return mapper.updateByExampleSelective(entity, object);
    }

    @Override
    public int updateBatchNotNull(List<T> recordList) {
        return specialBatchMapper.updateBatchNotNull(recordList);
    }

    @Override
    public int updateBatchNotNull(List<T> recordList, int count) {
        if (recordList.isEmpty()) {
            return 0;
        }
        // 数据没超过指定数量，直接添加
        if (recordList.size() <= count) {
            return this.updateBatchNotNull(recordList);
        }
        // 执行次数
        int number = recordList.size() % count == 0 ? recordList.size() / count : recordList.size() / count + 1;
        // 按批次添加数据
        int result = 0;
        for (int i = 0; i < number; i++) {
            // 循环到最后一次时toIndex等于list.size()
            int toIndex = i != number - 1 ? (i + 1) * count : recordList.size();
            result += this.updateBatchNotNull(recordList.subList(i * count, toIndex));
        }
        return result;
    }

    @Override
    public int delete(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    @Override
    public int deleteBatch(String[] keys) {
        return specialBatchMapper.deleteBatch(Arrays.asList(keys));
    }

    @Override
    public int deleteByExample(Object example) {
        return mapper.deleteByExample(example);
    }

}
