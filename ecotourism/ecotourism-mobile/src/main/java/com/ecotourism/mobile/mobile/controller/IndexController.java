package com.ecotourism.mobile.mobile.controller;

import com.ecotourism.mobile.common.controller.BaseController;
import com.ecotourism.mobile.common.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class IndexController extends BaseController {

    @RequestMapping({"/index", "/"})
    public String index() {
        setConfig();
        return "mobile/index";
    }

    @RequestMapping("/index/introduction")
    public String introduction() {
        setConfig();
        return "mobile/introduction";
    }



    @RequestMapping("/getServerTime")
    @ResponseBody
    public R getServerTime() {
        R r = new R();
        r.put("now", new Date());
        return r;
    }

}
