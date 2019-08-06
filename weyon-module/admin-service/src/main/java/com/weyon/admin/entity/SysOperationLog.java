package com.weyon.admin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author liuxu
 * @description 系统日志实体类
 * @date 2019-05-21
 **/
@Table(name = "tb_sys_operation_log")
public class SysOperationLog implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 日志类型 系统日志 1 其他日志 2
     */
    @Column(name = "LOG_TYPE")
    private Integer logType;

    /**
     * 日志名称
     */
    @Column(name = "OPERATION")
    private String operation;

    /**
     * 执行时间
     */
    @Column(name = "TIME")
    private Long time;

    /**
     * 方法名称
     */
    @Column(name = "METHOD")
    private String method;

    /**
     * 请求ip
     */
    @Column(name = "IP")
    private String ip;

    /**
     * 是否成功
     */
    @Column(name = "SUCCESS")
    private String success;

    /**
     * 创建者id
     */
    @Column(name = "CREATOR_ID")
    private String creatorId;

    /**
     * 操作人
     */
    @Column(name = "CREATOR")
    private String creator;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;

    /**
     * 类名
     */
    @Column(name = "CLASSNAME")
    private String className;

    /**
     * 请求参数
     */
    @Column(name = "PARAMS")
    private String params;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return ID - 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取日志类型 系统日志 1 其他日志 2
     *
     * @return LOG_TYPE - 日志类型 系统日志 1 其他日志 2
     */
    public Integer getLogType() {
        return logType;
    }

    /**
     * 设置日志类型 系统日志 1 其他日志 2
     *
     * @param logType 日志类型 系统日志 1 其他日志 2
     */
    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    /**
     * 获取日志名称
     *
     * @return OPERATION - 日志名称
     */
    public String getOperation() {
        return operation;
    }

    /**
     * 设置日志名称
     *
     * @param operation 日志名称
     */
    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    /**
     * 获取执行时间
     *
     * @return TIME - 执行时间
     */
    public Long getTime() {
        return time;
    }

    /**
     * 设置执行时间
     *
     * @param time 执行时间
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * 获取方法名称
     *
     * @return METHOD - 方法名称
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置方法名称
     *
     * @param method 方法名称
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * 获取请求ip
     *
     * @return IP - 请求ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置请求ip
     *
     * @param ip 请求ip
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 获取是否成功
     *
     * @return SUCCESS - 是否成功
     */
    public String getSuccess() {
        return success;
    }

    /**
     * 设置是否成功
     *
     * @param success 是否成功
     */
    public void setSuccess(String success) {
        this.success = success == null ? null : success.trim();
    }

    /**
     * 获取创建者id
     *
     * @return CREATOR_ID - 创建者id
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建者id
     *
     * @param creatorId 创建者id
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    /**
     * 获取操作人
     *
     * @return CREATOR - 操作人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置操作人
     *
     * @param creator 操作人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_DATE - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取类名
     *
     * @return CLASSNAME - 类名
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置类名
     *
     * @param className 类名
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**
     * 获取请求参数
     *
     * @return PARAMS - 请求参数
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置请求参数
     *
     * @param params 请求参数
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }
}