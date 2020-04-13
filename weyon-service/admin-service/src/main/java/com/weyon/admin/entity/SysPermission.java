package com.weyon.admin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liuxu
 * @description 系统权限实体类
 * @date 2019-05-21
 **/
@Table(name = "tb_sys_permission")
public class SysPermission implements Serializable {
    /**
     * 权限代码
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 父级权限ID
     */
    @Column(name = "PID")
    private String pid;

    /**
     * 父组织名称
     */
    @Column(name = "PNAME")
    private String pname;

    /**
     * 权限名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 图标
     */
    @Column(name = "ICON")
    private String icon;

    /**
     * 链接地址
     */
    @Column(name = "PATH")
    private String path;

    /**
     * 类型 1:菜单,2:操作
     */
    @Column(name = "PERMISSION_TYPE")
    private Byte permissionType;

    @Column(name = "PERMISSION")
    private String permission;

    /**
     * 优先置顶排序
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

    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;

    private static final long serialVersionUID = 1L;

    private List<SysPermission> children;

    /**
     * 获取权限代码
     *
     * @return ID - 权限代码
     */
    public String getId() {
        return id;
    }

    /**
     * 设置权限代码
     *
     * @param id 权限代码
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取父级权限ID
     *
     * @return PID - 父级权限ID
     */
    public String getPid() {
        return pid;
    }

    /**
     * 设置父级权限ID
     *
     * @param pid 父级权限ID
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * 获取父组织名称
     *
     * @return PNAME - 父组织名称
     */
    public String getPname() {
        return pname;
    }

    /**
     * 设置父组织名称
     *
     * @param pname 父组织名称
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * 获取权限名称
     *
     * @return NAME - 权限名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置权限名称
     *
     * @param name 权限名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取图标
     *
     * @return ICON - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取链接地址
     *
     * @return PATH - 链接地址
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置链接地址
     *
     * @param path 链接地址
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 获取类型 1:菜单,2:操作
     *
     * @return PERMISSION_TYPE - 类型 1:菜单,2:操作
     */
    public Byte getPermissionType() {
        return permissionType;
    }

    /**
     * 设置类型 1:菜单,2:操作
     *
     * @param permissionType 类型 1:菜单,2:操作
     */
    public void setPermissionType(Byte permissionType) {
        this.permissionType = permissionType;
    }

    /**
     * @return PERMISSION
     */
    public String getPermission() {
        return permission;
    }

    /**
     * @param permission
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * 获取优先置顶排序
     *
     * @return SORT - 优先置顶排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置优先置顶排序
     *
     * @param sort 优先置顶排序
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

    /**
     * 获取备注
     *
     * @return REMARK - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public List<SysPermission> getChildren() {
        return children;
    }

    public void setChildren(List<SysPermission> children) {
        this.children = children;
    }
}