package com.ecotourism.api.common.annotation;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.config.ResponseType;
import com.ecotourism.api.api.domain.RequestVo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 接口管理注解
 * @Author scotte
 * @Date 2018/8/29 10:53
 * @Param
 * @return
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiMgmt {
	/**
	 * @Description 接口名称
	 */
	ApiEnum name();
	/**
	 * @Description 请求参数实体类
	 */
	Class params() default Void.class;
	/**
	 * @Description 是否重定向
	 */
	String responseType() default ResponseType.string;
	/**
	 * @Description 逻辑处理类
	 */
	Class serviceClassName() default Void.class;
	/**
	 * @Description 逻辑处理方法
	 */
	String serviceMethodName() default "";
	/**
	 * @Description 方法参数类型
	 */
	Class[] serviceParams() default {RequestVo.class};

}
