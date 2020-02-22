package com.ecotourism.oms.oms.controller.v1;

import com.ecotourism.oms.common.controller.BaseController;
import com.ecotourism.oms.common.exception.MyException;
import com.ecotourism.oms.oms.config.ApiEnum;
import com.ecotourism.oms.oms.domain.RequestVo;
import com.ecotourism.oms.oms.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.ecotourism.oms.oms.util.Error.getError;
@Controller
public class ProductsV1Controller extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(ProductsV1Controller.class);

    @Autowired
    ProductsService productsService;
    /**
     * 获取产品信息接口
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/app/clientHelper/v1/getProductsInfo",produces="application/json; charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public String getProductsInfo()
    {
        try
        {
            long now = System.currentTimeMillis();
            RequestVo requestVo =  (RequestVo)request.getAttribute("requestVo");
            String productsInfo = productsService.getProductsInfo(requestVo);
            logger.debug("获取产品信息接口，损耗时间==> "+(System.currentTimeMillis()-now));
            return productsInfo;
        }catch(MyException m){
            logger.debug(m.getMessage());
            return m.getMessage();
        }catch (Exception e)
        {
            e.printStackTrace();
            return getError(ApiEnum.systemError.code, ApiEnum.systemError.msg);
        }
    }
}
