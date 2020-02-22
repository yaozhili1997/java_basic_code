package com.itheima.springboot_quick2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: 姚志立
 * @create: 2020-02-10 12:38
 **/
@Controller
@ConfigurationProperties(prefix = "person")
public class QuickController2 {
    private String name;
    private String age;
    private String addr;

    @ResponseBody
    @RequestMapping("/quick2")
    public String quick2() {
        //获取配置文件的信息

        return "name:" + name + ",age:" + age + ",addr:" + addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}