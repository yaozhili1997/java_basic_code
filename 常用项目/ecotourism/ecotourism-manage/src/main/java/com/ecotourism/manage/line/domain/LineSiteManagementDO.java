package com.ecotourism.manage.line.domain;

import java.io.Serializable;


/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-09 16:11:27
 */
public class LineSiteManagementDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//线路编号
	private String lineNo;
	//站点编号
	private String siteNo;
	//站点名称
	private String siteName;
	//gps编号
	private String gpsNo;
	//经度
	private String longitude;
	//纬度
	private String latitude;
	//站点类型
	private String siteType;
	//站点排序
	private Integer siteOrder;
	//是否可用
	private String whetherShelves;
	//公司编号
	private String companyNo;

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
	 * 设置：线路编号
	 */
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}
	/**
	 * 获取：线路编号
	 */
	public String getLineNo() {
		return lineNo;
	}
	/**
	 * 设置：站点编号
	 */
	public void setSiteNo(String siteNo) {
		this.siteNo = siteNo;
	}
	/**
	 * 获取：站点编号
	 */
	public String getSiteNo() {
		return siteNo;
	}
	/**
	 * 设置：站点名称
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	/**
	 * 获取：站点名称
	 */
	public String getSiteName() {
		return siteName;
	}
	/**
	 * 设置：gps编号
	 */
	public void setGpsNo(String gpsNo) {
		this.gpsNo = gpsNo;
	}
	/**
	 * 获取：gps编号
	 */
	public String getGpsNo() {
		return gpsNo;
	}
	/**
	 * 设置：经度
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：经度
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * 设置：纬度
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：纬度
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * 设置：站点类型
	 */
	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
	/**
	 * 获取：站点类型
	 */
	public String getSiteType() {
		return siteType;
	}
	/**
	 * 设置：站点排序
	 */
	public void setSiteOrder(Integer siteOrder) {
		this.siteOrder = siteOrder;
	}
	/**
	 * 获取：站点排序
	 */
	public Integer getSiteOrder() {
		return siteOrder;
	}
	/**
	 * 设置：是否可用
	 */
	public void setWhetherShelves(String whetherShelves) {
		this.whetherShelves = whetherShelves;
	}
	/**
	 * 获取：是否可用
	 */
	public String getWhetherShelves() {
		return whetherShelves;
	}
	/**
	 * 设置：公司编号
	 */
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	/**
	 * 获取：公司编号
	 */
	public String getCompanyNo() {
		return companyNo;
	}
}
