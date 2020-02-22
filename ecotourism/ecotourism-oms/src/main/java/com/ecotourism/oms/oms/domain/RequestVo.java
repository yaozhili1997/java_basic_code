package com.ecotourism.oms.oms.domain;

public class RequestVo {
	private String cid = "";
	private String appKey = "";
	private String secret = "";
	private String apiUrl = "";

	private String data = "";
	private String IP = "";
	private CooperationDistributionDO cooperationDistributionDO;//分销商信息
	/**分销商户编码**/
	private String distributionNo = "";

	/**分销商户所用接口版本**/
	private String apiVersion = "";

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDistributionNo() {
		return distributionNo;
	}

	public void setDistributionNo(String distributionNo) {
		this.distributionNo = distributionNo;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String IP) {
		this.IP = IP;
	}
	public String getApiUrl() {
		return apiUrl;
	}
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public CooperationDistributionDO getCooperationDistributionDO() {
		return cooperationDistributionDO;
	}

	public void setCooperationDistributionDO(CooperationDistributionDO cooperationDistributionDO) {
		this.cooperationDistributionDO = cooperationDistributionDO;
	}

	@Override
	public String toString() {
		return "RequestVo{" +
				"cid='" + cid + '\'' +
				", appKey='" + appKey + '\'' +
				", secret='" + secret + '\'' +
				", apiUrl='" + apiUrl + '\'' +
				", data='" + data + '\'' +
				", IP='" + IP + '\'' +
				", cooperationDistributionDO=" + cooperationDistributionDO +
				", distributionNo='" + distributionNo + '\'' +
				", apiVersion='" + apiVersion + '\'' +
				'}';
	}
}
