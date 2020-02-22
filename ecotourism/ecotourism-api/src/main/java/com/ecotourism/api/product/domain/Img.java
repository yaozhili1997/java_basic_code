package com.ecotourism.api.product.domain;

/**
 * 说明：图片
 * 创建人：陈启勇
 * 创建时间: 2018/8/29 14:57
 **/
public class Img {
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Img{" +
                "imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
