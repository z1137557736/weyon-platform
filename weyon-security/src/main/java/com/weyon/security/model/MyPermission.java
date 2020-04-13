package com.weyon.security.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liuxu
 * @description 系统权限实体类
 * @date 2019-05-21
 **/
@Data
public class MyPermission implements Serializable {

    private String id;

    private String pid;

    private String pname;

    private String name;

    private String icon;

    private String path;

    private Byte permissionType;

    private String permission;

    private Integer sort;

    private String creatorId;

    private String creator;

    private Date createDate;

    private Date updateDate;

    private String remark;

    private static final long serialVersionUID = 1L;

    private List<MyPermission> children;

}