package com.ecotourism.api.api.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.api.exception.MyException;
import com.ecotourism.api.application.domain.ApplicationApiDetectionDO;
import com.ecotourism.api.application.domain.ApplicationDO;
import com.ecotourism.api.application.service.ApplicationApiDetectionService;
import com.ecotourism.api.common.config.ApplicationContextRegister;
import com.ecotourism.api.common.utils.MD5;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.common.utils.StringUtils;
import com.ecotourism.api.common.utils.Tools;
import com.ecotourism.api.exception.domain.ExceptionDO;
import com.ecotourism.api.exception.service.ExceptionService;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 说明：api 工具包
 * 创建人：陈启勇
 * 创建时间: 2018/8/20 16:05
 **/
public class ApiUtils {

    private static Map<String,String> enumCatchMap = new HashMap<String,String>();
    public static String getResultString(R r,RequestVo requestVo){
        String return_code = r.getReturn_code();
        String result = "";
        ApiEnum apiEnum = requestVo.getApiEnum();
        String msg ="";
        if(apiEnum !=null){
            msg = apiEnum.msg;
        }
        String batchNumber = "";
        if(R.SUCCESS.equals(return_code)){
            result = getOk(requestVo.getApplicationDO(),r.getObj());
        }else if(!ApiEnum.systemError.code.equals(return_code)){
            boolean useMsg = r.isUseMsg();
            result = r.getReturn_msg();
            if(!useMsg){
                batchNumber = saveException(requestVo, result);
                if (enumCatchMap.isEmpty()) {
                    ApiEnum[] values = ApiEnum.values();
                    for (ApiEnum value : values) {
                        enumCatchMap.put(value.code,value.msg);
                    }
                }
                result = enumCatchMap.get(return_code);
            }
            result = getError(return_code,result);
        }else{
            result = getError(return_code,r.getReturn_msg());
        }
        return result;
    }
    /**
     * @Description
     * @Author scotte
     * @Date 2018/8/29 20:32
     * @Param [e, requestVo, log]
     * @return java.lang.String
     */
    public static String buildExceptionResult(Throwable e,RequestVo requestVo){
        ApiEnum apiEnum = requestVo.getApiEnum();
        String msg ="";
        if(apiEnum !=null){
            msg = apiEnum.msg;
        }
        String message = e.getMessage();
        if(!(e instanceof MyException)){
            message = ApiUtils.getExceptionString(e);
            String batchNumber = ApiUtils.saveException(requestVo, message);
            message = ApiUtils.getError(ApiEnum.systemError.code, ApiEnum.systemError.msg);
        }
        return message;

    }
    /**
     * @Description 返回json转R对象
     * @Author scotte
     * @Date 2018/8/29 20:21
     * @Param [jsonResult]
     * @return com.ecotourism.api.common.utils.R
     */
    public static R convertStrToR(String jsonResult){
        JSONObject jsonObject = JSONObject.parseObject(jsonResult);
        String errorCode = jsonObject.getString("errorCode");
        String errorMsg = jsonObject.getString("errorMsg");
        return R.SUCCESS.equals(errorCode)?R.ok():R.error(errorCode,errorMsg);
    }

    /**
     * @Description 获取成功返回
     * @Author scotte
     * @Date 2018/8/21 16:40
     * @Param [application, buildList]
     * @return java.lang.String
     */
    public static String getOk(ApplicationDO application, Object object){
        JSONObject result = new JSONObject();
        result.put("status", ApiEnum.success.code);
        result.put("errorCode","");
        result.put("errorMsg","");
        String json = "{}";
        if(object !=null)json ="";
        result.put("data",json==""?object:json);
        String sign ="";
        if(application!=null){
            sign = MD5.md5(application.getUserNo()+application.getAppId()+application.getAppKey()+JSON.toJSONString(object));
        }
        result.put("sign",sign);
        return result.toJSONString();
    }

    public static String getError(String errorCode,String errorMsg) {
        JSONObject result = new JSONObject();
        result.put("status", ApiEnum.fail.code);
        result.put("errorCode", errorCode);
        result.put("errorMsg", errorMsg);
        result.put("data", "{}");
        result.put("sign", "");
        return result.toJSONString();
    }
    public static String getError(int errorCode,String errorMsg) {
        JSONObject result = new JSONObject();
        result.put("status", ApiEnum.fail.code);
        result.put("errorCode", errorCode);
        result.put("errorMsg", errorMsg);
        result.put("data", "{}");
        result.put("sign", "");
        return result.toJSONString();
    }

    /**
     * @Description 获取请求中的data数据，并转换成实体
     * @Author scotte
     * @Date 2018/8/21 11:41
     * @Param []
     * @return void
     */
    public static <T> T getRequestVoDataObject(RequestVo requestVo,Class<T> cla){
        T t = null;
        try {
            String data = requestVo.getData();
            if(StringUtils.isNotBlank(data)){
                t = JSONObject.parseObject(data,cla);
            }else{
                t = cla.newInstance();
            }
        }catch (Exception e){
            throw new MyException(getError(ApiEnum.paramsJsonError.code,ApiEnum.paramsJsonError.msg));
        }
        return t;
    }
    /**
     * @Description 获取异常字符串
     * @Author scotte
     * @Date 2018/8/21 17:20
     * @Param [ex]
     * @return java.lang.String
     */
    public static String getExceptionString(Throwable ex) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out);
        ex.printStackTrace(pout);
        String ret = new String(out.toByteArray());
        pout.close();
        try {
            out.close();
        } catch (Exception e) {
        }
        return ret;
    }
    /**
     * @Description 保存异常信息
     * @Author scotte
     * @Date 2018/8/21 15:18
     * @Param [request, msg]
     * @return 异常批次号
     */
    public static String saveException(RequestVo requestVo,String msg){
        ExceptionDO exceptionDO = new ExceptionDO();
        String batchNumber = String.valueOf(System.currentTimeMillis());
        ApiEnum apiEnum = requestVo.getApiEnum();
        if(apiEnum!=null){
            exceptionDO.setApiCode(apiEnum.code);
            exceptionDO.setApiName(apiEnum.msg);
        }
        exceptionDO.setBatchNumber(batchNumber);
        exceptionDO.setCreateTime(new Date());
        exceptionDO.setExceptionMsg(msg);
        exceptionDO.setExUrl(requestVo.getApiUrl());
        exceptionDO.setReqParam(getRequestString(requestVo).replaceAll("\"","\'"));
        exceptionDO.setSysresource("citytour-api");
        exceptionDO.setOperator(requestVo.getApplicationNo());
        try {
            ExceptionService exceptionService = ApplicationContextRegister.getBean(ExceptionService.class);
            exceptionService.save(exceptionDO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return batchNumber;
    }
    /**
     * @Description api接口 耗时统计
     * @Author scotte
     * @Date 2018/11/2 15:04
     * @Param [requestVo]
     * @return void
     */
    public static void saveApiTimeConsume(RequestVo requestVo){
        ApiEnum apiEnum = requestVo.getApiEnum();
        long createTimeStamp = requestVo.getCreateTimeStamp();
        if(apiEnum!=null && createTimeStamp>0){
            ApplicationApiDetectionDO applicationApiDetectionDO = new ApplicationApiDetectionDO();
            applicationApiDetectionDO.setApiUrl(requestVo.getApiUrl());
            applicationApiDetectionDO.setReqParam(getRequestString(requestVo).replaceAll("\"","\'"));
            applicationApiDetectionDO.setApiCode(apiEnum.code);
            applicationApiDetectionDO.setApiName(apiEnum.msg);
            applicationApiDetectionDO.setCompleteTime(new Date());
            applicationApiDetectionDO.setCreateTime(new Date(createTimeStamp));
            applicationApiDetectionDO.setTimeConsuming(System.currentTimeMillis()-createTimeStamp);
            try {
                ApplicationApiDetectionService apiDetectionService = ApplicationContextRegister.getBean(ApplicationApiDetectionService.class);
                apiDetectionService.save(applicationApiDetectionDO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private static String getRequestString(RequestVo requestVo){
        HttpServletRequest request = requestVo.getRequest();
        String params = "url params==>";
        if(request !=null){
            params +=request.getQueryString();
        }
        params +=";; body==>"+requestVo.getData();
        return params;
    }
    /**
     * @Description 获取请求中的所有参数，组成json字符串
     * @Author scotte
     * @Date 2018/9/7 11:06
     * @Param [request]
     * @return java.lang.String
     */
    public static String getRequestGetParams(HttpServletRequest request){
        Map properties = request.getParameterMap();
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }

    return JSONObject.toJSONString(returnMap);
    }

    /**
     * @Description 生成订单号
     * @Author scotte
     * @Date 2018/8/23 15:29
     * @Param [applyNo]
     * @return java.lang.String
     */
    public static String getOrderNo(){
        return System.currentTimeMillis()+Tools.getRandomString(5);
    }
    /**
     * @Description 生成商户订单号
     * @Author scotte
     * @Date 2018/8/23 15:29
     * @Param [applyNo]
     * @return java.lang.String
     */
    public static String getOutTradeNo(){
        return System.currentTimeMillis()+Tools.getRandomString(5);
    }
}
