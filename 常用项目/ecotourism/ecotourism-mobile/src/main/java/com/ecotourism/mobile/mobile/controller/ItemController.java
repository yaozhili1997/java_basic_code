package com.ecotourism.mobile.mobile.controller;

import com.ecotourism.mobile.common.controller.BaseController;
import com.ecotourism.mobile.common.utils.R;
import com.ecotourism.mobile.mobile.domain.ProductCollectionDO;
import com.ecotourism.mobile.mobile.service.ProductCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item")
public class ItemController extends BaseController {

    @Autowired
    private ProductCollectionService productCollectionService;

    @RequestMapping("/list")
    public String list(String productType, String spotNo, Model model) {
        model.addAttribute("productType", productType);
        model.addAttribute("spotNo", spotNo);
        return "mobile/item_list";
    }

    @RequestMapping("/details/{productNo}")
    public String details(@PathVariable String productNo, Model model) {
        model.addAttribute("productNo", productNo);
        return "mobile/item_details";
    }

    @RequestMapping("/getProductCollection")
    @ResponseBody
    public R getProductCollection(String productNo) {
        R r = new R();
        ProductCollectionDO collection = productCollectionService.getProductCollectionByProductNo(getLoginOpenid(), productNo);
        r.put("collection", collection);
        return r;
    }

    @RequestMapping("/addCollection")
    @ResponseBody
    public R addCollection(String productNo) {
        productCollectionService.addCollection(getLoginOpenid(), productNo);
        return R.ok();
    }

    @RequestMapping("/deleteCollection")
    @ResponseBody
    public R deleteCollection(String productNo) {
        productCollectionService.deleteCollection(getLoginOpenid(), productNo);
        return R.ok();
    }

    @RequestMapping("/yearCard")
    public String yearCard() {
        return "mobile/year_card";
    }

}
