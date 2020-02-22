package com.ecotourism.api.pay.wechat.domain;

/**
 * 说明：微信支付服务商
 * 作者： scotte
 * 创建时间：下午4:11:04
 */
public class WechatProvider {
	private String id;
	private String provider_no;
	private String provider_name;
	private String app_id;
	private String private_key;
	private String mch_id;
	private String cert_local_path;
	private String cert_password;
	private String bz;
	private String available;
	private String create_user;
	private String update_user;
	private String create_time;
	private String update_time;
	private String base_url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvider_no() {
		return provider_no;
	}

	public void setProvider_no(String provider_no) {
		this.provider_no = provider_no;
	}

	public String getProvider_name() {
		return provider_name;
	}

	public void setProvider_name(String provider_name) {
		this.provider_name = provider_name;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getPrivate_key() {
		return private_key;
	}

	public void setPrivate_key(String private_key) {
		this.private_key = private_key;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getCert_local_path() {
		return cert_local_path;
	}

	public void setCert_local_path(String cert_local_path) {
		this.cert_local_path = cert_local_path;
	}

	public String getCert_password() {
		return cert_password;
	}

	public void setCert_password(String cert_password) {
		this.cert_password = cert_password;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public String getUpdate_user() {
		return update_user;
	}
	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public String getBase_url() {
		return base_url;
	}
	public void setBase_url(String base_url) {
		this.base_url = base_url;
	}
}
