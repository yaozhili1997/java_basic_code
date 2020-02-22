package com.ecotourism.oms.oms.service.impl;

import com.ecotourism.oms.oms.dao.OrderRefundTicketDao;
import com.ecotourism.oms.oms.domain.OrderRefundTicketDO;
import com.ecotourism.oms.oms.domain.OrderSpotDO;
import com.ecotourism.oms.oms.domain.RefundOrderInfoDO;
import com.ecotourism.oms.oms.domain.RequestVo;
import com.ecotourism.oms.oms.service.OrderInfoService;
import com.ecotourism.oms.oms.service.OrderRefundTicketService;
import com.ecotourism.oms.oms.service.OrderSupplierLogService;
import com.ecotourism.oms.oms.service.SupplierApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class OrderRefundTicketServiceImpl implements OrderRefundTicketService {
	@Autowired
	private OrderRefundTicketDao orderRefundTicketDao;
	@Autowired
	OrderInfoService orderInfoService;
	@Autowired
	OrderSupplierLogService orderSupplierLogService;

	@Override
	public void saveRefundTicketLog(List<OrderSpotDO> list, RequestVo requestVo) {
		for(OrderSpotDO bean:list){
			OrderRefundTicketDO pd = new OrderRefundTicketDO();
			pd.setOrderNo(bean.getOrderNo());
			pd.setCustomerName(bean.getCustomerName());
			pd.setCustomerPhone(bean.getCustomerPhone());
			pd.setAppUser(bean.getCustomerName());
			pd.setAppTime(new Date());
			pd.setOrderQuantity(bean.getOrderQuantity());
			pd.setRefundAmount(bean.getRefundAmount());
			pd.setCounterFee(bean.getCounterFee().toString());
			String REVIEW_STATE ="013001";
			String REFUND_STATUS = bean.getRefundStatus();
			if("002003".equals(REFUND_STATUS)){
				REVIEW_STATE ="013002";
			}
			pd.setReviewState(REVIEW_STATE);
			pd.setRefundState(REFUND_STATUS);
			pd.setElectronicTicket(bean.getElectronicTicket());
			pd.setCreateUser(bean.getCustomerName());
			pd.setCreateTime(new Date());
			pd.setCompanyNo(requestVo.getCooperationDistributionDO().getCompanyNo());
			orderRefundTicketDao.save(pd);
		}
	}

	@Override
	public void refundTicked(List<OrderSpotDO> list, RequestVo requestVo) {
		for (OrderSpotDO order : list) {
			RefundOrderInfoDO refundOrderInfoDO = new RefundOrderInfoDO();
			refundOrderInfoDO.setOrderNo(order.getOrderNo());
			refundOrderInfoDO.setElectronicTicket(order.getElectronicTicket());
			refundOrderInfoDO = orderRefundTicketDao.queryRefundOrderByOrderNo(refundOrderInfoDO);
			if(refundOrderInfoDO != null){
				if("0".equals(refundOrderInfoDO.getIsSelf())){
					String serviceClass = refundOrderInfoDO.getServiceClass();
					SupplierApi supplierApi = null;
					try {
						supplierApi = (SupplierApi) Class.forName(serviceClass).newInstance();
						order = supplierApi.refundOrder(refundOrderInfoDO,order);
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}else{
					order.setRefundStatus("002003");
					order.setOrderStatus("004004");
					order.setRefundTime(new Date());
				}
			}else{
				order.setRefundStatus("002007");
				order.setOrderStatus("004009");
			}
			orderSupplierLogService.save(order);
			orderInfoService.refundOrder(order);//只修改退票状态和订单状态
		}
	}
}
