package com.ecotourism.api.pay.wechat.util.sdk;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ResourceBundle;

public class WXPayConfigImpl extends WXPayConfig{

    private byte[] certData;
    private static WXPayConfigImpl INSTANCE;
    private String mchId;
    private String appId;
    private String key;

    private WXPayConfigImpl(){

    }
    public WXPayConfigImpl(String mchId, String appId, String key,File file) throws Exception {
        this.mchId = mchId;
        this.appId = appId;
        this.key = key;
        if(file!=null && file.isFile() && file.exists()){
            InputStream certStream = new FileInputStream(file);
            this.certData = new byte[(int) file.length()];
            certStream.read(this.certData);
            certStream.close();
        }
    }

	public static WXPayConfigImpl getInstance(String spotName) throws Exception{
        if (INSTANCE == null) {
            synchronized (WXPayConfigImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WXPayConfigImpl();
                }
            }
        }
        return INSTANCE;
    }
 
    public String getAppID() {
    	return this.appId;
    }

    public String getMchID() {
    	return this.mchId;
    }

    public String getKey() {
    	return this.key;
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis;
        certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }


    public int getHttpConnectTimeoutMs() {
        return 2000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    IWXPayDomain getWXPayDomain() {
        return WXPayDomainSimpleImpl.instance();
    }

    public String getPrimaryDomain() {
        return "api.mch.weixin.qq.com";
    }

    public String getAlternateDomain() {
        return "api2.mch.weixin.qq.com";
    }

    public int getReportWorkerNum() {
        return 1;
    }

    public int getReportBatchSize() {
        return 2;
    }


    public static void main(String[] args) {
        File f = new File(WXPayConfigImpl.class.getResource("").getPath());
        File f1 = new File(f.getAbsolutePath());
        System.out.println(f1);
        

        ResourceBundle rb = ResourceBundle.getBundle("wxpay_config/jinsha/wxpay");
        System.out.println(rb.getString("wxpay.appid"));
    }
}
