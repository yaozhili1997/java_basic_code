package com.ecotourism.oms.oms.controller.v1;

import com.ecotourism.oms.common.controller.BaseController;
import com.ecotourism.oms.common.exception.MyException;
import com.ecotourism.oms.oms.config.ApiEnum;
import com.ecotourism.oms.oms.config.Const;
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
public class RefundTicketV1Controller extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(RefundTicketV1Controller.class);

    @Autowired
    ModifyOrderService modifyOrderService;
    /**
     * 退票接口
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/app/clientHelper/v1/refundTicket",produces="application/json; charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public String refundTicket()
    {
        try
        {
            long now = System.currentTimeMillis();
            RequestVo requestVo =  (RequestVo)request.getAttribute("requestVo");
            String updateRefundOrder = modifyOrderService.refundOrder(requestVo, Const.ORDER_OTA);
            logger.debug("退票接口返回信息==>"+updateRefundOrder);
            logger.debug("退票接口，损耗时间==> "+(System.currentTimeMillis()-now));
            return updateRefundOrder;
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
