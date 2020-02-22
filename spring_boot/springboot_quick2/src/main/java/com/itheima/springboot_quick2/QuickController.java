package com.itheima.springboot_quick2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: 姚志立
 * @create: 2020-02-10 12:38
 **/
@RestController
public class QuickController {
    @Value("${name}")
    private String name;
    @Value("${person.addr}")
    private String addr;

    @RequestMapping("/quick1")
    public String quick2() {
        //获取配置文件的信息

        return "name:" + name + ",addr:" + addr;
    }
}