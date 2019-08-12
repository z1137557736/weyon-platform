package com.weyon.core.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_core_student_employ")
public class CoreStudentEmploy implements Serializable {
    /**
     * 学生ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 学生关联键
     */
    @Column(name = "STUDENT_KEY")
    private String studentKey;

    /**
     * 派遣方式
     */
    @Column(name = "PQFS")
    private String pqfs;

    /**
     * 派遣方式代码
     */
    @Column(name = "PQFSDM")
    private String pqfsdm;

    /**
     * 毕业去向
     */
    @Column(name = "BYQX")
    private String byqx;

    /**
     * 毕业去向代码
     */
    @Column(name = "BYQXDM")
    private String byqxdm;

    /**
     * 单位名称
     */
    @Column(name = "DWMC")
    private String dwmc;

    /**
     * 单位组织机构代码
     */
    @Column(name = "DWZZJGDM")
    private String dwzzjgdm;

    /**
     * 单位性质
     */
    @Column(name = "DWXZ")
    private String dwxz;

    /**
     * 单位性质代码
     */
    @Column(name = "DWXZDM")
    private String dwxzdm;

    /**
     * 单位行业
     */
    @Column(name = "DWHY")
    private String dwhy;

    /**
     * 单位行业代码
     */
    @Column(name = "DWHYDM")
    private String dwhydm;

    /**
     * 单位所在地
     */
    @Column(name = "DWSZD")
    private String dwszd;

    /**
     * 单位所在地代码
     */
    @Column(name = "DWSZDDM")
    private String dwszddm;

    /**
     * 工作职位类别
     */
    @Column(name = "GZZWLB")
    private String gzzwlb;

    /**
     * 工作职位类别代码
     */
    @Column(name = "GZZWLBDM")
    private String gzzwlbdm;

    /**
     * 单位联系人
     */
    @Column(name = "DWLXR")
    private String dwlxr;

    /**
     * 联系人手机
     */
    @Column(name = "LXRSJ")
    private String lxrsj;

    /**
     * 联系人电话
     */
    @Column(name = "LXRDH")
    private String lxrdh;

    /**
     * 联系人EMAIL
     */
    @Column(name = "LXRDZYX")
    private String lxrdzyx;

    /**
     * 联系人传真
     */
    @Column(name = "LXRCZ")
    private String lxrcz;

    /**
     * 单位邮编
     */
    @Column(name = "DWYB")
    private String dwyb;

    /**
     * 单位地址
     */
    @Column(name = "DWDZ")
    private String dwdz;

    /**
     * 是否接收报到证
     */
    @Column(name = "SFJSBDZ")
    private Byte sfjsbdz;

    /**
     * 报到证签发类别
     */
    @Column(name = "BDZQFLB")
    private String bdzqflb;

    /**
     * 报到证签发类别
     */
    @Column(name = "BDZQFLBDM")
    private String bdzqflbdm;

    /**
     * 报到证序列号
     */
    @Column(name = "BDZXLH")
    private String bdzxlh;

    /**
     * 报到证编号
     */
    @Column(name = "BDZBH")
    private String bdzbh;

    /**
     * 报到证起始时间
     */
    @Column(name = "BDZQSSJ")
    private Integer bdzqssj;

    /**
     * 报到证签往单位名称
     */
    @Column(name = "BDZQWDWMC")
    private String bdzqwdwmc;

    /**
     * 报到证迁往单位隶属部门
     */
    @Column(name = "BDZQWDWLS")
    private String bdzqwdwls;

    /**
     * 报到证迁往单位隶属部门代码
     */
    @Column(name = "BDZQWDWLSDM")
    private String bdzqwdwlsdm;

    /**
     * 报到证签往单位地址
     */
    @Column(name = "BDZQWDWDZ")
    private String bdzqwdwdz;

    /**
     * 签往单位所在地
     */
    @Column(name = "QWDWSZD")
    private String qwdwszd;

    /**
     * 签往单位所在地代码
     */
    @Column(name = "QWDWSZDDM")
    private String qwdwszddm;

    /**
     * 实际所在地
     */
    @Column(name = "SJDWSZD")
    private String sjdwszd;

    /**
     * 实际所在地代码
     */
    @Column(name = "SJDWSZDDM")
    private String sjdwszddm;

    /**
     * 是否接收档案
     */
    @Column(name = "SFJSDA")
    private Byte sfjsda;

    /**
     * 档案转寄单位名称
     */
    @Column(name = "DAZJDWMC")
    private String dazjdwmc;

    /**
     * 档案转寄单位联系人
     */
    @Column(name = "DAZJDWLXR")
    private String dazjdwlxr;

    /**
     * 档案转寄单位电话
     */
    @Column(name = "DAZJDWDH")
    private String dazjdwdh;

    /**
     * 档案转寄单位邮编
     */
    @Column(name = "DAZJDWYB")
    private String dazjdwyb;

    /**
     * 档案转寄单位地址
     */
    @Column(name = "DAZJDWDZ")
    private String dazjdwdz;

    /**
     * 是否迁移户口
     */
    @Column(name = "SFQYHK")
    private Byte sfqyhk;

    /**
     * 户口迁转单位
     */
    @Column(name = "HKQZDW")
    private String hkqzdw;

    /**
     * 户口迁转地址
     */
    @Column(name = "HKQZDZ")
    private String hkqzdz;

    /**
     * 协议书编号
     */
    @Column(name = "XYSBH")
    private String xysbh;

    /**
     * 上传就业协议书、劳动合同或其他工作证明材料
     */
    @Column(name = "JYXYZP")
    private String jyxyzp;

    /**
     * 升学院校
     */
    @Column(name = "SXYX")
    private String sxyx;

    /**
     * 升学院校代码
     */
    @Column(name = "SXYXDM")
    private String sxyxdm;

    /**
     * 升学专业
     */
    @Column(name = "SXZY")
    private String sxzy;

    /**
     * 升学专业代码
     */
    @Column(name = "SXZYDM")
    private String sxzydm;

    /**
     * 升学学历
     */
    @Column(name = "SXXL")
    private String sxxl;

    /**
     * 升学学历代码
     */
    @Column(name = "SXXLDM")
    private String sxxldm;

    /**
     * 报到证备注
     */
    @Column(name = "BDZBZ")
    private String bdzbz;

    /**
     * 出国出境名称
     */
    @Column(name = "CGCJMC")
    private String cgcjmc;

    /**
     * 基层就业类别
     */
    @Column(name = "JCJYLB")
    private String jcjylb;

    /**
     * 基层就业类别代码
     */
    @Column(name = "JCJYLBDM")
    private String jcjylbdm;

    /**
     * 就业状况
     */
    @Column(name = "JYZK")
    private String jyzk;

    /**
     * 就业状况代码
     */
    @Column(name = "JYZKDM")
    private String jyzkdm;

    /**
     * 就业材料类型
     */
    @Column(name = "JYCLLX")
    private String jycllx;

    /**
     * 就业材料类型代码
     */
    @Column(name = "JYCLLXDM")
    private String jycllxdm;

    /**
     * 未就业类别
     */
    @Column(name = "WJYLB")
    private String wjylb;

    /**
     * 未就业类别代码
     */
    @Column(name = "WJYLBDM")
    private String wjylbdm;

    /**
     * 反馈类别
     */
    @Column(name = "FKLB")
    private String fklb;

    /**
     * 反馈类别代码
     */
    @Column(name = "FKLBDM")
    private String fklbdm;

    /**
     * 薪资  （起薪转正后为（月薪 元））
     */
    @Column(name = "GZ_QXZZHW")
    private Integer gzQxzzhw;

    /**
     * 是否专业对口
     */
    @Column(name = "SFZYDK")
    private Byte sfzydk;

    /**
     * 是否就业困难
     */
    @Column(name = "SFJYKN")
    private Byte sfjykn;

    /**
     * 签约时间
     */
    @Column(name = "GZ_YPSJ")
    private String gzYpsj;

    /**
     * 医疗企业单位分类
     */
    @Column(name = "YLQYDWFL")
    private String ylqydwfl;

    /**
     * 医疗事业单位分类
     */
    @Column(name = "YLSYDWFL")
    private String ylsydwfl;

    /**
     * 单位隶属部门
     */
    @Column(name = "DWLSBM")
    private String dwlsbm;

    /**
     * 单位联系部门
     */
    @Column(name = "DWLXBM")
    private String dwlxbm;

    /**
     * 单位所有制性质
     */
    @Column(name = "DWSYZXZ")
    private String dwsyzxz;

    /**
     * 报到证毕字号
     */
    @Column(name = "BDZ_BZH")
    private String bdzBzh;

    /**
     * 报到证编号前缀
     */
    @Column(name = "BDZBH_QZ")
    private String bdzbhQz;

    /**
     * 报到证编号后缀
     */
    @Column(name = "BDZBH_HZ")
    private String bdzbhHz;

    /**
     * 报到证档案材料
     */
    @Column(name = "BDZ_DACL")
    private String bdzDacl;

    /**
     * 扩展字段1
     */
    @Column(name = "JY_KZZD1")
    private String jyKzzd1;

    /**
     * 扩展字段2
     */
    @Column(name = "JY_KZZD2")
    private String jyKzzd2;

    /**
     * 扩展字段3
     */
    @Column(name = "JY_KZZD3")
    private String jyKzzd3;

    /**
     * 扩展字段4
     */
    @Column(name = "JY_KZZD4")
    private String jyKzzd4;

    /**
     * 扩展字段5
     */
    @Column(name = "JY_KZZD5")
    private String jyKzzd5;

    /**
     * 扩展字段6
     */
    @Column(name = "JY_KZZD6")
    private String jyKzzd6;

    /**
     * 扩展字段7
     */
    @Column(name = "JY_KZZD7")
    private String jyKzzd7;

    /**
     * 扩展字段8
     */
    @Column(name = "JY_KZZD8")
    private String jyKzzd8;

    /**
     * 核验是否改动
     */
    @Column(name = "CHECK_UPDATE")
    private Byte checkUpdate;

    /**
     * 核验时间
     */
    @Column(name = "CHECK_DATE")
    private Date checkDate;

    /**
     * 创建者ID
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
     * 获取学生ID
     *
     * @return ID - 学生ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置学生ID
     *
     * @param id 学生ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取学生关联键
     *
     * @return STUDENT_KEY - 学生关联键
     */
    public String getStudentKey() {
        return studentKey;
    }

    /**
     * 设置学生关联键
     *
     * @param studentKey 学生关联键
     */
    public void setStudentKey(String studentKey) {
        this.studentKey = studentKey == null ? null : studentKey.trim();
    }

    /**
     * 获取派遣方式
     *
     * @return PQFS - 派遣方式
     */
    public String getPqfs() {
        return pqfs;
    }

    /**
     * 设置派遣方式
     *
     * @param pqfs 派遣方式
     */
    public void setPqfs(String pqfs) {
        this.pqfs = pqfs == null ? null : pqfs.trim();
    }

    /**
     * 获取派遣方式代码
     *
     * @return PQFSDM - 派遣方式代码
     */
    public String getPqfsdm() {
        return pqfsdm;
    }

    /**
     * 设置派遣方式代码
     *
     * @param pqfsdm 派遣方式代码
     */
    public void setPqfsdm(String pqfsdm) {
        this.pqfsdm = pqfsdm == null ? null : pqfsdm.trim();
    }

    /**
     * 获取毕业去向
     *
     * @return BYQX - 毕业去向
     */
    public String getByqx() {
        return byqx;
    }

    /**
     * 设置毕业去向
     *
     * @param byqx 毕业去向
     */
    public void setByqx(String byqx) {
        this.byqx = byqx == null ? null : byqx.trim();
    }

    /**
     * 获取毕业去向代码
     *
     * @return BYQXDM - 毕业去向代码
     */
    public String getByqxdm() {
        return byqxdm;
    }

    /**
     * 设置毕业去向代码
     *
     * @param byqxdm 毕业去向代码
     */
    public void setByqxdm(String byqxdm) {
        this.byqxdm = byqxdm == null ? null : byqxdm.trim();
    }

    /**
     * 获取单位名称
     *
     * @return DWMC - 单位名称
     */
    public String getDwmc() {
        return dwmc;
    }

    /**
     * 设置单位名称
     *
     * @param dwmc 单位名称
     */
    public void setDwmc(String dwmc) {
        this.dwmc = dwmc == null ? null : dwmc.trim();
    }

    /**
     * 获取单位组织机构代码
     *
     * @return DWZZJGDM - 单位组织机构代码
     */
    public String getDwzzjgdm() {
        return dwzzjgdm;
    }

    /**
     * 设置单位组织机构代码
     *
     * @param dwzzjgdm 单位组织机构代码
     */
    public void setDwzzjgdm(String dwzzjgdm) {
        this.dwzzjgdm = dwzzjgdm == null ? null : dwzzjgdm.trim();
    }

    /**
     * 获取单位性质
     *
     * @return DWXZ - 单位性质
     */
    public String getDwxz() {
        return dwxz;
    }

    /**
     * 设置单位性质
     *
     * @param dwxz 单位性质
     */
    public void setDwxz(String dwxz) {
        this.dwxz = dwxz == null ? null : dwxz.trim();
    }

    /**
     * 获取单位性质代码
     *
     * @return DWXZDM - 单位性质代码
     */
    public String getDwxzdm() {
        return dwxzdm;
    }

    /**
     * 设置单位性质代码
     *
     * @param dwxzdm 单位性质代码
     */
    public void setDwxzdm(String dwxzdm) {
        this.dwxzdm = dwxzdm == null ? null : dwxzdm.trim();
    }

    /**
     * 获取单位行业
     *
     * @return DWHY - 单位行业
     */
    public String getDwhy() {
        return dwhy;
    }

    /**
     * 设置单位行业
     *
     * @param dwhy 单位行业
     */
    public void setDwhy(String dwhy) {
        this.dwhy = dwhy == null ? null : dwhy.trim();
    }

    /**
     * 获取单位行业代码
     *
     * @return DWHYDM - 单位行业代码
     */
    public String getDwhydm() {
        return dwhydm;
    }

    /**
     * 设置单位行业代码
     *
     * @param dwhydm 单位行业代码
     */
    public void setDwhydm(String dwhydm) {
        this.dwhydm = dwhydm == null ? null : dwhydm.trim();
    }

    /**
     * 获取单位所在地
     *
     * @return DWSZD - 单位所在地
     */
    public String getDwszd() {
        return dwszd;
    }

    /**
     * 设置单位所在地
     *
     * @param dwszd 单位所在地
     */
    public void setDwszd(String dwszd) {
        this.dwszd = dwszd == null ? null : dwszd.trim();
    }

    /**
     * 获取单位所在地代码
     *
     * @return DWSZDDM - 单位所在地代码
     */
    public String getDwszddm() {
        return dwszddm;
    }

    /**
     * 设置单位所在地代码
     *
     * @param dwszddm 单位所在地代码
     */
    public void setDwszddm(String dwszddm) {
        this.dwszddm = dwszddm == null ? null : dwszddm.trim();
    }

    /**
     * 获取工作职位类别
     *
     * @return GZZWLB - 工作职位类别
     */
    public String getGzzwlb() {
        return gzzwlb;
    }

    /**
     * 设置工作职位类别
     *
     * @param gzzwlb 工作职位类别
     */
    public void setGzzwlb(String gzzwlb) {
        this.gzzwlb = gzzwlb == null ? null : gzzwlb.trim();
    }

    /**
     * 获取工作职位类别代码
     *
     * @return GZZWLBDM - 工作职位类别代码
     */
    public String getGzzwlbdm() {
        return gzzwlbdm;
    }

    /**
     * 设置工作职位类别代码
     *
     * @param gzzwlbdm 工作职位类别代码
     */
    public void setGzzwlbdm(String gzzwlbdm) {
        this.gzzwlbdm = gzzwlbdm == null ? null : gzzwlbdm.trim();
    }

    /**
     * 获取单位联系人
     *
     * @return DWLXR - 单位联系人
     */
    public String getDwlxr() {
        return dwlxr;
    }

    /**
     * 设置单位联系人
     *
     * @param dwlxr 单位联系人
     */
    public void setDwlxr(String dwlxr) {
        this.dwlxr = dwlxr == null ? null : dwlxr.trim();
    }

    /**
     * 获取联系人手机
     *
     * @return LXRSJ - 联系人手机
     */
    public String getLxrsj() {
        return lxrsj;
    }

    /**
     * 设置联系人手机
     *
     * @param lxrsj 联系人手机
     */
    public void setLxrsj(String lxrsj) {
        this.lxrsj = lxrsj == null ? null : lxrsj.trim();
    }

    /**
     * 获取联系人电话
     *
     * @return LXRDH - 联系人电话
     */
    public String getLxrdh() {
        return lxrdh;
    }

    /**
     * 设置联系人电话
     *
     * @param lxrdh 联系人电话
     */
    public void setLxrdh(String lxrdh) {
        this.lxrdh = lxrdh == null ? null : lxrdh.trim();
    }

    /**
     * 获取联系人EMAIL
     *
     * @return LXRDZYX - 联系人EMAIL
     */
    public String getLxrdzyx() {
        return lxrdzyx;
    }

    /**
     * 设置联系人EMAIL
     *
     * @param lxrdzyx 联系人EMAIL
     */
    public void setLxrdzyx(String lxrdzyx) {
        this.lxrdzyx = lxrdzyx == null ? null : lxrdzyx.trim();
    }

    /**
     * 获取联系人传真
     *
     * @return LXRCZ - 联系人传真
     */
    public String getLxrcz() {
        return lxrcz;
    }

    /**
     * 设置联系人传真
     *
     * @param lxrcz 联系人传真
     */
    public void setLxrcz(String lxrcz) {
        this.lxrcz = lxrcz == null ? null : lxrcz.trim();
    }

    /**
     * 获取单位邮编
     *
     * @return DWYB - 单位邮编
     */
    public String getDwyb() {
        return dwyb;
    }

    /**
     * 设置单位邮编
     *
     * @param dwyb 单位邮编
     */
    public void setDwyb(String dwyb) {
        this.dwyb = dwyb == null ? null : dwyb.trim();
    }

    /**
     * 获取单位地址
     *
     * @return DWDZ - 单位地址
     */
    public String getDwdz() {
        return dwdz;
    }

    /**
     * 设置单位地址
     *
     * @param dwdz 单位地址
     */
    public void setDwdz(String dwdz) {
        this.dwdz = dwdz == null ? null : dwdz.trim();
    }

    /**
     * 获取是否接收报到证
     *
     * @return SFJSBDZ - 是否接收报到证
     */
    public Byte getSfjsbdz() {
        return sfjsbdz;
    }

    /**
     * 设置是否接收报到证
     *
     * @param sfjsbdz 是否接收报到证
     */
    public void setSfjsbdz(Byte sfjsbdz) {
        this.sfjsbdz = sfjsbdz;
    }

    /**
     * 获取报到证签发类别
     *
     * @return BDZQFLB - 报到证签发类别
     */
    public String getBdzqflb() {
        return bdzqflb;
    }

    /**
     * 设置报到证签发类别
     *
     * @param bdzqflb 报到证签发类别
     */
    public void setBdzqflb(String bdzqflb) {
        this.bdzqflb = bdzqflb == null ? null : bdzqflb.trim();
    }

    /**
     * 获取报到证签发类别
     *
     * @return BDZQFLBDM - 报到证签发类别
     */
    public String getBdzqflbdm() {
        return bdzqflbdm;
    }

    /**
     * 设置报到证签发类别
     *
     * @param bdzqflbdm 报到证签发类别
     */
    public void setBdzqflbdm(String bdzqflbdm) {
        this.bdzqflbdm = bdzqflbdm == null ? null : bdzqflbdm.trim();
    }

    /**
     * 获取报到证序列号
     *
     * @return BDZXLH - 报到证序列号
     */
    public String getBdzxlh() {
        return bdzxlh;
    }

    /**
     * 设置报到证序列号
     *
     * @param bdzxlh 报到证序列号
     */
    public void setBdzxlh(String bdzxlh) {
        this.bdzxlh = bdzxlh == null ? null : bdzxlh.trim();
    }

    /**
     * 获取报到证编号
     *
     * @return BDZBH - 报到证编号
     */
    public String getBdzbh() {
        return bdzbh;
    }

    /**
     * 设置报到证编号
     *
     * @param bdzbh 报到证编号
     */
    public void setBdzbh(String bdzbh) {
        this.bdzbh = bdzbh == null ? null : bdzbh.trim();
    }

    /**
     * 获取报到证起始时间
     *
     * @return BDZQSSJ - 报到证起始时间
     */
    public Integer getBdzqssj() {
        return bdzqssj;
    }

    /**
     * 设置报到证起始时间
     *
     * @param bdzqssj 报到证起始时间
     */
    public void setBdzqssj(Integer bdzqssj) {
        this.bdzqssj = bdzqssj;
    }

    /**
     * 获取报到证签往单位名称
     *
     * @return BDZQWDWMC - 报到证签往单位名称
     */
    public String getBdzqwdwmc() {
        return bdzqwdwmc;
    }

    /**
     * 设置报到证签往单位名称
     *
     * @param bdzqwdwmc 报到证签往单位名称
     */
    public void setBdzqwdwmc(String bdzqwdwmc) {
        this.bdzqwdwmc = bdzqwdwmc == null ? null : bdzqwdwmc.trim();
    }

    /**
     * 获取报到证迁往单位隶属部门
     *
     * @return BDZQWDWLS - 报到证迁往单位隶属部门
     */
    public String getBdzqwdwls() {
        return bdzqwdwls;
    }

    /**
     * 设置报到证迁往单位隶属部门
     *
     * @param bdzqwdwls 报到证迁往单位隶属部门
     */
    public void setBdzqwdwls(String bdzqwdwls) {
        this.bdzqwdwls = bdzqwdwls == null ? null : bdzqwdwls.trim();
    }

    /**
     * 获取报到证迁往单位隶属部门代码
     *
     * @return BDZQWDWLSDM - 报到证迁往单位隶属部门代码
     */
    public String getBdzqwdwlsdm() {
        return bdzqwdwlsdm;
    }

    /**
     * 设置报到证迁往单位隶属部门代码
     *
     * @param bdzqwdwlsdm 报到证迁往单位隶属部门代码
     */
    public void setBdzqwdwlsdm(String bdzqwdwlsdm) {
        this.bdzqwdwlsdm = bdzqwdwlsdm == null ? null : bdzqwdwlsdm.trim();
    }

    /**
     * 获取报到证签往单位地址
     *
     * @return BDZQWDWDZ - 报到证签往单位地址
     */
    public String getBdzqwdwdz() {
        return bdzqwdwdz;
    }

    /**
     * 设置报到证签往单位地址
     *
     * @param bdzqwdwdz 报到证签往单位地址
     */
    public void setBdzqwdwdz(String bdzqwdwdz) {
        this.bdzqwdwdz = bdzqwdwdz == null ? null : bdzqwdwdz.trim();
    }

    /**
     * 获取签往单位所在地
     *
     * @return QWDWSZD - 签往单位所在地
     */
    public String getQwdwszd() {
        return qwdwszd;
    }

    /**
     * 设置签往单位所在地
     *
     * @param qwdwszd 签往单位所在地
     */
    public void setQwdwszd(String qwdwszd) {
        this.qwdwszd = qwdwszd == null ? null : qwdwszd.trim();
    }

    /**
     * 获取签往单位所在地代码
     *
     * @return QWDWSZDDM - 签往单位所在地代码
     */
    public String getQwdwszddm() {
        return qwdwszddm;
    }

    /**
     * 设置签往单位所在地代码
     *
     * @param qwdwszddm 签往单位所在地代码
     */
    public void setQwdwszddm(String qwdwszddm) {
        this.qwdwszddm = qwdwszddm == null ? null : qwdwszddm.trim();
    }

    /**
     * 获取实际所在地
     *
     * @return SJDWSZD - 实际所在地
     */
    public String getSjdwszd() {
        return sjdwszd;
    }

    /**
     * 设置实际所在地
     *
     * @param sjdwszd 实际所在地
     */
    public void setSjdwszd(String sjdwszd) {
        this.sjdwszd = sjdwszd == null ? null : sjdwszd.trim();
    }

    /**
     * 获取实际所在地代码
     *
     * @return SJDWSZDDM - 实际所在地代码
     */
    public String getSjdwszddm() {
        return sjdwszddm;
    }

    /**
     * 设置实际所在地代码
     *
     * @param sjdwszddm 实际所在地代码
     */
    public void setSjdwszddm(String sjdwszddm) {
        this.sjdwszddm = sjdwszddm == null ? null : sjdwszddm.trim();
    }

    /**
     * 获取是否接收档案
     *
     * @return SFJSDA - 是否接收档案
     */
    public Byte getSfjsda() {
        return sfjsda;
    }

    /**
     * 设置是否接收档案
     *
     * @param sfjsda 是否接收档案
     */
    public void setSfjsda(Byte sfjsda) {
        this.sfjsda = sfjsda;
    }

    /**
     * 获取档案转寄单位名称
     *
     * @return DAZJDWMC - 档案转寄单位名称
     */
    public String getDazjdwmc() {
        return dazjdwmc;
    }

    /**
     * 设置档案转寄单位名称
     *
     * @param dazjdwmc 档案转寄单位名称
     */
    public void setDazjdwmc(String dazjdwmc) {
        this.dazjdwmc = dazjdwmc == null ? null : dazjdwmc.trim();
    }

    /**
     * 获取档案转寄单位联系人
     *
     * @return DAZJDWLXR - 档案转寄单位联系人
     */
    public String getDazjdwlxr() {
        return dazjdwlxr;
    }

    /**
     * 设置档案转寄单位联系人
     *
     * @param dazjdwlxr 档案转寄单位联系人
     */
    public void setDazjdwlxr(String dazjdwlxr) {
        this.dazjdwlxr = dazjdwlxr == null ? null : dazjdwlxr.trim();
    }

    /**
     * 获取档案转寄单位电话
     *
     * @return DAZJDWDH - 档案转寄单位电话
     */
    public String getDazjdwdh() {
        return dazjdwdh;
    }

    /**
     * 设置档案转寄单位电话
     *
     * @param dazjdwdh 档案转寄单位电话
     */
    public void setDazjdwdh(String dazjdwdh) {
        this.dazjdwdh = dazjdwdh == null ? null : dazjdwdh.trim();
    }

    /**
     * 获取档案转寄单位邮编
     *
     * @return DAZJDWYB - 档案转寄单位邮编
     */
    public String getDazjdwyb() {
        return dazjdwyb;
    }

    /**
     * 设置档案转寄单位邮编
     *
     * @param dazjdwyb 档案转寄单位邮编
     */
    public void setDazjdwyb(String dazjdwyb) {
        this.dazjdwyb = dazjdwyb == null ? null : dazjdwyb.trim();
    }

    /**
     * 获取档案转寄单位地址
     *
     * @return DAZJDWDZ - 档案转寄单位地址
     */
    public String getDazjdwdz() {
        return dazjdwdz;
    }

    /**
     * 设置档案转寄单位地址
     *
     * @param dazjdwdz 档案转寄单位地址
     */
    public void setDazjdwdz(String dazjdwdz) {
        this.dazjdwdz = dazjdwdz == null ? null : dazjdwdz.trim();
    }

    /**
     * 获取是否迁移户口
     *
     * @return SFQYHK - 是否迁移户口
     */
    public Byte getSfqyhk() {
        return sfqyhk;
    }

    /**
     * 设置是否迁移户口
     *
     * @param sfqyhk 是否迁移户口
     */
    public void setSfqyhk(Byte sfqyhk) {
        this.sfqyhk = sfqyhk;
    }

    /**
     * 获取户口迁转单位
     *
     * @return HKQZDW - 户口迁转单位
     */
    public String getHkqzdw() {
        return hkqzdw;
    }

    /**
     * 设置户口迁转单位
     *
     * @param hkqzdw 户口迁转单位
     */
    public void setHkqzdw(String hkqzdw) {
        this.hkqzdw = hkqzdw == null ? null : hkqzdw.trim();
    }

    /**
     * 获取户口迁转地址
     *
     * @return HKQZDZ - 户口迁转地址
     */
    public String getHkqzdz() {
        return hkqzdz;
    }

    /**
     * 设置户口迁转地址
     *
     * @param hkqzdz 户口迁转地址
     */
    public void setHkqzdz(String hkqzdz) {
        this.hkqzdz = hkqzdz == null ? null : hkqzdz.trim();
    }

    /**
     * 获取协议书编号
     *
     * @return XYSBH - 协议书编号
     */
    public String getXysbh() {
        return xysbh;
    }

    /**
     * 设置协议书编号
     *
     * @param xysbh 协议书编号
     */
    public void setXysbh(String xysbh) {
        this.xysbh = xysbh == null ? null : xysbh.trim();
    }

    /**
     * 获取上传就业协议书、劳动合同或其他工作证明材料
     *
     * @return JYXYZP - 上传就业协议书、劳动合同或其他工作证明材料
     */
    public String getJyxyzp() {
        return jyxyzp;
    }

    /**
     * 设置上传就业协议书、劳动合同或其他工作证明材料
     *
     * @param jyxyzp 上传就业协议书、劳动合同或其他工作证明材料
     */
    public void setJyxyzp(String jyxyzp) {
        this.jyxyzp = jyxyzp == null ? null : jyxyzp.trim();
    }

    /**
     * 获取升学院校
     *
     * @return SXYX - 升学院校
     */
    public String getSxyx() {
        return sxyx;
    }

    /**
     * 设置升学院校
     *
     * @param sxyx 升学院校
     */
    public void setSxyx(String sxyx) {
        this.sxyx = sxyx == null ? null : sxyx.trim();
    }

    /**
     * 获取升学院校代码
     *
     * @return SXYXDM - 升学院校代码
     */
    public String getSxyxdm() {
        return sxyxdm;
    }

    /**
     * 设置升学院校代码
     *
     * @param sxyxdm 升学院校代码
     */
    public void setSxyxdm(String sxyxdm) {
        this.sxyxdm = sxyxdm == null ? null : sxyxdm.trim();
    }

    /**
     * 获取升学专业
     *
     * @return SXZY - 升学专业
     */
    public String getSxzy() {
        return sxzy;
    }

    /**
     * 设置升学专业
     *
     * @param sxzy 升学专业
     */
    public void setSxzy(String sxzy) {
        this.sxzy = sxzy == null ? null : sxzy.trim();
    }

    /**
     * 获取升学专业代码
     *
     * @return SXZYDM - 升学专业代码
     */
    public String getSxzydm() {
        return sxzydm;
    }

    /**
     * 设置升学专业代码
     *
     * @param sxzydm 升学专业代码
     */
    public void setSxzydm(String sxzydm) {
        this.sxzydm = sxzydm == null ? null : sxzydm.trim();
    }

    /**
     * 获取升学学历
     *
     * @return SXXL - 升学学历
     */
    public String getSxxl() {
        return sxxl;
    }

    /**
     * 设置升学学历
     *
     * @param sxxl 升学学历
     */
    public void setSxxl(String sxxl) {
        this.sxxl = sxxl == null ? null : sxxl.trim();
    }

    /**
     * 获取升学学历代码
     *
     * @return SXXLDM - 升学学历代码
     */
    public String getSxxldm() {
        return sxxldm;
    }

    /**
     * 设置升学学历代码
     *
     * @param sxxldm 升学学历代码
     */
    public void setSxxldm(String sxxldm) {
        this.sxxldm = sxxldm == null ? null : sxxldm.trim();
    }

    /**
     * 获取报到证备注
     *
     * @return BDZBZ - 报到证备注
     */
    public String getBdzbz() {
        return bdzbz;
    }

    /**
     * 设置报到证备注
     *
     * @param bdzbz 报到证备注
     */
    public void setBdzbz(String bdzbz) {
        this.bdzbz = bdzbz == null ? null : bdzbz.trim();
    }

    /**
     * 获取出国出境名称
     *
     * @return CGCJMC - 出国出境名称
     */
    public String getCgcjmc() {
        return cgcjmc;
    }

    /**
     * 设置出国出境名称
     *
     * @param cgcjmc 出国出境名称
     */
    public void setCgcjmc(String cgcjmc) {
        this.cgcjmc = cgcjmc == null ? null : cgcjmc.trim();
    }

    /**
     * 获取基层就业类别
     *
     * @return JCJYLB - 基层就业类别
     */
    public String getJcjylb() {
        return jcjylb;
    }

    /**
     * 设置基层就业类别
     *
     * @param jcjylb 基层就业类别
     */
    public void setJcjylb(String jcjylb) {
        this.jcjylb = jcjylb == null ? null : jcjylb.trim();
    }

    /**
     * 获取基层就业类别代码
     *
     * @return JCJYLBDM - 基层就业类别代码
     */
    public String getJcjylbdm() {
        return jcjylbdm;
    }

    /**
     * 设置基层就业类别代码
     *
     * @param jcjylbdm 基层就业类别代码
     */
    public void setJcjylbdm(String jcjylbdm) {
        this.jcjylbdm = jcjylbdm == null ? null : jcjylbdm.trim();
    }

    /**
     * 获取就业状况
     *
     * @return JYZK - 就业状况
     */
    public String getJyzk() {
        return jyzk;
    }

    /**
     * 设置就业状况
     *
     * @param jyzk 就业状况
     */
    public void setJyzk(String jyzk) {
        this.jyzk = jyzk == null ? null : jyzk.trim();
    }

    /**
     * 获取就业状况代码
     *
     * @return JYZKDM - 就业状况代码
     */
    public String getJyzkdm() {
        return jyzkdm;
    }

    /**
     * 设置就业状况代码
     *
     * @param jyzkdm 就业状况代码
     */
    public void setJyzkdm(String jyzkdm) {
        this.jyzkdm = jyzkdm == null ? null : jyzkdm.trim();
    }

    /**
     * 获取就业材料类型
     *
     * @return JYCLLX - 就业材料类型
     */
    public String getJycllx() {
        return jycllx;
    }

    /**
     * 设置就业材料类型
     *
     * @param jycllx 就业材料类型
     */
    public void setJycllx(String jycllx) {
        this.jycllx = jycllx == null ? null : jycllx.trim();
    }

    /**
     * 获取就业材料类型代码
     *
     * @return JYCLLXDM - 就业材料类型代码
     */
    public String getJycllxdm() {
        return jycllxdm;
    }

    /**
     * 设置就业材料类型代码
     *
     * @param jycllxdm 就业材料类型代码
     */
    public void setJycllxdm(String jycllxdm) {
        this.jycllxdm = jycllxdm == null ? null : jycllxdm.trim();
    }

    /**
     * 获取未就业类别
     *
     * @return WJYLB - 未就业类别
     */
    public String getWjylb() {
        return wjylb;
    }

    /**
     * 设置未就业类别
     *
     * @param wjylb 未就业类别
     */
    public void setWjylb(String wjylb) {
        this.wjylb = wjylb == null ? null : wjylb.trim();
    }

    /**
     * 获取未就业类别代码
     *
     * @return WJYLBDM - 未就业类别代码
     */
    public String getWjylbdm() {
        return wjylbdm;
    }

    /**
     * 设置未就业类别代码
     *
     * @param wjylbdm 未就业类别代码
     */
    public void setWjylbdm(String wjylbdm) {
        this.wjylbdm = wjylbdm == null ? null : wjylbdm.trim();
    }

    /**
     * 获取反馈类别
     *
     * @return FKLB - 反馈类别
     */
    public String getFklb() {
        return fklb;
    }

    /**
     * 设置反馈类别
     *
     * @param fklb 反馈类别
     */
    public void setFklb(String fklb) {
        this.fklb = fklb == null ? null : fklb.trim();
    }

    /**
     * 获取反馈类别代码
     *
     * @return FKLBDM - 反馈类别代码
     */
    public String getFklbdm() {
        return fklbdm;
    }

    /**
     * 设置反馈类别代码
     *
     * @param fklbdm 反馈类别代码
     */
    public void setFklbdm(String fklbdm) {
        this.fklbdm = fklbdm == null ? null : fklbdm.trim();
    }

    /**
     * 获取薪资  （起薪转正后为（月薪 元））
     *
     * @return GZ_QXZZHW - 薪资  （起薪转正后为（月薪 元））
     */
    public Integer getGzQxzzhw() {
        return gzQxzzhw;
    }

    /**
     * 设置薪资  （起薪转正后为（月薪 元））
     *
     * @param gzQxzzhw 薪资  （起薪转正后为（月薪 元））
     */
    public void setGzQxzzhw(Integer gzQxzzhw) {
        this.gzQxzzhw = gzQxzzhw;
    }

    /**
     * 获取是否专业对口
     *
     * @return SFZYDK - 是否专业对口
     */
    public Byte getSfzydk() {
        return sfzydk;
    }

    /**
     * 设置是否专业对口
     *
     * @param sfzydk 是否专业对口
     */
    public void setSfzydk(Byte sfzydk) {
        this.sfzydk = sfzydk;
    }

    /**
     * 获取是否就业困难
     *
     * @return SFJYKN - 是否就业困难
     */
    public Byte getSfjykn() {
        return sfjykn;
    }

    /**
     * 设置是否就业困难
     *
     * @param sfjykn 是否就业困难
     */
    public void setSfjykn(Byte sfjykn) {
        this.sfjykn = sfjykn;
    }

    /**
     * 获取签约时间
     *
     * @return GZ_YPSJ - 签约时间
     */
    public String getGzYpsj() {
        return gzYpsj;
    }

    /**
     * 设置签约时间
     *
     * @param gzYpsj 签约时间
     */
    public void setGzYpsj(String gzYpsj) {
        this.gzYpsj = gzYpsj == null ? null : gzYpsj.trim();
    }

    /**
     * 获取医疗企业单位分类
     *
     * @return YLQYDWFL - 医疗企业单位分类
     */
    public String getYlqydwfl() {
        return ylqydwfl;
    }

    /**
     * 设置医疗企业单位分类
     *
     * @param ylqydwfl 医疗企业单位分类
     */
    public void setYlqydwfl(String ylqydwfl) {
        this.ylqydwfl = ylqydwfl == null ? null : ylqydwfl.trim();
    }

    /**
     * 获取医疗事业单位分类
     *
     * @return YLSYDWFL - 医疗事业单位分类
     */
    public String getYlsydwfl() {
        return ylsydwfl;
    }

    /**
     * 设置医疗事业单位分类
     *
     * @param ylsydwfl 医疗事业单位分类
     */
    public void setYlsydwfl(String ylsydwfl) {
        this.ylsydwfl = ylsydwfl == null ? null : ylsydwfl.trim();
    }

    /**
     * 获取单位隶属部门
     *
     * @return DWLSBM - 单位隶属部门
     */
    public String getDwlsbm() {
        return dwlsbm;
    }

    /**
     * 设置单位隶属部门
     *
     * @param dwlsbm 单位隶属部门
     */
    public void setDwlsbm(String dwlsbm) {
        this.dwlsbm = dwlsbm == null ? null : dwlsbm.trim();
    }

    /**
     * 获取单位联系部门
     *
     * @return DWLXBM - 单位联系部门
     */
    public String getDwlxbm() {
        return dwlxbm;
    }

    /**
     * 设置单位联系部门
     *
     * @param dwlxbm 单位联系部门
     */
    public void setDwlxbm(String dwlxbm) {
        this.dwlxbm = dwlxbm == null ? null : dwlxbm.trim();
    }

    /**
     * 获取单位所有制性质
     *
     * @return DWSYZXZ - 单位所有制性质
     */
    public String getDwsyzxz() {
        return dwsyzxz;
    }

    /**
     * 设置单位所有制性质
     *
     * @param dwsyzxz 单位所有制性质
     */
    public void setDwsyzxz(String dwsyzxz) {
        this.dwsyzxz = dwsyzxz == null ? null : dwsyzxz.trim();
    }

    /**
     * 获取报到证毕字号
     *
     * @return BDZ_BZH - 报到证毕字号
     */
    public String getBdzBzh() {
        return bdzBzh;
    }

    /**
     * 设置报到证毕字号
     *
     * @param bdzBzh 报到证毕字号
     */
    public void setBdzBzh(String bdzBzh) {
        this.bdzBzh = bdzBzh == null ? null : bdzBzh.trim();
    }

    /**
     * 获取报到证编号前缀
     *
     * @return BDZBH_QZ - 报到证编号前缀
     */
    public String getBdzbhQz() {
        return bdzbhQz;
    }

    /**
     * 设置报到证编号前缀
     *
     * @param bdzbhQz 报到证编号前缀
     */
    public void setBdzbhQz(String bdzbhQz) {
        this.bdzbhQz = bdzbhQz == null ? null : bdzbhQz.trim();
    }

    /**
     * 获取报到证编号后缀
     *
     * @return BDZBH_HZ - 报到证编号后缀
     */
    public String getBdzbhHz() {
        return bdzbhHz;
    }

    /**
     * 设置报到证编号后缀
     *
     * @param bdzbhHz 报到证编号后缀
     */
    public void setBdzbhHz(String bdzbhHz) {
        this.bdzbhHz = bdzbhHz == null ? null : bdzbhHz.trim();
    }

    /**
     * 获取报到证档案材料
     *
     * @return BDZ_DACL - 报到证档案材料
     */
    public String getBdzDacl() {
        return bdzDacl;
    }

    /**
     * 设置报到证档案材料
     *
     * @param bdzDacl 报到证档案材料
     */
    public void setBdzDacl(String bdzDacl) {
        this.bdzDacl = bdzDacl == null ? null : bdzDacl.trim();
    }

    /**
     * 获取扩展字段1
     *
     * @return JY_KZZD1 - 扩展字段1
     */
    public String getJyKzzd1() {
        return jyKzzd1;
    }

    /**
     * 设置扩展字段1
     *
     * @param jyKzzd1 扩展字段1
     */
    public void setJyKzzd1(String jyKzzd1) {
        this.jyKzzd1 = jyKzzd1 == null ? null : jyKzzd1.trim();
    }

    /**
     * 获取扩展字段2
     *
     * @return JY_KZZD2 - 扩展字段2
     */
    public String getJyKzzd2() {
        return jyKzzd2;
    }

    /**
     * 设置扩展字段2
     *
     * @param jyKzzd2 扩展字段2
     */
    public void setJyKzzd2(String jyKzzd2) {
        this.jyKzzd2 = jyKzzd2 == null ? null : jyKzzd2.trim();
    }

    /**
     * 获取扩展字段3
     *
     * @return JY_KZZD3 - 扩展字段3
     */
    public String getJyKzzd3() {
        return jyKzzd3;
    }

    /**
     * 设置扩展字段3
     *
     * @param jyKzzd3 扩展字段3
     */
    public void setJyKzzd3(String jyKzzd3) {
        this.jyKzzd3 = jyKzzd3 == null ? null : jyKzzd3.trim();
    }

    /**
     * 获取扩展字段4
     *
     * @return JY_KZZD4 - 扩展字段4
     */
    public String getJyKzzd4() {
        return jyKzzd4;
    }

    /**
     * 设置扩展字段4
     *
     * @param jyKzzd4 扩展字段4
     */
    public void setJyKzzd4(String jyKzzd4) {
        this.jyKzzd4 = jyKzzd4 == null ? null : jyKzzd4.trim();
    }

    /**
     * 获取扩展字段5
     *
     * @return JY_KZZD5 - 扩展字段5
     */
    public String getJyKzzd5() {
        return jyKzzd5;
    }

    /**
     * 设置扩展字段5
     *
     * @param jyKzzd5 扩展字段5
     */
    public void setJyKzzd5(String jyKzzd5) {
        this.jyKzzd5 = jyKzzd5 == null ? null : jyKzzd5.trim();
    }

    /**
     * 获取扩展字段6
     *
     * @return JY_KZZD6 - 扩展字段6
     */
    public String getJyKzzd6() {
        return jyKzzd6;
    }

    /**
     * 设置扩展字段6
     *
     * @param jyKzzd6 扩展字段6
     */
    public void setJyKzzd6(String jyKzzd6) {
        this.jyKzzd6 = jyKzzd6 == null ? null : jyKzzd6.trim();
    }

    /**
     * 获取扩展字段7
     *
     * @return JY_KZZD7 - 扩展字段7
     */
    public String getJyKzzd7() {
        return jyKzzd7;
    }

    /**
     * 设置扩展字段7
     *
     * @param jyKzzd7 扩展字段7
     */
    public void setJyKzzd7(String jyKzzd7) {
        this.jyKzzd7 = jyKzzd7 == null ? null : jyKzzd7.trim();
    }

    /**
     * 获取扩展字段8
     *
     * @return JY_KZZD8 - 扩展字段8
     */
    public String getJyKzzd8() {
        return jyKzzd8;
    }

    /**
     * 设置扩展字段8
     *
     * @param jyKzzd8 扩展字段8
     */
    public void setJyKzzd8(String jyKzzd8) {
        this.jyKzzd8 = jyKzzd8 == null ? null : jyKzzd8.trim();
    }

    /**
     * 获取核验是否改动
     *
     * @return CHECK_UPDATE - 核验是否改动
     */
    public Byte getCheckUpdate() {
        return checkUpdate;
    }

    /**
     * 设置核验是否改动
     *
     * @param checkUpdate 核验是否改动
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
     * 获取创建者ID
     *
     * @return CREATOR_ID - 创建者ID
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建者ID
     *
     * @param creatorId 创建者ID
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