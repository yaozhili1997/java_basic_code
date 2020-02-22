package com.ecotourism.manage.sms.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 短信二维码图片保存路径
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
public class QrcodeFileDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//票号
	private String ticket;
	//文件路径
	private String path;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：票号
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	/**
	 * 获取：票号
	 */
	public String getTicket() {
		return ticket;
	}
	/**
	 * 设置：文件路径
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * 获取：文件路径
	 */
	public String getPath() {
		return path;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
