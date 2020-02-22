package com.ecotourism.oms.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {
	boolean notEmpty() default false;//默认可以为空
	String errorMsg() default "参数不能为空";//错误信息
	String fieldName() default "";//字段名
	boolean useOther() default false;//是否调用外部检测方法
	String otherClassName() default "";//外部bean名
	String otherMethodName() default "";//外部方法名
	boolean isEntity() default false;//字段是否为实体类
}
