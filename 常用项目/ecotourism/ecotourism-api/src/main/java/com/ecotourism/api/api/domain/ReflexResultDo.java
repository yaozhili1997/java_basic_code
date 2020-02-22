package com.ecotourism.api.api.domain;

import com.ecotourism.api.common.annotation.ApiMgmt;
import com.ecotourism.api.common.utils.R;

/**
 * 说明：反射处理返回结果类型
 * 创建人：陈启勇
 * 创建时间: 2018/9/6 11:12
 **/
public class ReflexResultDo {
    private ApiMgmt annotation;
    private R r;

    public ApiMgmt getAnnotation() {
        return annotation;
    }

    public void setAnnotation(ApiMgmt annotation) {
        this.annotation = annotation;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }
}
