package com.ecotourism.manage.print.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-11-20 11:13:06
 */
public class PrintTemplateDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Date created;
	//
	private Date modified;
	//
	private String backgroundImage;
	//
	private String fid;
	//
	private Long fixLeft;
	//
	private Long fixTop;
	//
	private String height;
	//
	private String name;
	//
	private String picPath;
	//
	private String printer;
	//
	private String width;
	//
	private Integer backgroundHeight;
	//
	private Integer backgroundWidth;
	//
	private String fields;
	//
	private String fontFamily;
	//
	private Integer fontSize;
	//
	private Integer orderby;
	//
	private String spotNo;
	//分销商编号
	private String userNo;
	//
	private String status;

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
	 * 设置：
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * 获取：
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * 设置：
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}
	/**
	 * 获取：
	 */
	public Date getModified() {
		return modified;
	}
	/**
	 * 设置：
	 */
	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	/**
	 * 获取：
	 */
	public String getBackgroundImage() {
		return backgroundImage;
	}
	/**
	 * 设置：
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}
	/**
	 * 获取：
	 */
	public String getFid() {
		return fid;
	}
	/**
	 * 设置：
	 */
	public void setFixLeft(Long fixLeft) {
		this.fixLeft = fixLeft;
	}
	/**
	 * 获取：
	 */
	public Long getFixLeft() {
		return fixLeft;
	}
	/**
	 * 设置：
	 */
	public void setFixTop(Long fixTop) {
		this.fixTop = fixTop;
	}
	/**
	 * 获取：
	 */
	public Long getFixTop() {
		return fixTop;
	}
	/**
	 * 设置：
	 */
	public void setHeight(String height) {
		this.height = height;
	}
	/**
	 * 获取：
	 */
	public String getHeight() {
		return height;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	/**
	 * 获取：
	 */
	public String getPicPath() {
		return picPath;
	}
	/**
	 * 设置：
	 */
	public void setPrinter(String printer) {
		this.printer = printer;
	}
	/**
	 * 获取：
	 */
	public String getPrinter() {
		return printer;
	}
	/**
	 * 设置：
	 */
	public void setWidth(String width) {
		this.width = width;
	}
	/**
	 * 获取：
	 */
	public String getWidth() {
		return width;
	}

	public Integer getBackgroundHeight() {
		return backgroundHeight;
	}

	public void setBackgroundHeight(Integer backgroundHeight) {
		this.backgroundHeight = backgroundHeight;
	}

	public Integer getBackgroundWidth() {
		return backgroundWidth;
	}

	public void setBackgroundWidth(Integer backgroundWidth) {
		this.backgroundWidth = backgroundWidth;
	}

	/**
	 * 设置：
	 */
	public void setFields(String fields) {
		this.fields = fields;
	}
	/**
	 * 获取：
	 */
	public String getFields() {
		return fields;
	}

	public String getFontFamily() {
		return fontFamily;
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}

	public Integer getFontSize() {
		return fontSize;
	}

	public void setFontSize(Integer fontSize) {
		this.fontSize = fontSize;
	}

	/**
	 * 设置：
	 */
	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}
	/**
	 * 获取：
	 */
	public Integer getOrderby() {
		return orderby;
	}
	/**
	 * 设置：
	 */
	public void setSpotNo(String spotNo) {
		this.spotNo = spotNo;
	}
	/**
	 * 获取：
	 */
	public String getSpotNo() {
		return spotNo;
	}
	/**
	 * 设置：分销商编号
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	/**
	 * 获取：分销商编号
	 */
	public String getUserNo() {
		return userNo;
	}
	/**
	 * 设置：
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public String getStatus() {
		return status;
	}
}
