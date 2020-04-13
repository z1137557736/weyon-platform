package com.weyon.admin.serivce;

import com.weyon.admin.entity.SysUser;
import com.weyon.common.model.IService;

import java.util.List;

/**
 * @author liuxu
 * @description 基础用户接口类
 * @date 2019-05-15
 **/
public interface SysUserService extends IService<SysUser> {

    /**
     * 根据username查找用户
     * @param username 用户名
     * @return
     */
    SysUser selectByUsername(String username);

    /**
     * 获取角色列表树
     * @param userId
     * @return
     */
    List<String> selectRoleByUserId(String userId);

    /**
     * 根据用户id查询角色代码
     * @param userId
     * @return
     */
    List<String> selectRoleCodeByUserId(String userId);

    /**
     * 添加用户权限树
     * @param userId
     * @param roles
     * @return
     */
    int saveUserRole(String userId, String[] roles);
}
