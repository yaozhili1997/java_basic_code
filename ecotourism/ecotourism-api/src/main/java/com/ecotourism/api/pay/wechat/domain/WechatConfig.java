package com.ecotourism.api.pay.wechat.domain;

/**
 * 说明：微信配置类
 * @author 陈启勇
 * 创建时间：2017年9月26日
 * @version
 */
public class WechatConfig {
//这个就是自己要保管好的私有Key了（切记只能放在自己的后台代码里，不能放在任何可能被看到源代码的客户端程序中）
	// 每次自己Post数据给API的时候都要用这个key来对所有字段进行签名，生成的签名会放在Sign这个字段，API收到Post数据的时候也会用同样的签名算法对Post过来的数据进行签名和验证
	// 收到API的返回的时候也要用这个key来对返回的数据算下签名，跟API的Sign数据进行比较，如果值不一致，有可能数据被第三方给篡改
	private  String key= "";
	//HTTPS证书的本地路径
	private  String certLocalPath;
	//HTTPS证书密码，默认密码等于商户号MCHID
	private  String certPassword;
	//是否使用异步线程的方式来上报API测速，默认为异步模式
	private  boolean useThreadToDoReport = true;
	private String base_url;
	private String appid;
	private String muchId;
	/**
	 * 微信支付分配的子商户号
	 */
	private String subMchId;
	private boolean provider=false;

	//机器IP
	private  String ip = "";

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCertLocalPath() {
		return certLocalPath;
	}

	public void setCertLocalPath(String certLocalPath) {
		this.certLocalPath = certLocalPath;
	}

	public String getCertPassword() {
		return certPassword;
	}

	public void setCertPassword(String certPassword) {
		this.certPassword = certPassword;
	}

	public boolean isUseThreadToDoReport() {
		return useThreadToDoReport;
	}

	public void setUseThreadToDoReport(boolean useThreadToDoReport) {
		this.useThreadToDoReport = useThreadToDoReport;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getBase_url() {
		return base_url;
	}

	public void setBase_url(String base_url) {
		this.base_url = base_url;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public boolean isProvider() {
		return provider;
	}

	public void setProvider(boolean provider) {
		this.provider = provider;
	}

    public String getMuchId() {
        return muchId;
    }

    public void setMuchId(String muchId) {
        this.muchId = muchId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }
    @Override
    public String toString() {
        return "WechatConfig{" +
                "key='" + key + '\'' +
                ", certLocalPath='" + certLocalPath + '\'' +
                ", certPassword='" + certPassword + '\'' +
                ", useThreadToDoReport=" + useThreadToDoReport +
                ", base_url='" + base_url + '\'' +
                ", appid='" + appid + '\'' +
                ", muchId='" + muchId + '\'' +
                ", subMchId='" + subMchId + '\'' +
                ", provider=" + provider +
                ", ip='" + ip + '\'' +
                '}';
    }
}
