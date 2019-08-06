package com.weyon.framework.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.UndeclaredThrowableException;

/**
 * @author liuxu
 * @description 统一异常格式处理
 * @date 2019-07-26
 **/
@RestControllerAdvice
public class ControllerAdvice {

    private static final String DENIED_EXCEPTION = "不允许访问";

    /**
     * 定义公共异常处理方法，类似try catch
     * 但是try catch优先级更高
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ObjectResponse doError(Exception e){
        e.printStackTrace();
        if (DENIED_EXCEPTION.equals(e.getMessage())) {
            return ObjectResponse.custom(HttpStatus.FORBIDDEN.value(), "您无权限操作");
        }
        return ObjectResponse.fail(e.getMessage());
    }

    @ExceptionHandler(UndeclaredThrowableException.class)
    public ObjectResponse doUndeclaredThrowableException(Exception e){
        e.printStackTrace();
        return ObjectResponse.fail("服务达到阈值自动断开");
    }
}
