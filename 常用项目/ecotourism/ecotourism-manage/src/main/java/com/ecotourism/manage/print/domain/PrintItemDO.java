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
public class PrintItemDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//
	private Date created;
	//
	private Date modified;
	//
	private String code;
	//
	private String fields;
	//
	private String label;
	//
	private String name;
	//
	private String type;
	//
	private Integer classification;
	//
	private Integer height;
	//
	private Integer width;
	//
	private Integer orderby;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
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
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：
	 */
	public String getCode() {
		return code;
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
	/**
	 * 设置：
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * 获取：
	 */
	public String getLabel() {
		return label;
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
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setClassification(Integer classification) {
		this.classification = classification;
	}
	/**
	 * 获取：
	 */
	public Integer getClassification() {
		return classification;
	}
	/**
	 * 设置：
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}
	/**
	 * 获取：
	 */
	public Integer getHeight() {
		return height;
	}
	/**
	 * 设置：
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}
	/**
	 * 获取：
	 */
	public Integer getWidth() {
		return width;
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
}
