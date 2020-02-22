package com.ecotourism.api.api.controller;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.api.util.ApiUtils;
import com.ecotourism.api.application.domain.ApplicationDO;
import com.ecotourism.api.application.service.ApplicationService;
import com.ecotourism.api.common.utils.R;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

@Controller
@RequestMapping(value="/app/clientHelper")
public class ClientRedirectForwardController{
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    private ApplicationService applicationService;

    /**接收参数名密文种子**/
    private final String SEED_PARAM = "sign";
    private final String VERSION = "v1";

    /**
     * @Description 请求转向
     * @Author scotte
     * @Date 2018/8/29 14:34
     * @Param
     * @return
     */
    @RequestMapping(value = "/{pathUrl}",produces="application/json; charset=utf-8",method = RequestMethod.POST)
    @CrossOrigin
    public String pathReturn(@PathVariable String pathUrl,RequestVo requestVo)
    {
        String validateAuthorization = validateApplyAuthorization(requestVo);
        if(!"success".equals(validateAuthorization)) return "forward:error?msg="+validateAuthorization;
        setRequestParams(requestVo);
        return "forward:"+VERSION+"/"+pathUrl;
    }
    /**
     * @Description 页面跳转接口
     * @Author scotte
     * @Date 2018/8/29 14:34
     * @Param
     * @return
     */
    @RequestMapping(value = "/returnView/{pathUrl}",produces="application/json; charset=utf-8",method = RequestMethod.GET)
    @CrossOrigin
    public String returnView(@PathVariable String pathUrl,RequestVo requestVo)
    {
        String validateAuthorization = validateApplyAuthorization(requestVo);
        if(!"success".equals(validateAuthorization)) return "forward:error?msg="+validateAuthorization;
        requestVo.setData(ApiUtils.getRequestGetParams(request));
        setRequestParams(requestVo);
        return "forward:/app/clientHelper/"+VERSION+"/returnView/"+pathUrl;
    }
    /**
     * @Description 通知地址
     * @Author scotte
     * @Date 2018/8/29 14:34
     * @Param
     * @return
     */
    @RequestMapping(value = "/payNotice/{pathUrl}")
    @CrossOrigin
    public String payNotice(@PathVariable String pathUrl){
        RequestVo requestVo = new RequestVo();
        requestVo.setRequest(request);
        requestVo.setApiVersion(VERSION);
        requestVo.setApiUrl(request.getServletPath());
        requestVo.setCreateTimeStamp(System.currentTimeMillis());
        setRequestParams(requestVo);
        return "forward:/app/clientHelper/"+VERSION+"/payNotice/"+pathUrl;
    }


    @RequestMapping(value = "/error",produces="application/json; charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    private String errorMsg(String msg)
    {
        return msg;
    }
    private void setRequestParams(RequestVo requestVo){
        request.setAttribute("requestVo", requestVo);

    }
    /**
     * 验证权限方法
     * @return
     */
    private String validateApplyAuthorization(RequestVo requestVo){
        requestVo.setRequest(request);
        //String seed = request.getParameter(SEED_PARAM);
        String applicationNo = requestVo.getApplicationNo();
        //requestVo.setAppKey(seed);
        if(StringUtils.isBlank(applicationNo)) return ApiUtils.getError(ApiEnum.appNoNull.code,ApiEnum.appNoNull.msg);
        requestVo.setApiVersion(VERSION);
        //requestVo.setIP(IPUtils.getIpAddr(request));
        requestVo.setApiUrl(request.getServletPath());
        requestVo.setCreateTimeStamp(System.currentTimeMillis());
        try {
            BufferedReader br = request.getReader();
            String datatemp = "";
            String data = "";
            while((datatemp=br.readLine())!=null)
                data += datatemp;
            requestVo.setData(data);
            R r = applicationService.getApplication(applicationNo);
            if(!R.SUCCESS.equals(r.getReturn_code())) return ApiUtils.getError(r.getReturn_code(),r.getReturn_msg());
            ApplicationDO application = (ApplicationDO) r.getObj();
            requestVo.setApplicationDO(application);
			/*String signdata = application.getUserNo()+application.getAppId()+application.getAppKey();
			String sign = MD5.md5(signdata+data);
			if(!sign.equals(seed))return ApiUtils.getError(ApiEnum.signError.code,ApiEnum.signError.msg);*/
            return "success";
        }catch (Exception e) {
            String message = ApiUtils.getExceptionString(e);
            ApiUtils.saveException(requestVo,message);
            return ApiUtils.getError(ApiEnum.systemError.code, ApiEnum.systemError.msg);
        }
    }

}
