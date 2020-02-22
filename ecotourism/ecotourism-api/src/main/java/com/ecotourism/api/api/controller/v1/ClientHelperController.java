package com.ecotourism.api.api.controller.v1;

import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.api.util.ReflexApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller("clientHelperControllerV1")
@RequestMapping(value="/app/clientHelper/v1")
public class ClientHelperController {
    @Autowired
    protected HttpServletRequest request;

    public RequestVo buildParams() {
        RequestVo requestVo = (RequestVo) request.getAttribute("requestVo");
        return requestVo;
    }

    /**
     * 动态接口
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{pathUrl}",produces="application/json; charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public void interfaceprocessing(@PathVariable String pathUrl,HttpServletResponse response){
        RequestVo requestVo =  buildParams();
        requestVo.setApi(pathUrl);
        requestVo.setResponse(response);
        ReflexApiUtil.buildApiResult(requestVo);
    }
    /**
     * 页面跳转接口
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/returnView/{pathUrl}",produces="application/json; charset=utf-8",method = RequestMethod.GET)
    @ResponseBody
    public void returnView(@PathVariable String pathUrl,HttpServletResponse response){
        RequestVo requestVo =  buildParams();
        requestVo.setApi("returnView/"+pathUrl);
        requestVo.setResponse(response);
        ReflexApiUtil.buildApiResult(requestVo);
    }
    /**
     * 动态通知接口
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/payNotice/{pathUrl}")
    @ResponseBody
    public void payNotice(@PathVariable String pathUrl,HttpServletResponse response){
        RequestVo requestVo =  buildParams();
        requestVo.setResponse(response);
        requestVo.setApi("payNotice/"+pathUrl);
        ReflexApiUtil.buildApiResult(requestVo);
    }
}
