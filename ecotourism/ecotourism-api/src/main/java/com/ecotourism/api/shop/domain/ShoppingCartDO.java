package com.ecotourism.api.shop.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.ecotourism.api.api.domain.shop.car.ShopCarUserParam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 购物车表
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-09-17 10:50:11
 */
public class ShoppingCartDO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	//用户唯一id
	@JSONField(serialize = false)
	private String openId;
	//产品编号
	private String productNo;
	//产品名称
	private String productName;
	//产品图片
	private String productImg;
	//产品是否上架
	private String productWhetherShelves;
	//产品类型
	private String productType;
	//产品数量
	private String productNum;
	//产品单价
	private String productPrice;
	//游玩时间
	private String playTime;
	private List<ShoppingCartUserDO> users;
	//状态 1:正常，0：失效
	private String status;
	//顺序
	private String sort;
	//是否选中 1：选中，0：未选
	private Integer checked;
	@JSONField(serialize = false)
	private String createTime;
	@JSONField(serialize = false)
	private String updateTime;
	@JSONField(serialize = false)
	private String applicationNo;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：用户唯一id
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * 获取：用户唯一id
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * 设置：产品编号
	 */
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	/**
	 * 获取：产品编号
	 */
	public String getProductNo() {
		return productNo;
	}
	/**
	 * 设置：产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 获取：产品名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 设置：产品类型
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
	/**
	 * 获取：产品类型
	 */
	public String getProductType() {
		return productType;
	}
	/**
	 * 设置：产品数量
	 */
	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}
	/**
	 * 获取：产品数量
	 */
	public String getProductNum() {
		return productNum;
	}
	/**
	 * 设置：状态 1:正常，0：失效
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态 1:正常，0：失效
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：顺序
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	/**
	 * 获取：顺序
	 */
	public String getSort() {
		return sort;
	}
	/**
	 * 设置：是否选中 1：选中，0：未选
	 */
	public void setChecked(Integer checked) {
		this.checked = checked;
	}
	/**
	 * 获取：是否选中 1：选中，0：未选
	 */
	public Integer getChecked() {
		return checked;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getProductWhetherShelves() {
		return productWhetherShelves;
	}

	public void setProductWhetherShelves(String productWhetherShelves) {
		this.productWhetherShelves = productWhetherShelves;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public List<ShoppingCartUserDO> getUsers() {
		return users;
	}

	public void setUsers(List<ShoppingCartUserDO> users) {
		this.users = users;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}
}
