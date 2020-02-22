package com.ecotourism.oms.oms.controller.v1;

import com.ecotourism.oms.common.controller.BaseController;
import com.ecotourism.oms.common.exception.MyException;
import com.ecotourism.oms.common.utils.PageData;
import com.ecotourism.oms.oms.config.ApiEnum;
import com.ecotourism.oms.oms.config.Const;
import com.ecotourism.oms.oms.domain.RequestVo;
import com.ecotourism.oms.oms.service.CreateOrderService;
import com.ecotourism.oms.oms.service.impl.ValidateAuthorizationServiceImpl;
import com.ecotourism.oms.oms.util.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CreateOrderV1Controller extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(CreateOrderV1Controller.class);
    @Autowired
    CreateOrderService createOrderService;
    /**
     * 创建订单信息接口
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/app/clientHelper/v1/createOrder",produces="application/json; charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public String createOrder(){
        try
        {
            long now = System.currentTimeMillis();
            RequestVo requestVo =  (RequestVo)request.getAttribute("requestVo");
            String insertOrder = createOrderService.createOrder(requestVo, Const.ORDER_OTA);
            logger.debug("创建订单信息接口返回信息==>"+insertOrder);
            logger.debug("创建订单信息接口，损耗时间==> "+(System.currentTimeMillis()-now));
            return insertOrder;
        }catch(MyException m){
            logger.debug(m.getMessage());
            return m.getMessage();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return Error.getError(ApiEnum.systemError.code, ApiEnum.systemError.msg);
        }
    }

    /**
     * 创建自助设备订单信息接口
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/app/clientHelper/v1/createSellOrder",produces="application/json; charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public String createSellOrder()
    {
        try
        {
            long now = System.currentTimeMillis();
            RequestVo requestVo =  (RequestVo)request.getAttribute("requestVo");
            String insertOrder = createOrderService.createOrder(requestVo,Const.ORDER_SELF);
            logger.debug("创建自助设备订单信息接口返回信息==>"+insertOrder);
            logger.debug("创建自助设备订单信息接口，损耗时间==> "+(System.currentTimeMillis()-now));
            return insertOrder;
        }catch(MyException m){
            logger.debug(m.getMessage());
            return m.getMessage();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return Error.getError(ApiEnum.systemError.code, ApiEnum.systemError.msg);
        }

    }

    /**
     * 检测是否可下单接口
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/app/clientHelper/v1/checkCreateOrder",produces="application/json; charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public String checkCreateOrder(){
        try
        {
            long now = System.currentTimeMillis();
            RequestVo requestVo =  (RequestVo)request.getAttribute("requestVo");
            String checkInsertOrder = createOrderService.checkInsertOrder(requestVo, Const.ORDER_OTA);
            logger.debug("检测是否可下单接口==>"+checkInsertOrder);
            logger.debug("检测是否可下单接口，损耗时间==> "+(System.currentTimeMillis()-now));
            return checkInsertOrder;
        }catch(MyException m){
            logger.debug(m.getMessage());
            return m.getMessage();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return Error.getError(ApiEnum.systemError.code, ApiEnum.systemError.msg);
        }

    }
}
