package com.ecotourism.api.pay.wechat.util;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.util.ApiUtils;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.pay.wechat.domain.WechatConfig;
import com.ecotourism.api.pay.wechat.domain.pay.WechatParams;
import com.ecotourism.api.pay.wechat.domain.pay.WechatRefundParams;
import com.ecotourism.api.pay.wechat.domain.pay.WechatUserParams;
import com.ecotourism.api.pay.wechat.util.sdk.WXPay;
import com.ecotourism.api.pay.wechat.util.sdk.WXPayConfigImpl;
import com.ecotourism.api.pay.wechat.util.sdk.WXPayConstants;
import com.ecotourism.api.pay.wechat.util.sdk.WXPayUtil;
import com.ecotourism.api.payment.domain.PaymentWechatDO;
import org.apache.commons.lang.StringUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 说明：支付配置
 * 作者： scotte
 * 创建时间：下午3:50:25
 */
@Component
public class PayConfig {



	private static BeanCopier userCopy = BeanCopier.create(WechatUserParams.class, WechatParams.class, false);

	/**
	 * 组装微信统一支付参数
	 *
	 * @param wechatUserParams
	 * @return
	 * @throws Exception
	 */
	public static WechatParams getWechatPayParams(WechatUserParams wechatUserParams, PaymentWechatDO wechatDO){
		WechatParams wechatParams = new WechatParams();
		String openid = "";
		if (wechatUserParams != null) {
			openid = wechatUserParams.getOpenid();
			userCopy.copy(wechatUserParams, wechatParams, null);
			wechatParams.setOpenid(null);
			wechatParams.setSub_openid(null);
		}
		String appid = wechatUserParams.getParamAppid();//传入的appid
		if (StringUtils.isBlank(appid)) {
			appid = wechatDO.getAppId();
		}
		WechatConfig wechatConfig = wechatDO.getWechatConfig();
		if (wechatConfig.isProvider()) {
			wechatParams.setAppid(wechatConfig.getAppid());
			wechatParams.setMch_id(wechatConfig.getMuchId());
			wechatParams.setSub_appid(appid);
			wechatParams.setSub_openid(openid);
			wechatParams.setSub_mch_id(wechatConfig.getSubMchId());
		} else {
			wechatParams.setAppid(appid);
			wechatParams.setMch_id(wechatConfig.getMuchId());
			wechatParams.setOpenid(openid);
		}
		return wechatParams;
	}
	/**
	* 微信：统一支付
	* @author: scotte
	* @create: 2018/7/6 20:25
	**/
	public static R weChatUnifiedOrder(WechatParams param,PaymentWechatDO wechatConfig){
		String key = wechatConfig.getWechatConfig().getKey();
		WXPayConfigImpl wxPayConfig = null;
		WXPay wxPay = null;
		Map<String,String> map = WXPayUtil.ConvertObjToMap(param);
		try {
			wxPayConfig = new WXPayConfigImpl(param.getMch_id(), param.getAppid(),key,null);
			wxPay = new WXPay(wxPayConfig);
			map = wxPay.unifiedOrder(map);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error(ApiEnum.wechatPayError.code,e.getMessage()).setUseMsg(false);
		}
		String msg = "微信统一支付返回==>"+map;
		if(map==null) return R.error(ApiEnum.wechatPayError.code,msg).setUseMsg(false);
		Map<String, String> resultMap = new HashMap<>();
		if ("SUCCESS".equals(map.get("return_code")) && "SUCCESS".equals(map.get("result_code"))) {
			// 业务结果
			String prepay_id = map.get("prepay_id");// 返回的预付单信息
			resultMap.put("appId", map.get("appid"));
			resultMap.put("nonceStr", WXPayUtil.generateNonceStr());
			resultMap.put("package", "prepay_id=" + prepay_id);
			resultMap.put("timeStamp", WXPayUtil.getCurrentTimestamp()+"");
			resultMap.put("signType", WXPayConstants.MD5);
			// 再次签名
			String sign = null;
			try {
				sign = WXPayUtil.generateSignature(resultMap,key);
			} catch (Exception e) {
				return R.error(ApiEnum.wechatPayError.code,"微信支付签名异常==>"+e.getMessage()).setUseMsg(false);
			}
			resultMap.put("packageStr", prepay_id);
			resultMap.put("paySign", sign);
		}else{
			return R.error(ApiEnum.wechatPayError.code,msg).setUseMsg(false);
		}
		return R.ok(resultMap);
	}

	/**
	 * 组装微信退款参数并签名
	 *
	 * @param wechatRefundParams
	 * @return
	 * @throws Exception
	 */
	public  static WechatRefundParams getWechatRefundParams(WechatRefundParams wechatRefundParams,PaymentWechatDO wechatDO){
		WechatConfig wechatConfig = wechatDO.getWechatConfig();
		if (wechatRefundParams == null) {
			wechatRefundParams = new WechatRefundParams();
		}
		String appid = wechatDO.getAppId();
		if (wechatConfig.isProvider()) {
			wechatRefundParams.setAppid(wechatConfig.getAppid());
			wechatRefundParams.setMch_id(wechatConfig.getMuchId());
			wechatRefundParams.setSub_appid(appid);
			wechatRefundParams.setSub_mch_id(wechatConfig.getSubMchId());
		} else {
			wechatRefundParams.setAppid(appid);
			wechatRefundParams.setMch_id(wechatConfig.getMuchId());
		}
		return wechatRefundParams;
	}

	/**
	* 微信：申请退款
	* @author: scotte
	* @create: 2018/7/6 20:39
	**/
	public static R weChatRefund(WechatRefundParams param, PaymentWechatDO wechatConfig){
		String key = wechatConfig.getWechatConfig().getKey();
		WXPay wxPay = null;
		try {
			WXPayConfigImpl wxPayConfig = new WXPayConfigImpl(param.getMch_id(), param.getAppid(),key,getCert(wechatConfig));
			wxPay = new WXPay(wxPayConfig);
			Map<String,String> map = WXPayUtil.ConvertObjToMap(param);
			map = wxPay.refund(map);
			if (map!=null&&"SUCCESS".equals(map.get("return_code"))&& "SUCCESS".equals(map.get("result_code"))) {
				return R.ok();
			} else {
				return R.error(ApiEnum.OrderRefundMoneyError.code,map.toString()).setUseMsg(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return R.error(ApiEnum.OrderRefundMoneyError.code, ApiUtils.getExceptionString(e)).setUseMsg(false);
		}
	}

	private static final String certName = "apiclient_cert.p12";

	public static File getCert(PaymentWechatDO wechatConfig) throws IOException {
		WechatConfig weChatStaticConfig = wechatConfig.getWechatConfig();
		String certLocalPath = weChatStaticConfig.getCertLocalPath();
		String rootPath = new File("").getCanonicalPath();
		String filepath = rootPath + certLocalPath;
		File file = new File(filepath);
		if (!file.isFile()) {
			String base_url = weChatStaticConfig.getBase_url();
			if (StringUtils.isNotBlank(certLocalPath) && StringUtils.isNotBlank(weChatStaticConfig.getBase_url())) {
				File downLoadFromUrl = DownFromUrl.downLoadFromUrl(base_url + certLocalPath, certName, filepath.replace(certName, ""));
			}
		}
		return new File(filepath);
	}
}
