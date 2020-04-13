package com.weyon.admin.dao;

import com.weyon.admin.entity.SysPermission;
import com.weyon.common.model.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuxu
 * @description 系统权限dao类
 * @date 2019-05-15
 **/
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    List<SysPermission> findByUserId(@Param("userId") String userId);

}