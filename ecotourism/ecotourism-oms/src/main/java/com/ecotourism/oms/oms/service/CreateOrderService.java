package com.ecotourism.oms.oms.service;

import com.alibaba.fastjson.JSONObject;
import com.ecotourism.oms.common.utils.PageData;
import com.ecotourism.oms.oms.config.Const;
import com.ecotourism.oms.oms.config.ResultMsg;
import com.ecotourism.oms.oms.domain.CooperationDistributionDO;
import com.ecotourism.oms.oms.domain.OrderSpotDO;
import com.ecotourism.oms.oms.domain.RequestVo;
import com.ecotourism.oms.oms.domain.SpotTicketDO;
import com.ecotourism.oms.product.domain.PriceStockDO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface CreateOrderService {

   String createOrder(RequestVo requestVo, String type) throws Exception;

    /**
     * 下单：产品库存操作 (读写) ,下单后修改，修改前需检测
     * @param pro 产品数据
     * @param num 产品数量
     * @throws Exception
     */
    void updateOrderProductStock(SpotTicketDO pro, String num);

    void updateProductStock(SpotTicketDO pro, PriceStockDO priceStockDO, String num, Date playDate);
    /**
     * 是否可下单，规则检测
     * @return
     */
    ResultMsg orderCheck(JSONObject json, CooperationDistributionDO cooperationDistributionDO, String type) throws Exception;
    /**
     * 下单：购票扣款
     * @param orderNo
     * @param totalPrice
     * @return
     * @throws Exception
     */
    void updateCooFlow(CooperationDistributionDO cooperationDistributionDO, String orderNo, BigDecimal totalPrice);
    /**
     * 下单：发送短信
     * @param list 订单数据
     * @param rsp 分销商数据
     * @param data 请求数据
     */
    void orderSendSms(List<PageData> list, PageData rsp, JSONObject data);
    /**
     * 订单 转换成标准 插入
     * @param pd
     * @return
     */
    PageData buildOrderInsertInfo(PageData pd, String distributionNo, String version, PageData pro);
    /**
     * 组装 订单数据公共参数
     * @param data data数据
     * @return
     */
    OrderSpotDO getCreateCommonOrderPd(RequestVo requestVo, JSONObject data, String type);

    /**
     * 下单重复提交验证
     * @param requestVo
     * @return
     */
    ResultMsg checkRepeatSubmit(RequestVo requestVo);
    /**
     * 插入子产品订单
     * @param pd
     */
    void saveSecondOrder(OrderSpotDO pd, String type);

    String checkInsertOrder(RequestVo requestVo, String type)  throws Exception;
}
