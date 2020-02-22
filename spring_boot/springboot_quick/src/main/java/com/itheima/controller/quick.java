package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: 姚志立
 * @create: 2020-02-10 00:09
 **/
@Controller
public class quick {
    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        return "hass";
    }
}