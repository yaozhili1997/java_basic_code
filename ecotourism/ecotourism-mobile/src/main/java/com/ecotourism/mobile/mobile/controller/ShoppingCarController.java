package com.ecotourism.mobile.mobile.controller;

import com.ecotourism.mobile.common.controller.BaseController;
import com.ecotourism.mobile.common.utils.DateUtil;
import com.ecotourism.mobile.common.utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCarController extends BaseController {

    @RequestMapping("")
    public String shoppingCart(Model model) {
        model.addAttribute("now", new Date());
        return "mobile/shopping_car";
    }
}
