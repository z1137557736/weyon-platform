package com.weyon.framework.handler;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author liuxu
 * @description 分页参数封装类
 * @date 2019-05-23
 **/
@ApiModel("分页对象")
public class PageRequest implements Serializable {

    private static final long serialVersionUID = 8319845599502031646L;

    private Integer page;
    private Integer limit;
    private String params;

    @ApiModelProperty(value="页码", example="1", required=true)
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @ApiModelProperty(value="每页显示多少条", example="20", required=true)
    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public JSONObject getParams() {
        if(params != null) {
            return JSONObject.parseObject(params);
        }
        return new JSONObject();
    }
}
