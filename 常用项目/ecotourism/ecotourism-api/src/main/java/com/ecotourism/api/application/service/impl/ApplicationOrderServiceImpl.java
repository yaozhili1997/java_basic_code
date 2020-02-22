package com.ecotourism.api.application.service.impl;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.domain.order.create.AddressParams;
import com.ecotourism.api.api.domain.order.notice.PayNoticeVo;
import com.ecotourism.api.api.domain.order.query.QueryOrderListRequestParams;
import com.ecotourism.api.api.util.ApiUtils;
import com.ecotourism.api.api.util.ReflexApiUtil;
import com.ecotourism.api.application.domain.OrderResult;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.oms.service.OmsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import com.ecotourism.api.application.dao.ApplicationOrderDao;
import com.ecotourism.api.application.domain.ApplicationOrderDO;
import com.ecotourism.api.application.service.ApplicationOrderService;



@Service
public class ApplicationOrderServiceImpl implements ApplicationOrderService{
	@Autowired
	private ApplicationOrderDao applicationOrderDao;
	@Autowired
	private OmsApiService omsApiService;

	@Override
	public int save(ApplicationOrderDO applicationOrder){
		return applicationOrderDao.save(applicationOrder);
	}
	@Override
	public int saveOrderAddress(AddressParams addressParams){
		return applicationOrderDao.saveOrderAddress(addressParams);
	}
	/**
	 * @Description 获取产品当月销量
	 * @author 陈启勇
	 * @Date 2019/3/8 12:18
	 * @Param [productNo]
	 * @return int
	 */
	@Override
	public int findOrderCountByProduct(String productNo){
		return applicationOrderDao.findOrderCountByProduct(productNo);
	}

	/**
	 * @Description 根据订单号修改订单支付状态为已支付
	 * @author 陈启勇
	 * @Date 2018/9/5 17:11
	 * @Param [orderNo]
	 * @return int
	 */
	@Override
	public int updatePayStatusSuccessByOrderNo(String orderNo,String payType,String applicationNo){
		return applicationOrderDao.updatePaySuccessByOrderNo(orderNo,payType,applicationNo);
	}
	/**
	 * @Description 从oms退单成功返回结果
	 * @author 陈启勇
	 * @Date 2018/9/7 17:12
	 * @Param [applicationOrder]
	 * @return int
	 */
	@Override
	public int updateOrderByOmsRefundResult(ApplicationOrderDO applicationOrder){
		return applicationOrderDao.updateOrderByOmsRefundResult(applicationOrder);
	}
	/**
	 * @Description 修改退款状态：退款失败
	 * @author 陈启勇
	 * @Date 2018/10/17 16:22
	 * @Param [applicationOrder]
	 * @return int
	 */
	@Override
	public int updateRefundStatusByRefundMoney(ApplicationOrderDO applicationOrder){
		return applicationOrderDao.updateRefundStatusByRefundMoney(applicationOrder);
	}

	/**
	 * @Description 查询订单列表，带分页
	 * @author 陈启勇
	 * @Date 2018/9/3 10:29
	 * @Param [param]
	 * @return java.util.List<com.ecotourism.api.application.domain.OrderResult>
	 */
	@Override
	public List<OrderResult> listOrdersResult(QueryOrderListRequestParams param){
		Integer pageNumber = param.getPageNumber();
		Integer pageSize = param.getPageSize();
		if(pageNumber!=null && pageSize!=null){
			int start = (pageNumber-1)*pageSize;
			param.setPageNumber(start);
		}
		return applicationOrderDao.listOrders(param);
	}
	/**
	 * @Description 通过订单号获取
	 * @author 陈启勇
	 * @Date 2018/9/3 11:13
	 * @Param [param]
	 * @return com.ecotourism.api.application.domain.OrderResult
	 */
	@Override
	public OrderResult getOrder(String orderNo,String applicationNo,String openId,String productNo,String subOrderNo){
		OrderResult byOrderNo = applicationOrderDao.getByOrderNo(orderNo,applicationNo,openId,productNo,subOrderNo);
		return byOrderNo;
	}
	/**
	 * @Description 通过订单号获取未支付订单
	 * @author 陈启勇
	 * @Date 2018/9/5 17:07
	 * @Param [orderNo]
	 * @return com.ecotourism.api.application.domain.OrderResult
	 */
	@Override
	public OrderResult getNotPayByOrderNo(String orderNo,String applicationNo){
		OrderResult byOrderNo = applicationOrderDao.getNotPayByOrderNo(orderNo,applicationNo);
		return byOrderNo;
	}

	/**
	 * @Description 支付成功,订单处理
	 * @author 陈启勇
	 * @Date 2018/8/24 11:02
	 * @Param [outTradeNo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	@Override
	public R updateOrderByPaySuccess(PayNoticeVo payNoticeVo){
		R r = ReflexApiUtil.checkByReflex(payNoticeVo);
		if(!R.SUCCESS.equals(r.getReturn_code())){
			return r;
		}
		OrderResult order = payNoticeVo.getOrder();
		BigDecimal total = order.getTotalAmount();
		if(total.multiply(new BigDecimal(100)).intValue() !=payNoticeVo.getTotalAmount()){
			return R.error(ApiEnum.NoticeMoneyError.code, ApiEnum.NoticeMoneyError.msg);
		}
		r = omsApiService.createOrder(order, payNoticeVo);
		if(!R.SUCCESS.equals(r.getReturn_code())){
			applicationOrderDao.updateOrderByCreateOmsOrderError(order.getOrderNo(),r.getStrObj(),payNoticeVo.getApp().getUserNo());
			return r;
		}
		List<ApplicationOrderDO> orders = (List<ApplicationOrderDO>) r.getObj();
		if(orders!=null && orders.size()>0){
			for (ApplicationOrderDO applicationOrderDO : orders) {
				applicationOrderDao.updateOrderByOmsResult(applicationOrderDO);
			}
		}
		return R.ok();
	}
	/**
	 * @Description 获取最近订单中的用户信息
	 * @author 陈启勇
	 * @Date 2018/9/7 14:12
	 * @Param [openId]
	 * @return com.ecotourism.api.application.domain.ApplicationOrderDO
	 */
	@Override
	public ApplicationOrderDO getOrderUserInfo(String openId){
		return applicationOrderDao.findUserInfo(openId);
	}

	/**
	 * @Description 获取不重复订单号
	 * @author 陈启勇
	 * @Date 2018/11/5 11:30
	 * @Param [applicationNo]
	 * @return java.lang.String
	 */
	@Override
	public String getOrderNo(String applicationNo){
		String orderNo = ApiUtils.getOrderNo();
		int orderCount = applicationOrderDao.findOrderCount(orderNo, applicationNo);
		if(orderCount>0){
			orderNo = getOrderNo(applicationNo);
		}
		return orderNo;
	}
}
