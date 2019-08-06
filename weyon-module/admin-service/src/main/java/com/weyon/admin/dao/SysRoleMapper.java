package com.weyon.admin.dao;

import com.weyon.admin.entity.SysRole;
import com.weyon.common.model.BaseMapper;

import java.util.List;

/**
 * @author liuxu
 * @description 系统角色dao类
 * @date 2019-05-15
 **/
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<String> selectPermByRoleId(String roleId);

    int deleteUserRoleByRoleId(String roleId);

    int saveRolePerm(String roleId, String[] perms);
}