package com.ecotourism.manage.inter.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * oms接口注册表
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-05 19:39:45
 */
public class OmsApiDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//接口编号
	private String apino;
	//接口名称
	private String apiname;
	//地址
	private String apiurl;
	//接口说明
	private String apiexplain;
	//版本
	private String version;
	//是否可用
	private int enabled;
	//
	private String createuser;
	//
	private Date creratetime;
	//
	private String updateuser;
	//
	private Date updatetime;

	private String isCheck;

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
	 * 设置：接口名称
	 */
	public void setApiname(String apiname) {
		this.apiname = apiname;
	}
	/**
	 * 获取：接口名称
	 */
	public String getApiname() {
		return apiname;
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
	 * 设置：是否可用
	 */
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	/**
	 * 获取：是否可用
	 */
	public int getEnabled() {
		return enabled;
	}
	/**
	 * 设置：
	 */
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
	/**
	 * 获取：
	 */
	public String getCreateuser() {
		return createuser;
	}
	/**
	 * 设置：
	 */
	public void setCreratetime(Date creratetime) {
		this.creratetime = creratetime;
	}
	/**
	 * 获取：
	 */
	public Date getCreratetime() {
		return creratetime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}
	/**
	 * 获取：
	 */
	public String getUpdateuser() {
		return updateuser;
	}
	/**
	 * 设置：
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdatetime() {
		return updatetime;
	}

	public String getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}
}
