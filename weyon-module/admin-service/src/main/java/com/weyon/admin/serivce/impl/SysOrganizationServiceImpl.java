package com.weyon.admin.serivce.impl;

import com.weyon.admin.dao.SysOrganizationMapper;
import com.weyon.admin.entity.SysOrganization;
import com.weyon.admin.serivce.SysOrganizationService;
import com.weyon.common.model.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liuxu
 * @description 组织机构接口实现类
 * @date 2019-05-21
 **/
@Service
public class SysOrganizationServiceImpl extends BaseService<SysOrganization> implements SysOrganizationService {

    private static final String CACHE_KEY = "orgCache";

    @Autowired
    private SysOrganizationMapper organizationMapper;

    @Cacheable(value = CACHE_KEY, unless = "#result == null")
    @Override
    public List<SysOrganization> selectAll() {
        String sort = "sort";
        Example example = new Example(SysOrganization.class);
        example.orderBy(sort).asc();
        List<SysOrganization> list = organizationMapper.selectByExample(example);
        return list;
    }

    @CacheEvict(value = CACHE_KEY, allEntries = true)
    @Override
    public int updateNotNull(SysOrganization entity) {
        return super.updateNotNull(entity);
    }

    @CacheEvict(value = CACHE_KEY, allEntries = true)
    @Override
    public int saveNotNull(SysOrganization entity) {
        return super.saveNotNull(entity);
    }

    @CacheEvict(value = CACHE_KEY, allEntries = true)
    @Override
    public int delete(Object key) {
        return super.delete(key);
    }
}
