package com.ecotourism.oms.oms.domain;

import java.io.Serializable;
import java.util.List;


/**
 * 
 * 
 * @author 陈启勇
 * @email 1992lcg@163.com
 * @date 2018-06-05 19:39:45
 */
public class OmsApiDictionaryDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//接口编号
	private String apino;
	//地址
	private String apiurl;
	//接口说明
	private String apiexplain;
	//版本
	private String version;
	//分销商编号
	private String distributionNo;
	//是否可用
	private String enabled;
	//分销商编号
	private String distributionName;
	//角色
	private List<String> apinos;


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
	 * 设置：接口编号
	 */
	public void setApino(String apino) {
		this.apino = apino;
	}
	/**
	 * 获取：接口编号
	 */
	public String getApino() {
		return apino;
	}
	/**
	 * 设置：地址
	 */
	public void setApiurl(String apiurl) {
		this.apiurl = apiurl;
	}
	/**
	 * 获取：地址
	 */
	public String getApiurl() {
		return apiurl;
	}
	/**
	 * 设置：接口说明
	 */
	public void setApiexplain(String apiexplain) {
		this.apiexplain = apiexplain;
	}
	/**
	 * 获取：接口说明
	 */
	public String getApiexplain() {
		return apiexplain;
	}
	/**
	 * 设置：版本
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * 获取：版本
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * 设置：分销商编号
	 */
	public void setDistributionNo(String distributionNo) {
		this.distributionNo = distributionNo;
	}
	/**
	 * 获取：分销商编号
	 */
	public String getDistributionNo() {
		return distributionNo;
	}
	/**
	 * 设置：是否可用
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	/**
	 * 获取：是否可用
	 */
	public String getEnabled() {
		return enabled;
	}

	public String getDistributionName() {
		return distributionName;
	}

	public void setDistributionName(String distributionName) {
		this.distributionName = distributionName;
	}

	public List<String> getApinos() {
		return apinos;
	}

	public void setApinos(List<String> apinos) {
		this.apinos = apinos;
	}
}
