package com.ecotourism.api.application.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;



/**
 * 应用首页轮播
 * @author 陈启勇
 * @date 2018-12-05 11:44:31
 */
public class IndexContentDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long cid;
	//标题
	private String title;
	//
	@JSONField(serialize = false)
	private String slug;
	//创建人id
	@JSONField(serialize = false)
	private Long created;
	//最近修改人id
	@JSONField(serialize = false)
	private Long modified;
	//内容
	@JSONField(serialize = false)
	private String content;
	//类型
	@JSONField(serialize = false)
	private String type;
	//标签
	@JSONField(serialize = false)
	private String tags;
	//分类
	@JSONField(serialize = false)
	private String categories;
	//
	@JSONField(serialize = false)
	private Integer hits;
	//评论数量
	@JSONField(serialize = false)
	private Integer commentsNum;
	//开启评论
	@JSONField(serialize = false)
	private Integer allowComment;
	//允许ping
	@JSONField(serialize = false)
	private Integer allowPing;
	//允许反馈
	@JSONField(serialize = false)
	private Integer allowFeed;
	//状态
	@JSONField(serialize = false)
	private Integer status;
	//作者
	@JSONField(serialize = false)
	private String author;
	//创建时间
	@JSONField(serialize = false)
	private Date gtmCreate;
	//修改时间
	@JSONField(serialize = false)
	private Date gtmModified;
	//图片路径
	private String imgUrl;
	private String jumpUrl;
	//所属应用
	@JSONField(serialize = false)
	private String belongApp;

	/**
	 * 设置：
	 */
	public void setCid(Long cid) {
		this.cid = cid;
	}
	/**
	 * 获取：
	 */
	public Long getCid() {
		return cid;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}
	/**
	 * 获取：
	 */
	public String getSlug() {
		return slug;
	}
	/**
	 * 设置：创建人id
	 */
	public void setCreated(Long created) {
		this.created = created;
	}
	/**
	 * 获取：创建人id
	 */
	public Long getCreated() {
		return created;
	}
	/**
	 * 设置：最近修改人id
	 */
	public void setModified(Long modified) {
		this.modified = modified;
	}
	/**
	 * 获取：最近修改人id
	 */
	public Long getModified() {
		return modified;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：标签
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}
	/**
	 * 获取：标签
	 */
	public String getTags() {
		return tags;
	}
	/**
	 * 设置：分类
	 */
	public void setCategories(String categories) {
		this.categories = categories;
	}
	/**
	 * 获取：分类
	 */
	public String getCategories() {
		return categories;
	}
	/**
	 * 设置：
	 */
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	/**
	 * 获取：
	 */
	public Integer getHits() {
		return hits;
	}
	/**
	 * 设置：评论数量
	 */
	public void setCommentsNum(Integer commentsNum) {
		this.commentsNum = commentsNum;
	}
	/**
	 * 获取：评论数量
	 */
	public Integer getCommentsNum() {
		return commentsNum;
	}
	/**
	 * 设置：开启评论
	 */
	public void setAllowComment(Integer allowComment) {
		this.allowComment = allowComment;
	}
	/**
	 * 获取：开启评论
	 */
	public Integer getAllowComment() {
		return allowComment;
	}
	/**
	 * 设置：允许ping
	 */
	public void setAllowPing(Integer allowPing) {
		this.allowPing = allowPing;
	}
	/**
	 * 获取：允许ping
	 */
	public Integer getAllowPing() {
		return allowPing;
	}
	/**
	 * 设置：允许反馈
	 */
	public void setAllowFeed(Integer allowFeed) {
		this.allowFeed = allowFeed;
	}
	/**
	 * 获取：允许反馈
	 */
	public Integer getAllowFeed() {
		return allowFeed;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：作者
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 获取：作者
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 设置：创建时间
	 */
	public void setGtmCreate(Date gtmCreate) {
		this.gtmCreate = gtmCreate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getGtmCreate() {
		return gtmCreate;
	}
	/**
	 * 设置：修改时间
	 */
	public void setGtmModified(Date gtmModified) {
		this.gtmModified = gtmModified;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getGtmModified() {
		return gtmModified;
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
	 * 设置：所属应用
	 */
	public void setBelongApp(String belongApp) {
		this.belongApp = belongApp;
	}
	/**
	 * 获取：所属应用
	 */
	public String getBelongApp() {
		return belongApp;
	}

	public String getJumpUrl() {
		return jumpUrl;
	}

	public void setJumpUrl(String jumpUrl) {
		this.jumpUrl = jumpUrl;
	}
}
