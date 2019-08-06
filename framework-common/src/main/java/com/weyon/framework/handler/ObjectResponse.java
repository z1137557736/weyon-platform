package com.weyon.framework.handler;


import com.weyon.framework.constant.HttpStatus;

import java.io.Serializable;

/**
 * @author liuxu
 * @description 自定义接口返回对象
 * @date 2019-05-19
 **/
public class ObjectResponse implements Serializable {

    private static final long serialVersionUID = -5219516782738622623L;

    private static final String SUCCESS_TIP = "操作成功";

    private static final String FAIL_TIP = "操作失败";

    private Integer code;

    private Object data;

    private String msg;

    private ObjectResponse() {
    }

    private ObjectResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ObjectResponse(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ObjectResponse ok() {
        return new ObjectResponse(HttpStatus.SC_OK, SUCCESS_TIP);
    }

    public static ObjectResponse ok(String msg) {
        return new ObjectResponse(HttpStatus.SC_OK, msg);
    }

    public static ObjectResponse ok(Object data) {
        return new ObjectResponse(HttpStatus.SC_OK, SUCCESS_TIP, data);
    }

    public static ObjectResponse ok(Object data, String msg) {
        return new ObjectResponse(HttpStatus.SC_OK, msg, data);
    }

    public static ObjectResponse fail() {
        return new ObjectResponse(HttpStatus.SC_INTERNAL_SERVER_ERROR, FAIL_TIP);
    }

    public static ObjectResponse fail(String msg) {
        return new ObjectResponse(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static ObjectResponse custom(Integer code, String msg) {
        return new ObjectResponse(code, msg);
    }

    public static ObjectResponse custom(Integer code, Object data, String msg) {
        return new ObjectResponse(code, msg, data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
