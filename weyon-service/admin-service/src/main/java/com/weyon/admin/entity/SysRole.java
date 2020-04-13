package com.weyon.admin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author liuxu
 * @description 系统角色实体类
 * @date 2019-05-21
 **/
@Table(name = "tb_sys_role")
public class SysRole implements Serializable {
    /**
     * 角色ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 角色名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 角色代码
     */
    @Column(name = "ROLE_CODE")
    private String roleCode;

    /**
     * 角色描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 优先置顶
     */
    @Column(name = "SORT")
    private Integer sort;

    /**
     * 创建者id
     */
    @Column(name = "CREATOR_ID")
    private String creatorId;

    /**
     * 创建者
     */
    @Column(name = "CREATOR")
    private String creator;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    private static final long serialVersionUID = 1L;

    /**
     * 获取角色ID
     *
     * @return ID - 角色ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置角色ID
     *
     * @param id 角色ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取角色名称
     *
     * @return NAME - 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取角色描述
     *
     * @return DESCRIPTION - 角色描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置角色描述
     *
     * @param description 角色描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取优先置顶
     *
     * @return SORT - 优先置顶
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置优先置顶
     *
     * @param sort 优先置顶
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取创建者id
     *
     * @return CREATER_ID - 创建者id
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
        this.creatorId = creatorId;
    }

    /**
     * 获取创建者
     *
     * @return CREATER - 创建者
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建者
     *
     * @param creator 创建者
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
     * 获取更新时间
     *
     * @return UPDATE_DATE - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}