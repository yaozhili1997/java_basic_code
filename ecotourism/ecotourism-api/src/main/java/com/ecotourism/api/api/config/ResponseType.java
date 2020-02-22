package com.ecotourism.api.api.config;

/**
 * 说明：response 返回类型
 * 创建人：陈启勇
 * 创建时间: 2018/9/6 11:37
 **/
public class ResponseType {
    public static final String string="string";//(返回成功或失败)=>默认返回R字符串（返回值R to json）
    public static final String redirect="redirect";//(返回成功)=>重定向(返回值R中obj)
    public static final String html="html";//(返回成功)=>返回html页面(返回值R中obj)
    public static final String RObj="RObj";//(返回成功或失败)=>返回(返回值R中obj)
    public static final String RObjSuccess="RObjSuccess";//(返回成功)=>返回(返回值R中obj)

}
