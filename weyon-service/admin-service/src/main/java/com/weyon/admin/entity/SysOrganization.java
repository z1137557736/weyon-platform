package com.weyon.admin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liuxu
 * @description 组织机构实体类
 * @date 2019-05-21
 **/
@Table(name = "tb_sys_organization")
public class SysOrganization implements Serializable {
    /**
     * 组织机构自动ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 父组织ID
     */
    @Column(name = "PID")
    private String pid;

    /**
     * 父组织名称
     */
    @Column(name = "PNAME")
    private String pname;

    /**
     * 组织名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 院校代码
     */
    @Column(name = "YXDM")
    private String yxdm;

    /**
     * 机构类型
     */
    @Column(name = "ORG_TYPE")
    private Byte orgType;

    /**
     * 机构地址：真实地址
     */
    @Column(name = "ORG_ADDR")
    private String orgAddr;

    /**
     * 图标
     */
    @Column(name = "ICON")
    private String icon;

    /**
     * 排序置顶
     */
    @Column(name = "SORT")
    private Integer sort;

    /**
     * 电话
     */
    @Column(name = "TELEPHONE")
    private String telephone;

    /**
     * 逻辑删除:0-删除 1-正常
     */
    @Column(name = "RECORD_STATUS")
    private Boolean recordStatus;

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
     * 记录备注
     */
    @Column(name = "REMARK")
    private String remark;

    private static final long serialVersionUID = 1L;

    private List<SysOrganization> children;

    /**
     * 获取组织机构自动ID
     *
     * @return ID - 组织机构自动ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置组织机构自动ID
     *
     * @param id 组织机构自动ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取父组织ID
     *
     * @return PID - 父组织ID
     */
    public String getPid() {
        return pid;
    }

    /**
     * 设置父组织ID
     *
     * @param pid 父组织ID
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
     * 获取组织名称
     *
     * @return NAME - 组织名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置组织名称
     *
     * @param name 组织名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getYxdm() {
        return yxdm;
    }

    public void setYxdm(String yxdm) {
        this.yxdm = yxdm;
    }

    /**
     * 获取机构类型
     *
     * @return ORG_TYPE - 机构类型
     */
    public Byte getOrgType() {
        return orgType;
    }

    /**
     * 设置机构类型
     *
     * @param orgType 机构类型
     */
    public void setOrgType(Byte orgType) {
        this.orgType = orgType;
    }

    /**
     * 获取机构地址：真实地址
     *
     * @return ORG_ADDR - 机构地址：真实地址
     */
    public String getOrgAddr() {
        return orgAddr;
    }

    /**
     * 设置机构地址：真实地址
     *
     * @param orgAddr 机构地址：真实地址
     */
    public void setOrgAddr(String orgAddr) {
        this.orgAddr = orgAddr == null ? null : orgAddr.trim();
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
     * 获取排序置顶
     *
     * @return SORT - 排序置顶
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序置顶
     *
     * @param sort 排序置顶
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取电话
     *
     * @return TELEPHONE - 电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置电话
     *
     * @param telephone 电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 获取逻辑删除:0-删除 1-正常
     *
     * @return RECORD_STATUS - 逻辑删除:0-删除 1-正常
     */
    public Boolean getRecordStatus() {
        return recordStatus;
    }

    /**
     * 设置逻辑删除:0-删除 1-正常
     *
     * @param recordStatus 逻辑删除:0-删除 1-正常
     */
    public void setRecordStatus(Boolean recordStatus) {
        this.recordStatus = recordStatus;
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
     * 获取记录备注
     *
     * @return REMARK - 记录备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置记录备注
     *
     * @param remark 记录备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public List<SysOrganization> getChildren() {
        return children;
    }

    public void setChildren(List<SysOrganization> children) {
        this.children = children;
    }
}