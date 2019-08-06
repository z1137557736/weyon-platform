package com.weyon.admin.dao;

import com.weyon.admin.entity.SysUser;
import com.weyon.common.model.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuxu
 * @description 基础用户dao类
 * @date 2019-05-15
 **/
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectByUsername(String username);

    List<String> selectRoleByUserId(String userId);

    List<String> selectRoleCodeByUserId(@Param("userId") String userId);

    int deleteUserRoleByUserId(String userId);

    int saveUserRole(String userId, String[] roles);
}