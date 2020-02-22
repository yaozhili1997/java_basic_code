package com.ecotourism.oms.oms.controller;

import com.ecotourism.oms.common.controller.BaseController;
import com.ecotourism.oms.oms.domain.RequestVo;
import com.ecotourism.oms.oms.service.ValidateAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/app/clientHelper")
public class CreateOrderController extends BaseController{

    @Autowired
    private ValidateAuthorizationService validateAuthorizationService;
    @RequestMapping(value = "/createOrder",produces="application/json; charset=utf-8",method = RequestMethod.POST)
    public String createOrder(RequestVo requestVo) {
        String validateAuthorization = validateAuthorizationService.validateAuthorization(requestVo,request);
        if(!"success".equals(validateAuthorization)) return "forward:error?msg="+validateAuthorization;
        setRequestParams(requestVo);
        return "forward:"+requestVo.getApiVersion()+"/createOrder";
    }

    /**
     * 创建自助设备订单信息接口
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/createSellOrder",produces="application/json; charset=utf-8",method = RequestMethod.POST)
    public String createSellOrder(RequestVo requestVo) {
        String validateAuthorization = validateAuthorizationService.validateAuthorization(requestVo,request);
        if(!"success".equals(validateAuthorization)) return "forward:error?msg="+validateAuthorization;
        setRequestParams(requestVo);
        return "forward:"+requestVo.getApiVersion()+"/createSellOrder";
    }

    /**
     * 检测是否可下单接口
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/checkCreateOrder",produces="application/json; charset=utf-8",method = RequestMethod.POST)
    public String checkCreateOrder(RequestVo requestVo) {
        String validateAuthorization = validateAuthorizationService.validateAuthorization(requestVo,request);
        if(!"success".equals(validateAuthorization)) return "forward:error?msg="+validateAuthorization;
        setRequestParams(requestVo);
        return "forward:"+requestVo.getApiVersion()+"/checkCreateOrder";
    }

}
