package com.weyon.admin.serivce;

import com.weyon.admin.entity.SysPermission;
import com.weyon.common.model.IService;

import java.util.List;

/**
 * @author liuxu
 * @description 系统权限接口类
 * @date 2019-05-20
 **/
public interface SysPermissionService extends IService<SysPermission> {

    /**
     * 根据用户编号获取权限
     * @param userId 用户编号
     * @return
     */
    List<SysPermission> findByUserId(String userId);
}
