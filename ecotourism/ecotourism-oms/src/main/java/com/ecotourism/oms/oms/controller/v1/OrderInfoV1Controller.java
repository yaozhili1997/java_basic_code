package com.ecotourism.oms.oms.controller.v1;

import com.ecotourism.oms.common.controller.BaseController;
import com.ecotourism.oms.common.exception.MyException;
import com.ecotourism.oms.oms.config.ApiEnum;
import com.ecotourism.oms.oms.config.Const;
import com.ecotourism.oms.oms.domain.RequestVo;
import com.ecotourism.oms.oms.service.OrderInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.ecotourism.oms.oms.util.Error.getError;

@Controller
public class OrderInfoV1Controller extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(OrderInfoV1Controller.class);

    @Autowired
    OrderInfoService orderInfoService;
    /**
     * 获取订单信息接口
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/app/clientHelper/v1/getOrderStatus" ,produces="application/json; charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public String getOrderStatus()
    {
        try
        {
            long now = System.currentTimeMillis();
            RequestVo requestVo =  (RequestVo)request.getAttribute("requestVo");
            String orderStatus = orderInfoService.getOrderStatus(requestVo, Const.ORDER_OTA);
            logger.debug("获取订单信息接口，损耗时间==> "+(System.currentTimeMillis()-now));
            return orderStatus;
        }catch(MyException m){
            logger.debug(m.getMessage());
            return m.getMessage();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return getError(ApiEnum.systemError.code, ApiEnum.systemError.msg);
        }
    }

    /**
     * 查询订单信息接口
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/app/clientHelper/v1/queryOrder" ,produces="application/json; charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public String queryOrder()
    {
        try
        {
            long now = System.currentTimeMillis();
            RequestVo requestVo =  (RequestVo)request.getAttribute("requestVo");
            String order = orderInfoService.getOrder(requestVo, Const.ORDER_OTA);
            logger.debug("查询订单信息接口==>"+order);
            logger.debug("查询订单信息接口，损耗时间==> "+(System.currentTimeMillis()-now));
            return order;
        }catch(MyException m){
            logger.debug(m.getMessage());
            return m.getMessage();
        }catch(Exception e){
            e.printStackTrace();
            return getError(ApiEnum.systemError.code, ApiEnum.systemError.msg);
        }
    }
}
