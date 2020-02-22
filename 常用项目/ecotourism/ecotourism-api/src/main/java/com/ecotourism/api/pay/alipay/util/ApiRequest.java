package com.ecotourism.api.pay.alipay.util;

import org.apache.commons.httpclient.NameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ApiRequest {
	private String uri;
	private Map<String, String> params;
	public ApiRequest() {
	}
	public ApiRequest(String uri, Map<String, String> params) {
		this.uri = uri;
		this.params = params;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public NameValuePair[] getParams() {
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		if(params != null) {
			Set<String> keys = params.keySet();
			for(String key : keys) {
				Object value = params.get(key);
				if(value != null) {
					NameValuePair pair = new NameValuePair(key, value.toString());
					pairs.add(pair);
				}
			}
		}
		return pairs.toArray(new NameValuePair[pairs.size()]);
	}
	public void setParams(Map<String, String> params) {
		this.params = params;
	}
}
