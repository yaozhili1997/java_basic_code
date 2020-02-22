package com.ecotourism.oms.oms.controller;

import com.ecotourism.oms.common.controller.BaseController;
import com.ecotourism.oms.oms.domain.RequestVo;
import com.ecotourism.oms.oms.service.ValidateAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/app/clientHelper")
public class CancelOrderController extends BaseController{
    @Autowired
    private ValidateAuthorizationService validateAuthorizationService;
    /**
     * 取消订单接口
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/cancelOrder",produces="application/json; charset=utf-8",method = RequestMethod.POST)
    public String cancelOrder(RequestVo requestVo) {
        String validateAuthorization = validateAuthorizationService.validateAuthorization(requestVo,request);
        if(!"success".equals(validateAuthorization)) return "forward:error?msg="+validateAuthorization;
        setRequestParams(requestVo);
        return "forward:"+requestVo.getApiVersion()+"/cancelOrder";
    }
}
