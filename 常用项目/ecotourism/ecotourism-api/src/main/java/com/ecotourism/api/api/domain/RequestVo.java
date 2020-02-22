package com.ecotourism.api.api.domain;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.application.domain.ApplicationDO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestVo {
	private String applicationNo = "";
	private String appKey = "";
	private String secret = "";
	private String apiUrl = "";
	private ApplicationDO applicationDO;
	private String api = "";
	private String data = "";
	private String IP = "";
	private HttpServletRequest request;
	private ApiEnum apiEnum;
	private HttpServletResponse response;
	private Object paramsVo;
	private long createTimeStamp;
	/**分销商户所用接口版本**/
	private String apiVersion = "v1";

	public String getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(String userNo) {
		this.applicationNo = userNo;
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

	public ApplicationDO getApplicationDO() {
		return applicationDO;
	}
	public void setApplicationDO(ApplicationDO applicationDO) {
		this.applicationDO = applicationDO;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}
	public ApiEnum getApiEnum() {
		return apiEnum;
	}
	public void setApiEnum(ApiEnum apiEnum) {
		this.apiEnum = apiEnum;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Object getParamsVo() {
		return paramsVo;
	}

	public void setParamsVo(Object paramsVo) {
		this.paramsVo = paramsVo;
	}

	public long getCreateTimeStamp() {
		return createTimeStamp;
	}

	public void setCreateTimeStamp(long createTimeStamp) {
		this.createTimeStamp = createTimeStamp;
	}

	@Override
	public String toString() {
		return "RequestVo{" +
				"applicationNo='" + applicationNo + '\'' +
				", appKey='" + appKey + '\'' +
				", secret='" + secret + '\'' +
				", apiUrl='" + apiUrl + '\'' +
				", applicationDO=" + applicationDO +
				", api='" + api + '\'' +
				", data='" + data + '\'' +
				", IP='" + IP + '\'' +
				", request=" + request +
				", apiEnum=" + apiEnum +
				", response=" + response +
				", paramsVo=" + paramsVo +
				", createTimeStamp=" + createTimeStamp +
				", apiVersion='" + apiVersion + '\'' +
				'}';
	}
}
