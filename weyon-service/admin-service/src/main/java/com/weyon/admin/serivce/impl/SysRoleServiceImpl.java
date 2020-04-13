package com.weyon.admin.serivce.impl;

import com.weyon.admin.dao.SysRoleMapper;
import com.weyon.admin.entity.SysRole;
import com.weyon.admin.serivce.SysRoleService;
import com.weyon.common.model.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuxu
 * @description 系统角色接口实现类
 * @date 2019-05-21
 **/
@Service
public class SysRoleServiceImpl extends BaseService<SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public List<String> selectPermByRoleId(String roleId) {
        return roleMapper.selectPermByRoleId(roleId);
    }

    @Override
    public int saveRolePerm(String roleId, String[] perms) {
        roleMapper.deleteUserRoleByRoleId(roleId);
        if(perms != null && perms.length > 0) {
            return roleMapper.saveRolePerm(roleId, perms);
        }
        return 0;
    }
}
