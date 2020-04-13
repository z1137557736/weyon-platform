package com.weyon.admin.serivce.impl;

import com.weyon.admin.dao.SysPermissionMapper;
import com.weyon.admin.entity.SysPermission;
import com.weyon.admin.serivce.SysPermissionService;
import com.weyon.common.model.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liuxu
 * @description 系统权限实现类
 * @date 2019-05-20
 **/
@Service
public class SysPermissionServiceImpl extends BaseService<SysPermission> implements SysPermissionService {

    private static final String CACHE_KEY = "permCache";

    @Autowired
    private SysPermissionMapper permissionMapper;

    @Override
    public List<SysPermission> findByUserId(String userId) {
        return permissionMapper.findByUserId(userId);
    }

    @Cacheable(value = CACHE_KEY, unless = "#result == null")
    @Override
    public List<SysPermission> selectAll() {
        String sort = "sort";
        Example example = new Example(SysPermission.class);
        example.orderBy(sort).asc();
        return super.selectByExample(example);
    }

    @CacheEvict(value = CACHE_KEY, allEntries = true)
    @Override
    public int updateNotNull(SysPermission entity) {
        return super.updateNotNull(entity);
    }

    @CacheEvict(value = CACHE_KEY, allEntries = true)
    @Override
    public int saveNotNull(SysPermission entity) {
        return super.saveNotNull(entity);
    }

    @CacheEvict(value = CACHE_KEY, allEntries = true)
    @Override
    public int delete(Object key) {
        return super.delete(key);
    }
}
