package com.weyon.admin.serivce;

import com.weyon.admin.entity.SysRole;
import com.weyon.common.model.IService;

import java.util.List;

/**
 * @author liuxu
 * @description 系统角色接口类
 * @date 2019-05-21
 **/
public interface SysRoleService extends IService<SysRole> {

    /**
     * 获取权限列表
     * @param roleId
     * @return
     */
    List<String> selectPermByRoleId(String roleId);

    /**
     * 添加权限列表树
     * @param roleId
     * @param perms
     * @return
     */
    int saveRolePerm(String roleId, String[] perms);
}
