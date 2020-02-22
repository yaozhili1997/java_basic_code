package com.ecotourism.oms.oms.controller;

import com.ecotourism.oms.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/app/clientHelper")
public class ErrorCotroller extends BaseController {

    @RequestMapping(value = "/error",produces="application/json; charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    private String errorMsg(String msg)
    {
        return msg;
    }
}
