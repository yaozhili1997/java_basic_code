package com.ecotourism.oms.oms.controller.v1;

import com.ecotourism.oms.common.controller.BaseController;
import com.ecotourism.oms.common.exception.MyException;
import com.ecotourism.oms.oms.config.ApiEnum;
import com.ecotourism.oms.oms.domain.RequestVo;
import com.ecotourism.oms.oms.service.ModifyOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.ecotourism.oms.oms.util.Error.getError;

@Controller
public class ModifyOrderV1Controller extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(ModifyOrderV1Controller.class);
    @Autowired
    ModifyOrderService modifyOrderService;
    /**
     * 修改订单接口
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/app/clientHelper/v1/modifyOrder",produces="application/json; charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public String modifyOrder()
    {
        try
        {
            long now = System.currentTimeMillis();
            RequestVo requestVo =  (RequestVo)request.getAttribute("requestVo");
            String updateOrder = modifyOrderService.modifyOrder(requestVo);
            logger.debug("修改订单接口返回信息==>"+updateOrder);
            logger.debug("修改订单接口，损耗时间==> "+(System.currentTimeMillis()-now));
            return updateOrder;
        }catch(MyException m){
            logger.debug(m.getMessage());
            return m.getMessage();
        }catch(Exception e)
        {
            e.printStackTrace();
            return getError(ApiEnum.systemError.code, ApiEnum.systemError.msg);
        }
    }
}
