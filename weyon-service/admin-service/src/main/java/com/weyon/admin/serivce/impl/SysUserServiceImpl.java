package com.weyon.admin.serivce.impl;

import com.weyon.admin.dao.SysUserMapper;
import com.weyon.admin.entity.SysUser;
import com.weyon.admin.serivce.SysUserService;
import com.weyon.common.model.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuxu
 * @description 用户接口实现类
 * @date 2019-05-15
 **/
@Service
public class SysUserServiceImpl extends BaseService<SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    //@Cacheable(value = "userCache", key = "#p0", unless = "#result == null")
    @Override
    public SysUser selectByUsername(String username) {
        return sysUserMapper.selectByUsername(username);
    }

    @Override
    public List<String> selectRoleByUserId(String userId) {
        return sysUserMapper.selectRoleByUserId(userId);
    }

    @Override
    public List<String> selectRoleCodeByUserId(String userId) {
        return sysUserMapper.selectRoleCodeByUserId(userId);
    }

    @Override
    public int saveUserRole(String userId, String[] roles) {
        sysUserMapper.deleteUserRoleByUserId(userId);
        if(roles != null && roles.length > 0) {
            return sysUserMapper.saveUserRole(userId, roles);
        }
        return 0;
    }
}
