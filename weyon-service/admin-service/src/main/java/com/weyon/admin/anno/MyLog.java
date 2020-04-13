package com.weyon.admin.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liuxu
 * @description 定义一个方法级别的@log注解
 * @date 2019-06-10
 **/
//标识该注解只能作用于类的方法前
@Target(ElementType.METHOD)
//说明该注解类的生命周期-程序运行期间
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {

    /**
     * 日志名称
     * @return
     */
    String value() default "";

    /**
     * 是否添加参数日志
     * @return
     */
    boolean param() default true;

    /**
     * 是否获取ip地址
     * @return
     */
    boolean request() default true;
}
