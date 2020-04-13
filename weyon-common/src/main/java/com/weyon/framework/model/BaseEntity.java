package com.weyon.framework.model;

import java.io.Serializable;

/**
 * @author liuxu
 * @description 基类实体类
 * @date 2019-06-07
 **/
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 2363827396973966180L;

    private String creatorId;

    private String creator;

    private String orgId;

    private String orgName;

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
