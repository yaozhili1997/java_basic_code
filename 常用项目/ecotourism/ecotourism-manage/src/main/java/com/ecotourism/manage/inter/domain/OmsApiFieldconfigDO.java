package com.ecotourism.manage.inter.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 接口字段配置信息，将数据库字段转换为标准输出
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-05 19:39:45
 */
public class OmsApiFieldconfigDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//接口编号
	private String apino;
	//输入或者输出
	private String transtype;
	//转换前数据库字段
	private String transbefore;
	//转换后显示字段
	private String transafter;
	//字段说明
	private String fieldexplain;
	//转换值sql,比如transbefore是编码，要转换成字典表中对应汉字,select c1 as name from t1 where c2  = ''{0}''  .
	private String formatsql;
	//数据验证方式
	private String validatestr;
	//接口版本
	private String apiversion;
	//
	private Date createdate;
	//
	private String createuser;
	//
	private Date modifydate;
	//
	private String modifyuser;

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
	 * 设置：输入或者输出
	 */
	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}
	/**
	 * 获取：输入或者输出
	 */
	public String getTranstype() {
		return transtype;
	}
	/**
	 * 设置：转换前数据库字段
	 */
	public void setTransbefore(String transbefore) {
		this.transbefore = transbefore;
	}
	/**
	 * 获取：转换前数据库字段
	 */
	public String getTransbefore() {
		return transbefore;
	}
	/**
	 * 设置：转换后显示字段
	 */
	public void setTransafter(String transafter) {
		this.transafter = transafter;
	}
	/**
	 * 获取：转换后显示字段
	 */
	public String getTransafter() {
		return transafter;
	}
	/**
	 * 设置：字段说明
	 */
	public void setFieldexplain(String fieldexplain) {
		this.fieldexplain = fieldexplain;
	}
	/**
	 * 获取：字段说明
	 */
	public String getFieldexplain() {
		return fieldexplain;
	}
	/**
	 * 设置：转换值sql,比如transbefore是编码，要转换成字典表中对应汉字,select c1 as name from t1 where c2  = ''{0}''  .
	 */
	public void setFormatsql(String formatsql) {
		this.formatsql = formatsql;
	}
	/**
	 * 获取：转换值sql,比如transbefore是编码，要转换成字典表中对应汉字,select c1 as name from t1 where c2  = ''{0}''  .
	 */
	public String getFormatsql() {
		return formatsql;
	}
	/**
	 * 设置：数据验证方式
	 */
	public void setValidatestr(String validatestr) {
		this.validatestr = validatestr;
	}
	/**
	 * 获取：数据验证方式
	 */
	public String getValidatestr() {
		return validatestr;
	}
	/**
	 * 设置：接口版本
	 */
	public void setApiversion(String apiversion) {
		this.apiversion = apiversion;
	}
	/**
	 * 获取：接口版本
	 */
	public String getApiversion() {
		return apiversion;
	}
	/**
	 * 设置：
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：
	 */
	public Date getCreatedate() {
		return createdate;
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
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
	/**
	 * 获取：
	 */
	public Date getModifydate() {
		return modifydate;
	}
	/**
	 * 设置：
	 */
	public void setModifyuser(String modifyuser) {
		this.modifyuser = modifyuser;
	}
	/**
	 * 获取：
	 */
	public String getModifyuser() {
		return modifyuser;
	}
}
