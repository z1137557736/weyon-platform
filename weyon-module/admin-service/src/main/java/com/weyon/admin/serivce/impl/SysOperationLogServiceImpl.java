package com.weyon.admin.serivce.impl;

import com.weyon.admin.dao.SysOperationLogMapper;
import com.weyon.admin.entity.SysOperationLog;
import com.weyon.admin.serivce.SysOperationLogService;
import com.weyon.common.model.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuxu
 * @description 系统日志接口实现类
 * @date 2019-05-21
 **/
@Service
public class SysOperationLogServiceImpl extends BaseService<SysOperationLog> implements SysOperationLogService {

    @Autowired
    private SysOperationLogMapper operationLogMapper;
}
