package com.weyon.admin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author liuxu
 * @description 基础用户实体类
 * @date 2019-05-21
 **/
@Table(name = "tb_sys_user")
public class SysUser implements Serializable {
    /**
     * 用户主键ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 用户自编码
     */
    @Column(name = "SELF_ID")
    private String selfId;

    /**
     * 登录用户名
     */
    @Column(name = "USERNAME")
    private String username;

    /**
     * 登录密码，32位的MD5值
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 盐:如果使用HMAC算法，则结合XX_RANDOM一起使用
     */
    @Column(name = "SALT")
    private String salt;

    /**
     * 登录类型：0-Web登录 1-手机登录 2-pc登录
     */
    @Column(name = "LOGIN_TYPE")
    private Integer loginType;

    /**
     * 移动端唯一标识码，作踢出时使用
     */
    @Column(name = "UNIQUE_TOKEN")
    private String uniqueToken;

    /**
     * 真实姓名
     */
    @Column(name = "REAL_NAME")
    private String realName;

    /**
     * 昵称
     */
    @Column(name = "NICK_NAME")
    private String nickName;

    /**
     * 性别：F-女 M-男 N-未知
     */
    @Column(name = "GENDER")
    private String gender;

    /**
     * 出生日期
     */
    @Column(name = "BIRTHDAY")
    private Date birthday;

    /**
     * 手机号码
     */
    @Column(name = "MOBILE")
    private String mobile;

    /**
     * 固定电话
     */
    @Column(name = "TELEPHONE")
    private String telephone;

    /**
     * 电子邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * QQ号码
     */
    @Column(name = "QQ")
    private String qq;

    /**
     * 微信号码
     */
    @Column(name = "WECHAT")
    private String wechat;

    /**
     * 冗余身份证号码
     */
    @Column(name = "IDENTITY_CARD")
    private String identityCard;

    /**
     * 用户类型
     */
    @Column(name = "USER_TYPE")
    private Byte userType;

    /**
     * 微信编号
     */
    @Column(name = "OPEN_ID")
    private String openId;

    /**
     * 头像地址
     */
    @Column(name = "HEAD_URL")
    private String headUrl;

    /**
     * 是否锁定：0-解锁 1-锁定
     */
    @Column(name = "LOCKED")
    private String locked;

    /**
     * 组织机构Id
     */
    @Column(name = "ORGANIZATION_ID")
    private String organizationId;

    /**
     * 访问的IP地址
     */
    @Column(name = "LOGIN_IP")
    private String loginIp;

    /**
     * 登录时间
     */
    @Column(name = "LOGIN_TIME")
    private Date loginTime;

    /**
     * 逻辑删除:0-删除 1-正常
     */
    @Column(name = "RECORD_STATUS")
    private Byte recordStatus;

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
     * 获取用户主键ID
     *
     * @return ID - 用户主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置用户主键ID
     *
     * @param id 用户主键ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取用户自编码
     *
     * @return SELF_ID - 用户自编码
     */
    public String getSelfId() {
        return selfId;
    }

    /**
     * 设置用户自编码
     *
     * @param selfId 用户自编码
     */
    public void setSelfId(String selfId) {
        this.selfId = selfId == null ? null : selfId.trim();
    }

    /**
     * 获取登录用户名
     *
     * @return USERNAME - 登录用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置登录用户名
     *
     * @param username 登录用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取登录密码，32位的MD5值
     *
     * @return PASSWORD - 登录密码，32位的MD5值
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码，32位的MD5值
     *
     * @param password 登录密码，32位的MD5值
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取盐:如果使用HMAC算法，则结合XX_RANDOM一起使用
     *
     * @return SALT - 盐:如果使用HMAC算法，则结合XX_RANDOM一起使用
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐:如果使用HMAC算法，则结合XX_RANDOM一起使用
     *
     * @param salt 盐:如果使用HMAC算法，则结合XX_RANDOM一起使用
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 获取登录类型：0-Web登录 1-手机登录 2-pc登录
     *
     * @return LOGIN_TYPE - 登录类型：0-Web登录 1-手机登录 2-pc登录
     */
    public Integer getLoginType() {
        return loginType;
    }

    /**
     * 设置登录类型：0-Web登录 1-手机登录 2-pc登录
     *
     * @param loginType 登录类型：0-Web登录 1-手机登录 2-pc登录
     */
    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    /**
     * 获取移动端唯一标识码，作踢出时使用
     *
     * @return UNIQUE_TOKEN - 移动端唯一标识码，作踢出时使用
     */
    public String getUniqueToken() {
        return uniqueToken;
    }

    /**
     * 设置移动端唯一标识码，作踢出时使用
     *
     * @param uniqueToken 移动端唯一标识码，作踢出时使用
     */
    public void setUniqueToken(String uniqueToken) {
        this.uniqueToken = uniqueToken == null ? null : uniqueToken.trim();
    }

    /**
     * 获取真实姓名
     *
     * @return REAL_NAME - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取昵称
     *
     * @return NICK_NAME - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取性别：F-女 M-男 N-未知
     *
     * @return GENDER - 性别：F-女 M-男 N-未知
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别：F-女 M-男 N-未知
     *
     * @param gender 性别：F-女 M-男 N-未知
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * 获取出生日期
     *
     * @return BIRTHDAY - 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置出生日期
     *
     * @param birthday 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取手机号码
     *
     * @return MOBILE - 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号码
     *
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取固定电话
     *
     * @return TELEPHONE - 固定电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置固定电话
     *
     * @param telephone 固定电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 获取电子邮箱
     *
     * @return EMAIL - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取QQ号码
     *
     * @return QQ - QQ号码
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置QQ号码
     *
     * @param qq QQ号码
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * 获取微信号码
     *
     * @return WECHAT - 微信号码
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * 设置微信号码
     *
     * @param wechat 微信号码
     */
    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    /**
     * 获取冗余身份证号码
     *
     * @return IDENTITY_CARD - 冗余身份证号码
     */
    public String getIdentityCard() {
        return identityCard;
    }

    /**
     * 设置冗余身份证号码
     *
     * @param identityCard 冗余身份证号码
     */
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard == null ? null : identityCard.trim();
    }

    /**
     * 获取用户类型
     *
     * @return USER_TYPE - 用户类型
     */
    public Byte getUserType() {
        return userType;
    }

    /**
     * 设置用户类型
     *
     * @param userType 用户类型
     */
    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    /**
     * 获取微信编号
     *
     * @return OPEN_ID - 微信编号
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置微信编号
     *
     * @param openId 微信编号
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * 获取头像地址
     *
     * @return HEAD_URL - 头像地址
     */
    public String getHeadUrl() {
        return headUrl;
    }

    /**
     * 设置头像地址
     *
     * @param headUrl 头像地址
     */
    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }

    /**
     * 获取是否锁定：0-解锁 1-锁定
     *
     * @return LOCKED - 是否锁定：0-解锁 1-锁定
     */
    public String getLocked() {
        return locked;
    }

    /**
     * 设置是否锁定：0-解锁 1-锁定
     *
     * @param locked 是否锁定：0-解锁 1-锁定
     */
    public void setLocked(String locked) {
        this.locked = locked == null ? null : locked.trim();
    }

    /**
     * 获取组织机构Id
     *
     * @return ORGANIZATION_ID - 组织机构Id
     */
    public String getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置组织机构Id
     *
     * @param organizationId 组织机构Id
     */
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 获取访问的IP地址
     *
     * @return LOGIN_IP - 访问的IP地址
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 设置访问的IP地址
     *
     * @param loginIp 访问的IP地址
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * 获取登录时间
     *
     * @return LOGIN_TIME - 登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置登录时间
     *
     * @param loginTime 登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取逻辑删除:0-删除 1-正常
     *
     * @return RECORD_STATUS - 逻辑删除:0-删除 1-正常
     */
    public Byte getRecordStatus() {
        return recordStatus;
    }

    /**
     * 设置逻辑删除:0-删除 1-正常
     *
     * @param recordStatus 逻辑删除:0-删除 1-正常
     */
    public void setRecordStatus(Byte recordStatus) {
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
}