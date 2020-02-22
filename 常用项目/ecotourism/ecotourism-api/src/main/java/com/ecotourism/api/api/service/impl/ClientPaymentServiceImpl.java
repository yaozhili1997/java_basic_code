package com.ecotourism.api.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.api.domain.pay.BuildPayRequestParams;
import com.ecotourism.api.api.domain.pay.PayBuildParams;
import com.ecotourism.api.api.service.ClientAlipayService;
import com.ecotourism.api.api.service.ClientPaymentService;
import com.ecotourism.api.api.service.ClientWechatService;
import com.ecotourism.api.api.util.DateUtil;
import com.ecotourism.api.application.domain.OrderDo;
import com.ecotourism.api.application.domain.OrderResult;
import com.ecotourism.api.application.service.ApplicationOrderService;
import com.ecotourism.api.common.utils.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 说明：支付服务类
 * 创建人：陈启勇
 * 创建时间: 2018/8/21 10:39
 **/
@Service
public class ClientPaymentServiceImpl implements ClientPaymentService {
    @Autowired
    private ClientWechatService clientWechatService;
    @Autowired
    private ClientAlipayService clientAlipayService;
    @Autowired
    private ApplicationOrderService applicationOrderService;

    private R checkPayParams(RequestVo requestVo){
        BuildPayRequestParams param = (BuildPayRequestParams) requestVo.getParamsVo();
        OrderResult order = applicationOrderService.getOrder(param.getOrderNo(),requestVo.getApplicationNo(),param.getOpenId(),null,null);
        if(order==null)return R.error(ApiEnum.orderNull.code,ApiEnum.orderNull.msg);
        List<OrderDo> orders = order.getOrders();
        if(orders==null || orders.size()==0)return R.error(ApiEnum.orderNull.code,ApiEnum.orderNull.msg);
        JSONObject jsonObject = new JSONObject();
        //String body = requestVo.getApplicationDO().getUserName()+"-"+order.getOrderNo();
        StringBuffer body = new StringBuffer();
        String payStatus = order.getPayStatus();
        if("005001".equals(payStatus))return R.error(ApiEnum.orderPayMoney.code,ApiEnum.orderPayMoney.msg);
        for (OrderDo orderDo : orders) {
            String playTime = orderDo.getPlayTime();
            long ptime = DateUtil.getsdfDayTime(playTime);
            long nowtime = DateUtil.getsdfDayTime(DateUtil.getDay());
            if(ptime<nowtime)return R.error(ApiEnum.orderOutTime.code,ApiEnum.orderOutTime.msg);
            JSONObject json = new JSONObject();
            String product_no = orderDo.getProductNo();
            String product_name = orderDo.getProductName();
            int orderQuantity = orderDo.getOrderQuantity();
            json.put("productName",product_name);
            json.put("orderQuantity",orderQuantity);
            json.put("payPrice",orderDo.getPayPrice());
            jsonObject.put(product_no,json);
            body.append(product_no+"+");
        }
        PayBuildParams payBuildParams = new PayBuildParams();
        BeanUtils.copyProperties(param,payBuildParams);
        payBuildParams.setBody(body.deleteCharAt(body.length() - 1).toString());
        payBuildParams.setJsonDetail(jsonObject.toJSONString());
        payBuildParams.setOrder(order);
        return R.ok(payBuildParams);
    }

    /**
     * @Description 创建微信支付
     * @Author scotte
     * @Date 2018/9/3 11:46
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    public R buildWechatResult(RequestVo requestVo){
        R r = checkPayParams(requestVo);
        if(!r.isSuccess()){
            return r;
        }
        PayBuildParams payBuildParams = (PayBuildParams) r.getObj();
        r = clientWechatService.buildWechatPayResult(payBuildParams,requestVo);
        return r;
    }
    /**
     * @Description 创建支付宝支付
     * @Author scotte
     * @Date 2018/9/3 11:46
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    public R buildAlipayResult(RequestVo requestVo){
        R r = checkPayParams(requestVo);
        if(!r.isSuccess()){
            return r;
        }
        PayBuildParams payBuildParams = (PayBuildParams) r.getObj();
        r =  clientAlipayService.buildAlipayPayResult(payBuildParams, requestVo);
        return r;
    }
}
