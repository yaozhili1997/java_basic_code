package com.ecotourism.supplier.product.controller;

import com.ecotourism.supplier.common.controller.BaseController;
import com.ecotourism.supplier.common.utils.R;
import com.ecotourism.supplier.product.domain.ProductPriceStockDO;
import com.ecotourism.supplier.product.domain.SpotTicketDO;
import com.ecotourism.supplier.product.service.ProductPriceStockService;
import com.ecotourism.supplier.product.service.SpotTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 产品价格库存日历Controller
 */
@Controller
@RequestMapping("/product/productPriceStock")
public class ProductPriceStockController extends BaseController {
    @Autowired
    private SpotTicketService spotTicketService;
    @Autowired
    private ProductPriceStockService productPriceStockService;
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        SpotTicketDO spotTicket = spotTicketService.get(id);
        model.addAttribute("spotTicket", spotTicket);
        return "product/productPriceStock/edit";
    }

    @RequestMapping("/save")
    @ResponseBody
    public R save(String dates, ProductPriceStockDO params) {
        try {
            params.setUpdateTime(new Date());
            params.setUpdateUser(getUsername());
            productPriceStockService.saveProductPriceStock(params, dates);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
        return R.ok();
    }

    @RequestMapping("/getProductPriceStockByDates")
    @ResponseBody
    public R getProductPriceStock(String dates, String productNo) {
        try {
            List<ProductPriceStockDO> list = productPriceStockService.getProductPriceStockByDates(productNo, Arrays.asList(dates.split(",")));
            R r = new R();
            r.put("list", list);
            return r;
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    @RequestMapping("/deleteProductPriceStock")
    @ResponseBody
    public R deleteProductPriceStockByDates(String dates, String productNo) {
        try {
            productPriceStockService.deleteProductPriceStockByDates(productNo, Arrays.asList(dates.split(",")));
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }
}
