package com.ecotourism.api.oms.domain;

import com.ecotourism.api.api.util.SignUtil;
import com.ecotourism.api.application.domain.DistributionDO;

/**
 * oms接口	常量
 * @author 陈启勇
 *
 */
public class OmsConstant {
	/**
	 * 检测是否可下单
	 */
	public static final String checkCreateOrder = "checkCreateOrder";
	/**
	 * 创建订单
	 */
	public static final String createOrder = "createOrder";
	/**
	 * 退订
	 */
	public static final String refundTicket = "refundTicket";
	/**
	 * 查询订单
	 */
	public static final String queryOrder = "queryOrder";
	/**
	 * 取消订单
	 */
	public static final String cancelOrder = "cancelOrder";
	/**
	 * 修改订单
	 */
	public static final String updateOrder = "updateOrder";
	/**
	 * 获取产品
	 */
	public static final String getProductsInfo = "getProductsInfo";
	
	public static String getOmsApi(DistributionDO distribution,String json,String api){
		String baseUrl = distribution.getBaseUrl();
		String whetherMoreEncode = distribution.getWhetherMoreEncode();
		String signdata = "";
		String cid = distribution.getDistributionNo();
		if("1".equals(whetherMoreEncode)){//启用动态加密
			signdata =cid+distribution.getAppId()+distribution.getAppSecret()+json;
		}else{
			signdata = cid+distribution.getAppId()+distribution.getAppSecret();
		}
		String sign = SignUtil.sign(signdata);
		return baseUrl+api+"?sign="+sign+"&cid="+cid;
	}
}
