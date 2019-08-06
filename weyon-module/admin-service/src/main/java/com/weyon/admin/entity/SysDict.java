package com.weyon.admin.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "tb_sys_dict")
public class SysDict implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 父ID 引用ID
     */
    @Column(name = "PID")
    private String pid;

    /**
     * 父集Name
     */
    @Column(name = "PNAME")
    private String pName;

    /**
     * 代码
     */
    @Excel(name = "代码")
    @Column(name = "CODE")
    private Integer code;

    /**
     * 名称
     */
    @Column(name = "NAME")
    @Excel(name = "名字")
    private String name;

    private static final long serialVersionUID = 1L;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取父ID 引用ID
     *
     * @return PID - 父ID 引用ID
     */
    public String getPid() {
        return pid;
    }

    /**
     * 设置父ID 引用ID
     *
     * @param pid 父ID 引用ID
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * 获取代码
     *
     * @return CODE - 代码
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置代码
     *
     * @param code 代码
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取名称
     *
     * @return NAME - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    /**
     * 获取名称
     *
     * @return PNAME - 名称
     */
    public String getpName() {
        return pName;
    }
    /**
     * 设置名称
     *
     * @param pName 名称
     */
    public void setpName(String pName) {
        this.pName = pName;
    }

    //在父id确定的情况下的比较
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof SysDict)
            return ((SysDict)obj).name.equals(this.name) && ((SysDict)obj).code.equals(this.code);
        return false;
    }
}
