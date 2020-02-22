package com.ecotourism.supplier.img.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-30 10:40:19
 */
public class ImgDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String fileName;
	private String imgNo;//图片编号
	//图片路径
	private String imgUrl;
	//
	private Date createTime;
	//
	private String createUser;
	//所属公司
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
	 * 设置：图片编号
	 */
	public void setImgNo(String imgNo) {
		this.imgNo = imgNo;
	}
	/**
	 * 获取：图片编号
	 */
	public String getImgNo() {
		return imgNo;
	}
	/**
	 * 设置：图片路径
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	/**
	 * 获取：图片路径
	 */
	public String getImgUrl() {
		return imgUrl;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：所属公司
	 */
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	/**
	 * 获取：所属公司
	 */
	public String getCompanyNo() {
		return companyNo;
	}

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
