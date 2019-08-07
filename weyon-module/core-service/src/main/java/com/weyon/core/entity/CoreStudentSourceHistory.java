package com.weyon.core.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_core_student_source_history")
public class CoreStudentSourceHistory implements Serializable {
    /**
     * 学生id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 是否绑定微信 0未绑定 1已绑定 2申请解绑
     */
    @Column(name = "BIND_WECHAT")
    private Byte bindWechat;

    /**
     * 微信公众号唯一标识
     */
    @Column(name = "OPEN_ID")
    private String openId;

    /**
     * 学校ID
     */
    @Column(name = "SCHOOL_ID")
    private Integer schoolId;

    /**
     * 毕业年份
     */
    @Column(name = "GRADUATE_YEAR")
    private Short graduateYear;

    /**
     * 生源业务主键
     */
    @Column(name = "STUDENT_KEY")
    private String studentKey;

    /**
     * 姓名
     */
    @Column(name = "XM")
    private String xm;

    /**
     * 性别
     */
    @Column(name = "XB")
    private String xb;

    /**
     * 性别代码
     */
    @Column(name = "XBDM")
    private String xbdm;

    /**
     * 身份证号
     */
    @Column(name = "SFZH")
    private String sfzh;

    /**
     * 民族
     */
    @Column(name = "MZ")
    private String mz;

    /**
     * 民族代码
     */
    @Column(name = "MZDM")
    private String mzdm;

    /**
     * 生源所在地代码
     */
    @Column(name = "SYSZDDM")
    private String syszddm;

    /**
     * 生源所在地
     */
    @Column(name = "SYSZD")
    private String syszd;

    /**
     * 手机号码
     */
    @Column(name = "MOBILEPHONE")
    private String mobilephone;

    /**
     * QQ号码
     */
    @Column(name = "QQ")
    private String qq;

    /**
     * 电子邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 家庭地址
     */
    @Column(name = "JTDZ")
    private String jtdz;

    /**
     * 家庭电话
     */
    @Column(name = "JTDH")
    private String jtdh;

    /**
     * 家庭邮编
     */
    @Column(name = "JTYB")
    private String jtyb;

    /**
     * 考生号
     */
    @Column(name = "KSH")
    private String ksh;

    /**
     * 考生类别代码
     */
    @Column(name = "KSLBDM")
    private String kslbdm;

    /**
     * 考生类别
     */
    @Column(name = "KSLB")
    private String kslb;

    /**
     * 院校代码
     */
    @Column(name = "YXDM")
    private String yxdm;

    /**
     * 院校名称
     */
    @Column(name = "YXMC")
    private String yxmc;

    /**
     * 学历代码
     */
    @Column(name = "XLDM")
    private String xldm;

    /**
     * 学历
     */
    @Column(name = "XL")
    private String xl;

    /**
     * 学制
     */
    @Column(name = "XZ")
    private String xz;

    /**
     * 所在院系
     */
    @Column(name = "SZYX")
    private String szyx;

    /**
     * 专业代码
     */
    @Column(name = "ZYDM")
    private String zydm;

    /**
     * 专业
     */
    @Column(name = "ZY")
    private String zy;

    /**
     * 专业方向
     */
    @Column(name = "ZYFX")
    private String zyfx;

    /**
     * 所在班级
     */
    @Column(name = "SZBJ")
    private String szbj;

    /**
     * 学号
     */
    @Column(name = "XH")
    private String xh;

    /**
     * 入学时间
     */
    @Column(name = "RXSJ")
    private String rxsj;

    /**
     * 毕业时间
     */
    @Column(name = "BYSJ")
    private String bysj;

    /**
     * 困难生类别代码
     */
    @Column(name = "KNSLBDM")
    private String knslbdm;

    /**
     * 困难生类别
     */
    @Column(name = "KNSLB")
    private String knslb;

    /**
     * 师范生类别代码
     */
    @Column(name = "SFSLBDM")
    private String sfslbdm;

    /**
     * 师范生类别
     */
    @Column(name = "SFSLB")
    private String sfslb;

    /**
     * 培养方式代码
     */
    @Column(name = "PYFSDM")
    private String pyfsdm;

    /**
     * 培养方式
     */
    @Column(name = "PYFS")
    private String pyfs;

    /**
     * 主修外语代码（湖南）
     */
    @Column(name = "ZXWYDM")
    private String zxwydm;

    /**
     * 主修外语（湖南）
     */
    @Column(name = "ZXWY")
    private String zxwy;

    /**
     * 档案是否转入学校
     */
    @Column(name = "DASFZRXX")
    private Byte dasfzrxx;

    /**
     * 户口是否转入学校
     */
    @Column(name = "HKSFZRXX")
    private Byte hksfzrxx;

    /**
     * 入学前档案所在单位
     */
    @Column(name = "RXQDASZDW")
    private String rxqdaszdw;

    /**
     * 入学前户口所在地派出所
     */
    @Column(name = "RXQHKSZDPCS")
    private String rxqhkszdpcs;

    /**
     * 定向或委培单位（预留）
     */
    @Column(name = "DXHWPDW")
    private String dxhwpdw;

    /**
     * 城乡生源（预留）
     */
    @Column(name = "CXSY")
    private String cxsy;

    /**
     * 审核状态 1待审核 2审核通过 3审核不通过
     */
    @Column(name = "AUDIT_STATUS")
    private Byte auditStatus;

    /**
     * 审核内容说明
     */
    @Column(name = "AUDIT_CONTENT")
    private String auditContent;

    /**
     * 审核时间
     */
    @Column(name = "AUDIT_DATE")
    private Date auditDate;

    /**
     * 审核人id
     */
    @Column(name = "AUDITOR_ID")
    private String auditorId;

    /**
     * 解绑图片地址
     */
    @Column(name = "UNBIND_IMG_URL")
    private String unbindImgUrl;

    /**
     * 解绑原因
     */
    @Column(name = "UNBIND_CONTENT")
    private String unbindContent;

    /**
     * 扩展字段1
     */
    @Column(name = "KZZD1")
    private String kzzd1;

    /**
     * 扩展字段2
     */
    @Column(name = "KZZD2")
    private String kzzd2;

    /**
     * 扩展字段3
     */
    @Column(name = "KZZD3")
    private String kzzd3;

    /**
     * 扩展字段4
     */
    @Column(name = "KZZD4")
    private String kzzd4;

    /**
     * 扩展字段5
     */
    @Column(name = "KZZD5")
    private String kzzd5;

    /**
     * 扩展字段6
     */
    @Column(name = "KZZD6")
    private String kzzd6;

    /**
     * 扩展字段7
     */
    @Column(name = "KZZD7")
    private String kzzd7;

    /**
     * 扩展字段8
     */
    @Column(name = "KZZD8")
    private String kzzd8;

    /**
     * 手机号是否核验
     */
    @Column(name = "CHECK_PHONE_UPDATE")
    private Byte checkPhoneUpdate;

    /**
     * 核验是否改动 0 未核验 1 核验未改动 2 核验申请改动
     */
    @Column(name = "CHECK_UPDATE")
    private Byte checkUpdate;

    /**
     * 核验时间
     */
    @Column(name = "CHECK_DATE")
    private Date checkDate;

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
     * 获取学生id
     *
     * @return ID - 学生id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置学生id
     *
     * @param id 学生id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取是否绑定微信 0未绑定 1已绑定 2申请解绑
     *
     * @return BIND_WECHAT - 是否绑定微信 0未绑定 1已绑定 2申请解绑
     */
    public Byte getBindWechat() {
        return bindWechat;
    }

    /**
     * 设置是否绑定微信 0未绑定 1已绑定 2申请解绑
     *
     * @param bindWechat 是否绑定微信 0未绑定 1已绑定 2申请解绑
     */
    public void setBindWechat(Byte bindWechat) {
        this.bindWechat = bindWechat;
    }

    /**
     * 获取微信公众号唯一标识
     *
     * @return OPEN_ID - 微信公众号唯一标识
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置微信公众号唯一标识
     *
     * @param openId 微信公众号唯一标识
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * 获取学校ID
     *
     * @return SCHOOL_ID - 学校ID
     */
    public Integer getSchoolId() {
        return schoolId;
    }

    /**
     * 设置学校ID
     *
     * @param schoolId 学校ID
     */
    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * 获取毕业年份
     *
     * @return GRADUATE_YEAR - 毕业年份
     */
    public Short getGraduateYear() {
        return graduateYear;
    }

    /**
     * 设置毕业年份
     *
     * @param graduateYear 毕业年份
     */
    public void setGraduateYear(Short graduateYear) {
        this.graduateYear = graduateYear;
    }

    /**
     * 获取生源业务主键
     *
     * @return STUDENT_KEY - 生源业务主键
     */
    public String getStudentKey() {
        return studentKey;
    }

    /**
     * 设置生源业务主键
     *
     * @param studentKey 生源业务主键
     */
    public void setStudentKey(String studentKey) {
        this.studentKey = studentKey == null ? null : studentKey.trim();
    }

    /**
     * 获取姓名
     *
     * @return XM - 姓名
     */
    public String getXm() {
        return xm;
    }

    /**
     * 设置姓名
     *
     * @param xm 姓名
     */
    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    /**
     * 获取性别
     *
     * @return XB - 性别
     */
    public String getXb() {
        return xb;
    }

    /**
     * 设置性别
     *
     * @param xb 性别
     */
    public void setXb(String xb) {
        this.xb = xb == null ? null : xb.trim();
    }

    /**
     * 获取性别代码
     *
     * @return XBDM - 性别代码
     */
    public String getXbdm() {
        return xbdm;
    }

    /**
     * 设置性别代码
     *
     * @param xbdm 性别代码
     */
    public void setXbdm(String xbdm) {
        this.xbdm = xbdm == null ? null : xbdm.trim();
    }

    /**
     * 获取身份证号
     *
     * @return SFZH - 身份证号
     */
    public String getSfzh() {
        return sfzh;
    }

    /**
     * 设置身份证号
     *
     * @param sfzh 身份证号
     */
    public void setSfzh(String sfzh) {
        this.sfzh = sfzh == null ? null : sfzh.trim();
    }

    /**
     * 获取民族
     *
     * @return MZ - 民族
     */
    public String getMz() {
        return mz;
    }

    /**
     * 设置民族
     *
     * @param mz 民族
     */
    public void setMz(String mz) {
        this.mz = mz == null ? null : mz.trim();
    }

    /**
     * 获取民族代码
     *
     * @return MZDM - 民族代码
     */
    public String getMzdm() {
        return mzdm;
    }

    /**
     * 设置民族代码
     *
     * @param mzdm 民族代码
     */
    public void setMzdm(String mzdm) {
        this.mzdm = mzdm == null ? null : mzdm.trim();
    }

    /**
     * 获取生源所在地代码
     *
     * @return SYSZDDM - 生源所在地代码
     */
    public String getSyszddm() {
        return syszddm;
    }

    /**
     * 设置生源所在地代码
     *
     * @param syszddm 生源所在地代码
     */
    public void setSyszddm(String syszddm) {
        this.syszddm = syszddm == null ? null : syszddm.trim();
    }

    /**
     * 获取生源所在地
     *
     * @return SYSZD - 生源所在地
     */
    public String getSyszd() {
        return syszd;
    }

    /**
     * 设置生源所在地
     *
     * @param syszd 生源所在地
     */
    public void setSyszd(String syszd) {
        this.syszd = syszd == null ? null : syszd.trim();
    }

    /**
     * 获取手机号码
     *
     * @return MOBILEPHONE - 手机号码
     */
    public String getMobilephone() {
        return mobilephone;
    }

    /**
     * 设置手机号码
     *
     * @param mobilephone 手机号码
     */
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
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
     * 获取家庭地址
     *
     * @return JTDZ - 家庭地址
     */
    public String getJtdz() {
        return jtdz;
    }

    /**
     * 设置家庭地址
     *
     * @param jtdz 家庭地址
     */
    public void setJtdz(String jtdz) {
        this.jtdz = jtdz == null ? null : jtdz.trim();
    }

    /**
     * 获取家庭电话
     *
     * @return JTDH - 家庭电话
     */
    public String getJtdh() {
        return jtdh;
    }

    /**
     * 设置家庭电话
     *
     * @param jtdh 家庭电话
     */
    public void setJtdh(String jtdh) {
        this.jtdh = jtdh == null ? null : jtdh.trim();
    }

    /**
     * 获取家庭邮编
     *
     * @return JTYB - 家庭邮编
     */
    public String getJtyb() {
        return jtyb;
    }

    /**
     * 设置家庭邮编
     *
     * @param jtyb 家庭邮编
     */
    public void setJtyb(String jtyb) {
        this.jtyb = jtyb == null ? null : jtyb.trim();
    }

    /**
     * 获取考生号
     *
     * @return KSH - 考生号
     */
    public String getKsh() {
        return ksh;
    }

    /**
     * 设置考生号
     *
     * @param ksh 考生号
     */
    public void setKsh(String ksh) {
        this.ksh = ksh == null ? null : ksh.trim();
    }

    /**
     * 获取考生类别代码
     *
     * @return KSLBDM - 考生类别代码
     */
    public String getKslbdm() {
        return kslbdm;
    }

    /**
     * 设置考生类别代码
     *
     * @param kslbdm 考生类别代码
     */
    public void setKslbdm(String kslbdm) {
        this.kslbdm = kslbdm == null ? null : kslbdm.trim();
    }

    /**
     * 获取考生类别
     *
     * @return KSLB - 考生类别
     */
    public String getKslb() {
        return kslb;
    }

    /**
     * 设置考生类别
     *
     * @param kslb 考生类别
     */
    public void setKslb(String kslb) {
        this.kslb = kslb == null ? null : kslb.trim();
    }

    /**
     * 获取院校代码
     *
     * @return YXDM - 院校代码
     */
    public String getYxdm() {
        return yxdm;
    }

    /**
     * 设置院校代码
     *
     * @param yxdm 院校代码
     */
    public void setYxdm(String yxdm) {
        this.yxdm = yxdm == null ? null : yxdm.trim();
    }

    /**
     * 获取院校名称
     *
     * @return YXMC - 院校名称
     */
    public String getYxmc() {
        return yxmc;
    }

    /**
     * 设置院校名称
     *
     * @param yxmc 院校名称
     */
    public void setYxmc(String yxmc) {
        this.yxmc = yxmc == null ? null : yxmc.trim();
    }

    /**
     * 获取学历代码
     *
     * @return XLDM - 学历代码
     */
    public String getXldm() {
        return xldm;
    }

    /**
     * 设置学历代码
     *
     * @param xldm 学历代码
     */
    public void setXldm(String xldm) {
        this.xldm = xldm == null ? null : xldm.trim();
    }

    /**
     * 获取学历
     *
     * @return XL - 学历
     */
    public String getXl() {
        return xl;
    }

    /**
     * 设置学历
     *
     * @param xl 学历
     */
    public void setXl(String xl) {
        this.xl = xl == null ? null : xl.trim();
    }

    /**
     * 获取学制
     *
     * @return XZ - 学制
     */
    public String getXz() {
        return xz;
    }

    /**
     * 设置学制
     *
     * @param xz 学制
     */
    public void setXz(String xz) {
        this.xz = xz == null ? null : xz.trim();
    }

    /**
     * 获取所在院系
     *
     * @return SZYX - 所在院系
     */
    public String getSzyx() {
        return szyx;
    }

    /**
     * 设置所在院系
     *
     * @param szyx 所在院系
     */
    public void setSzyx(String szyx) {
        this.szyx = szyx == null ? null : szyx.trim();
    }

    /**
     * 获取专业代码
     *
     * @return ZYDM - 专业代码
     */
    public String getZydm() {
        return zydm;
    }

    /**
     * 设置专业代码
     *
     * @param zydm 专业代码
     */
    public void setZydm(String zydm) {
        this.zydm = zydm == null ? null : zydm.trim();
    }

    /**
     * 获取专业
     *
     * @return ZY - 专业
     */
    public String getZy() {
        return zy;
    }

    /**
     * 设置专业
     *
     * @param zy 专业
     */
    public void setZy(String zy) {
        this.zy = zy == null ? null : zy.trim();
    }

    /**
     * 获取专业方向
     *
     * @return ZYFX - 专业方向
     */
    public String getZyfx() {
        return zyfx;
    }

    /**
     * 设置专业方向
     *
     * @param zyfx 专业方向
     */
    public void setZyfx(String zyfx) {
        this.zyfx = zyfx == null ? null : zyfx.trim();
    }

    /**
     * 获取所在班级
     *
     * @return SZBJ - 所在班级
     */
    public String getSzbj() {
        return szbj;
    }

    /**
     * 设置所在班级
     *
     * @param szbj 所在班级
     */
    public void setSzbj(String szbj) {
        this.szbj = szbj == null ? null : szbj.trim();
    }

    /**
     * 获取学号
     *
     * @return XH - 学号
     */
    public String getXh() {
        return xh;
    }

    /**
     * 设置学号
     *
     * @param xh 学号
     */
    public void setXh(String xh) {
        this.xh = xh == null ? null : xh.trim();
    }

    /**
     * 获取入学时间
     *
     * @return RXSJ - 入学时间
     */
    public String getRxsj() {
        return rxsj;
    }

    /**
     * 设置入学时间
     *
     * @param rxsj 入学时间
     */
    public void setRxsj(String rxsj) {
        this.rxsj = rxsj == null ? null : rxsj.trim();
    }

    /**
     * 获取毕业时间
     *
     * @return BYSJ - 毕业时间
     */
    public String getBysj() {
        return bysj;
    }

    /**
     * 设置毕业时间
     *
     * @param bysj 毕业时间
     */
    public void setBysj(String bysj) {
        this.bysj = bysj == null ? null : bysj.trim();
    }

    /**
     * 获取困难生类别代码
     *
     * @return KNSLBDM - 困难生类别代码
     */
    public String getKnslbdm() {
        return knslbdm;
    }

    /**
     * 设置困难生类别代码
     *
     * @param knslbdm 困难生类别代码
     */
    public void setKnslbdm(String knslbdm) {
        this.knslbdm = knslbdm == null ? null : knslbdm.trim();
    }

    /**
     * 获取困难生类别
     *
     * @return KNSLB - 困难生类别
     */
    public String getKnslb() {
        return knslb;
    }

    /**
     * 设置困难生类别
     *
     * @param knslb 困难生类别
     */
    public void setKnslb(String knslb) {
        this.knslb = knslb == null ? null : knslb.trim();
    }

    /**
     * 获取师范生类别代码
     *
     * @return SFSLBDM - 师范生类别代码
     */
    public String getSfslbdm() {
        return sfslbdm;
    }

    /**
     * 设置师范生类别代码
     *
     * @param sfslbdm 师范生类别代码
     */
    public void setSfslbdm(String sfslbdm) {
        this.sfslbdm = sfslbdm == null ? null : sfslbdm.trim();
    }

    /**
     * 获取师范生类别
     *
     * @return SFSLB - 师范生类别
     */
    public String getSfslb() {
        return sfslb;
    }

    /**
     * 设置师范生类别
     *
     * @param sfslb 师范生类别
     */
    public void setSfslb(String sfslb) {
        this.sfslb = sfslb == null ? null : sfslb.trim();
    }

    /**
     * 获取培养方式代码
     *
     * @return PYFSDM - 培养方式代码
     */
    public String getPyfsdm() {
        return pyfsdm;
    }

    /**
     * 设置培养方式代码
     *
     * @param pyfsdm 培养方式代码
     */
    public void setPyfsdm(String pyfsdm) {
        this.pyfsdm = pyfsdm == null ? null : pyfsdm.trim();
    }

    /**
     * 获取培养方式
     *
     * @return PYFS - 培养方式
     */
    public String getPyfs() {
        return pyfs;
    }

    /**
     * 设置培养方式
     *
     * @param pyfs 培养方式
     */
    public void setPyfs(String pyfs) {
        this.pyfs = pyfs == null ? null : pyfs.trim();
    }

    /**
     * 获取主修外语代码（湖南）
     *
     * @return ZXWYDM - 主修外语代码（湖南）
     */
    public String getZxwydm() {
        return zxwydm;
    }

    /**
     * 设置主修外语代码（湖南）
     *
     * @param zxwydm 主修外语代码（湖南）
     */
    public void setZxwydm(String zxwydm) {
        this.zxwydm = zxwydm == null ? null : zxwydm.trim();
    }

    /**
     * 获取主修外语（湖南）
     *
     * @return ZXWY - 主修外语（湖南）
     */
    public String getZxwy() {
        return zxwy;
    }

    /**
     * 设置主修外语（湖南）
     *
     * @param zxwy 主修外语（湖南）
     */
    public void setZxwy(String zxwy) {
        this.zxwy = zxwy == null ? null : zxwy.trim();
    }

    /**
     * 获取档案是否转入学校
     *
     * @return DASFZRXX - 档案是否转入学校
     */
    public Byte getDasfzrxx() {
        return dasfzrxx;
    }

    /**
     * 设置档案是否转入学校
     *
     * @param dasfzrxx 档案是否转入学校
     */
    public void setDasfzrxx(Byte dasfzrxx) {
        this.dasfzrxx = dasfzrxx;
    }

    /**
     * 获取户口是否转入学校
     *
     * @return HKSFZRXX - 户口是否转入学校
     */
    public Byte getHksfzrxx() {
        return hksfzrxx;
    }

    /**
     * 设置户口是否转入学校
     *
     * @param hksfzrxx 户口是否转入学校
     */
    public void setHksfzrxx(Byte hksfzrxx) {
        this.hksfzrxx = hksfzrxx;
    }

    /**
     * 获取入学前档案所在单位
     *
     * @return RXQDASZDW - 入学前档案所在单位
     */
    public String getRxqdaszdw() {
        return rxqdaszdw;
    }

    /**
     * 设置入学前档案所在单位
     *
     * @param rxqdaszdw 入学前档案所在单位
     */
    public void setRxqdaszdw(String rxqdaszdw) {
        this.rxqdaszdw = rxqdaszdw == null ? null : rxqdaszdw.trim();
    }

    /**
     * 获取入学前户口所在地派出所
     *
     * @return RXQHKSZDPCS - 入学前户口所在地派出所
     */
    public String getRxqhkszdpcs() {
        return rxqhkszdpcs;
    }

    /**
     * 设置入学前户口所在地派出所
     *
     * @param rxqhkszdpcs 入学前户口所在地派出所
     */
    public void setRxqhkszdpcs(String rxqhkszdpcs) {
        this.rxqhkszdpcs = rxqhkszdpcs == null ? null : rxqhkszdpcs.trim();
    }

    /**
     * 获取定向或委培单位（预留）
     *
     * @return DXHWPDW - 定向或委培单位（预留）
     */
    public String getDxhwpdw() {
        return dxhwpdw;
    }

    /**
     * 设置定向或委培单位（预留）
     *
     * @param dxhwpdw 定向或委培单位（预留）
     */
    public void setDxhwpdw(String dxhwpdw) {
        this.dxhwpdw = dxhwpdw == null ? null : dxhwpdw.trim();
    }

    /**
     * 获取城乡生源（预留）
     *
     * @return CXSY - 城乡生源（预留）
     */
    public String getCxsy() {
        return cxsy;
    }

    /**
     * 设置城乡生源（预留）
     *
     * @param cxsy 城乡生源（预留）
     */
    public void setCxsy(String cxsy) {
        this.cxsy = cxsy == null ? null : cxsy.trim();
    }

    /**
     * 获取审核状态 1待审核 2审核通过 3审核不通过
     *
     * @return AUDIT_STATUS - 审核状态 1待审核 2审核通过 3审核不通过
     */
    public Byte getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置审核状态 1待审核 2审核通过 3审核不通过
     *
     * @param auditStatus 审核状态 1待审核 2审核通过 3审核不通过
     */
    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 获取审核内容说明
     *
     * @return AUDIT_CONTENT - 审核内容说明
     */
    public String getAuditContent() {
        return auditContent;
    }

    /**
     * 设置审核内容说明
     *
     * @param auditContent 审核内容说明
     */
    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent == null ? null : auditContent.trim();
    }

    /**
     * 获取审核时间
     *
     * @return AUDIT_DATE - 审核时间
     */
    public Date getAuditDate() {
        return auditDate;
    }

    /**
     * 设置审核时间
     *
     * @param auditDate 审核时间
     */
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    /**
     * 获取审核人id
     *
     * @return AUDITOR_ID - 审核人id
     */
    public String getAuditorId() {
        return auditorId;
    }

    /**
     * 设置审核人id
     *
     * @param auditorId 审核人id
     */
    public void setAuditorId(String auditorId) {
        this.auditorId = auditorId == null ? null : auditorId.trim();
    }

    /**
     * 获取解绑图片地址
     *
     * @return UNBIND_IMG_URL - 解绑图片地址
     */
    public String getUnbindImgUrl() {
        return unbindImgUrl;
    }

    /**
     * 设置解绑图片地址
     *
     * @param unbindImgUrl 解绑图片地址
     */
    public void setUnbindImgUrl(String unbindImgUrl) {
        this.unbindImgUrl = unbindImgUrl == null ? null : unbindImgUrl.trim();
    }

    /**
     * 获取解绑原因
     *
     * @return UNBIND_CONTENT - 解绑原因
     */
    public String getUnbindContent() {
        return unbindContent;
    }

    /**
     * 设置解绑原因
     *
     * @param unbindContent 解绑原因
     */
    public void setUnbindContent(String unbindContent) {
        this.unbindContent = unbindContent == null ? null : unbindContent.trim();
    }

    /**
     * 获取扩展字段1
     *
     * @return KZZD1 - 扩展字段1
     */
    public String getKzzd1() {
        return kzzd1;
    }

    /**
     * 设置扩展字段1
     *
     * @param kzzd1 扩展字段1
     */
    public void setKzzd1(String kzzd1) {
        this.kzzd1 = kzzd1 == null ? null : kzzd1.trim();
    }

    /**
     * 获取扩展字段2
     *
     * @return KZZD2 - 扩展字段2
     */
    public String getKzzd2() {
        return kzzd2;
    }

    /**
     * 设置扩展字段2
     *
     * @param kzzd2 扩展字段2
     */
    public void setKzzd2(String kzzd2) {
        this.kzzd2 = kzzd2 == null ? null : kzzd2.trim();
    }

    /**
     * 获取扩展字段3
     *
     * @return KZZD3 - 扩展字段3
     */
    public String getKzzd3() {
        return kzzd3;
    }

    /**
     * 设置扩展字段3
     *
     * @param kzzd3 扩展字段3
     */
    public void setKzzd3(String kzzd3) {
        this.kzzd3 = kzzd3 == null ? null : kzzd3.trim();
    }

    /**
     * 获取扩展字段4
     *
     * @return KZZD4 - 扩展字段4
     */
    public String getKzzd4() {
        return kzzd4;
    }

    /**
     * 设置扩展字段4
     *
     * @param kzzd4 扩展字段4
     */
    public void setKzzd4(String kzzd4) {
        this.kzzd4 = kzzd4 == null ? null : kzzd4.trim();
    }

    /**
     * 获取扩展字段5
     *
     * @return KZZD5 - 扩展字段5
     */
    public String getKzzd5() {
        return kzzd5;
    }

    /**
     * 设置扩展字段5
     *
     * @param kzzd5 扩展字段5
     */
    public void setKzzd5(String kzzd5) {
        this.kzzd5 = kzzd5 == null ? null : kzzd5.trim();
    }

    /**
     * 获取扩展字段6
     *
     * @return KZZD6 - 扩展字段6
     */
    public String getKzzd6() {
        return kzzd6;
    }

    /**
     * 设置扩展字段6
     *
     * @param kzzd6 扩展字段6
     */
    public void setKzzd6(String kzzd6) {
        this.kzzd6 = kzzd6 == null ? null : kzzd6.trim();
    }

    /**
     * 获取扩展字段7
     *
     * @return KZZD7 - 扩展字段7
     */
    public String getKzzd7() {
        return kzzd7;
    }

    /**
     * 设置扩展字段7
     *
     * @param kzzd7 扩展字段7
     */
    public void setKzzd7(String kzzd7) {
        this.kzzd7 = kzzd7 == null ? null : kzzd7.trim();
    }

    /**
     * 获取扩展字段8
     *
     * @return KZZD8 - 扩展字段8
     */
    public String getKzzd8() {
        return kzzd8;
    }

    /**
     * 设置扩展字段8
     *
     * @param kzzd8 扩展字段8
     */
    public void setKzzd8(String kzzd8) {
        this.kzzd8 = kzzd8 == null ? null : kzzd8.trim();
    }

    /**
     * 获取手机号是否核验
     *
     * @return CHECK_PHONE_UPDATE - 手机号是否核验
     */
    public Byte getCheckPhoneUpdate() {
        return checkPhoneUpdate;
    }

    /**
     * 设置手机号是否核验
     *
     * @param checkPhoneUpdate 手机号是否核验
     */
    public void setCheckPhoneUpdate(Byte checkPhoneUpdate) {
        this.checkPhoneUpdate = checkPhoneUpdate;
    }

    /**
     * 获取核验是否改动 0 未核验 1 核验未改动 2 核验申请改动
     *
     * @return CHECK_UPDATE - 核验是否改动 0 未核验 1 核验未改动 2 核验申请改动
     */
    public Byte getCheckUpdate() {
        return checkUpdate;
    }

    /**
     * 设置核验是否改动 0 未核验 1 核验未改动 2 核验申请改动
     *
     * @param checkUpdate 核验是否改动 0 未核验 1 核验未改动 2 核验申请改动
     */
    public void setCheckUpdate(Byte checkUpdate) {
        this.checkUpdate = checkUpdate;
    }

    /**
     * 获取核验时间
     *
     * @return CHECK_DATE - 核验时间
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * 设置核验时间
     *
     * @param checkDate 核验时间
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
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
     * 获取创建者
     *
     * @return CREATOR - 创建者
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
