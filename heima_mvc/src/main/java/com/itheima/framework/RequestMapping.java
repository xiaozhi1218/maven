package com.itheima.framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 包名:com.itheima.framework
 * @author Leevi
 * 日期2020-11-01  11:58
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    /**
     * 映射路径
     * @return
     */
    String value();
}
