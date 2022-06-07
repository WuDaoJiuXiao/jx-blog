package com.jiuxiao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义日志注解
 * @Author: 悟道九霄
 * @Date: 2022年06月07日 9:59
 * @Version: 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLogAnnotation {

    /** 操作类型名称 */
    String value() default "";
}
