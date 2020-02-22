package com.ecotourism.oms.cancellation.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ecotourism.oms.cancellation.domain.UscCancellationDO;
import com.ecotourism.oms.cancellation.service.CancellationService;
import com.ecotourism.oms.common.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/cancellation")
public class CancellationController extends BaseController{

    @Autowired
    CancellationService cancellationService;
    /**
     * 优讯订单核销
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uscOrder",produces="application/json; charset=utf-8")
    @ResponseBody
    public String uscOrder() {
        String flag = "fail";
        try{
            InputStream inputStream = request.getInputStream();
            //建立接收流缓冲，准备处理
            StringBuffer requestBuffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            //读入流，并转换成字符串
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                requestBuffer.append(readLine);
            }
            reader.close();
            String  json = requestBuffer.toString();
            JSONObject j = JSONObject.parseObject(json);
            List<UscCancellationDO> list = JSON.parseArray(j.getString("data"),UscCancellationDO.class);
            System.out.println("=============="+json);
            flag = cancellationService.cancellationUscOrder(list);
            if(!"success".equals(flag)){
                flag = "fail";
            }
        } catch(Exception e){
            e.printStackTrace();
            flag = "fail";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",flag);
        return jsonObject.toString();
    }
}
