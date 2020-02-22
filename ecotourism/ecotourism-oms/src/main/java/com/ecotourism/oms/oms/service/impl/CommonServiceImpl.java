package com.ecotourism.oms.oms.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ecotourism.oms.common.utils.PageData;
import com.ecotourism.oms.oms.config.ApiEnum;
import com.ecotourism.oms.oms.config.Const;
import com.ecotourism.oms.oms.config.ResultMsg;
import com.ecotourism.oms.oms.dao.OmsApiFieldconfigDao;
import com.ecotourism.oms.oms.dao.OrderLogDao;
import com.ecotourism.oms.oms.domain.*;
import com.ecotourism.oms.oms.service.CommonService;
import com.ecotourism.oms.oms.util.GetMacUtil;
import com.ecotourism.oms.oms.util.MakeOrderNum;
import com.ecotourism.oms.oms.util.Tools;
import com.ecotourism.oms.oms.util.express.util.SignUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * oms公共方法
 */
@Service()
public class CommonServiceImpl implements CommonService {
   // private static Logger logger = Logger.getLogger(CommonServiceImpl.class);
    @Autowired
    OrderLogDao orderLogDao;
    @Autowired
    OmsApiFieldconfigDao omsApiFieldconfigDao;
    /**
     * 入参pd：请求完整PageData对象
     * json字符串转json对象,转换成功则返回请求中data订单数据JSONObject对象(包含cid)
     * @return
     */
    public ResultMsg jsonStringToJson(PageData pd,ApiEnum apiType){
        String data = Tools.getString(pd, "data");
        if(StringUtils.isBlank(data)){
            return ResultMsg.getResultMsg(ApiEnum.paramError.code,ApiEnum.paramError.msg);
        }
        JSONObject json =null;
        try {
            json = JSONObject.parseObject(data);
        } catch (Exception e) {
            return ResultMsg.getResultMsg(ApiEnum.jsonException.code,ApiEnum.jsonException.msg);
        }
        String cid = pd.getString("cid");
        String distributionNo = pd.getString("distributionNo");
        json.put("cid",cid);
        json.put("distributionNo",distributionNo);
        return ResultMsg.getOK(json);
    }
    /**
     * 入参pd：请求完整PageData对象：要求data中没有票数据
     * json字符串转PageData对象,转换成功则返回请求中data订单数据加入PageData对象中，去除data(包含cid)
     * @return
     */
    public ResultMsg jsonStringToPd(PageData pd,ApiEnum apiType){
       // logger.debug(apiType.msg+"：参数==>"+pd);
        String data = Tools.getString(pd, "data");
        if(StringUtils.isBlank(data)){
            return ResultMsg.getResultMsg(ApiEnum.paramError.code,ApiEnum.paramError.msg);
        }
        PageData json =null;
        try {
            json = JSONObject.parseObject(data, PageData.class);
        } catch (Exception e) {
            return ResultMsg.getResultMsg(ApiEnum.jsonException.code,ApiEnum.jsonException.msg);
        }
        for (Object key : pd.keySet()) {
            json.remove(key);
        }
        pd.putAll(json);
        pd.remove("data");
       // logger.debug(apiType.msg+"：转换的json==>"+json);
        return ResultMsg.getOK(pd);
    }

    /**
     * 入参pd：请求完整PageData对象：要求data中没有票数据
     * json字符串转PageData对象,转换成功则返回请求中data订单数据加入PageData对象中，去除data(包含cid)
     * @return
     */
    public ResultMsg jsonStringToPd(RequestVo requestVo,ApiEnum apiType){
       // logger.debug(apiType.msg+"：参数==>"+requestVo);
        String data = requestVo.getData();
        if(StringUtils.isBlank(data)){
            return ResultMsg.getResultMsg(ApiEnum.paramError.code,ApiEnum.paramError.msg);
        }
        PageData json =null;
        try {
            json = JSONObject.parseObject(data, PageData.class);
        } catch (Exception e) {
            return ResultMsg.getResultMsg(ApiEnum.jsonException.code,ApiEnum.jsonException.msg);
        }
        return ResultMsg.getOK(json);
    }
    /**
     *判断订单是否存在
     * @param json
     * @return
     * @throws Exception
     */
    public ResultMsg hasOrder(JSONObject json, ApiEnum api) {
        //logger.debug(api.msg+"：判断订单是否存在");
        OrderLogDO orderLogDO = new OrderLogDO();
        orderLogDO.setOrderNo(json.getString("orderNo"));
        orderLogDO.setOrderDistributor(json.getString("distributionNo"));
        orderLogDO = orderLogDao.get(orderLogDO);
        if(orderLogDO != null) return ResultMsg.getResultMsg(ApiEnum.orderExists.code,ApiEnum.orderExists.msg);
        return ResultMsg.getOK();
    }
    /**
     *获取成功返回
     * @param requestVo 请求参数
     * @param buildList 订单信息
     * @return
     */
    public String getResultOk(RequestVo requestVo, List<PageData> buildList){
        JSONObject result = new JSONObject();
        result.put("status", "success");
        result.put("errorCode","");
        result.put("errorMsg","");
        result.put("data",buildList);
        String cid = requestVo.getCid();
        String appKey = requestVo.getAppKey();
        String secret = requestVo.getSecret();
        result.put("sign", SignUtil.sign(cid,appKey,secret, JSON.toJSONString(buildList)));
        return result.toJSONString();
    }

    /**
     *获取成功返回
     * @param pd 请求参数
     * @param buildList 订单信息
     * @return
     */
    public String getResultOk(PageData pd,List<PageData> buildList){
        JSONObject result = new JSONObject();
        result.put("status", "success");
        result.put("errorCode","");
        result.put("errorMsg","");
        result.put("data",buildList);
        String cid = Tools.getString(pd, "cid");
        String appKey = Tools.getString(pd, "appKey");
        String secret = Tools.getString(pd, "secret");
        result.put("sign", SignUtil.sign(cid,appKey,secret, JSON.toJSONString(buildList)));
        return result.toJSONString();
    }

    /**
     * 从参数中获取订单编号
     * @param requestVo
     * @return
     */
    public ResultMsg getParamsOrderNo(RequestVo requestVo){
        String orderNo;
        String data = requestVo.getData();
        if(StringUtils.isBlank(data)){
            orderNo = null;
        }else{
            try {
                JSONObject json = JSONObject.parseObject(data);
                orderNo = json.getString("orderNo");
            } catch (Exception e) {
                e.printStackTrace();
                return ResultMsg.getResultMsg(ApiEnum.jsonException.code, ApiEnum.jsonException.msg);
            }
        }
        if(StringUtils.isBlank(orderNo)) return ResultMsg.getResultMsg(ApiEnum.orderIsNull.code, ApiEnum.orderIsNull.msg);
        return ResultMsg.getOK(orderNo);
    }

    public String getError(String errorCode,String errorMsg) {
        JSONObject result = new JSONObject();
        result.put("status", "false");
        result.put("errorCode", errorCode);
        result.put("errorMsg", errorMsg);
        result.put("data", "");
        result.put("sign", "");
        return result.toJSONString();
    }
    /**
     * 保存日志
     * @throws Exception
     */
    public void saveLog(List<OrderSpotDO> list,ApiEnum api){
        //logger.debug(api.msg+"：保存日志开始");
        try {
            for (OrderSpotDO pageData : list) {
                OrderLogDO logPd = new OrderLogDO();
                logPd.setOrderNo(pageData.getOrderNo());
                logPd.setLogType(api.code);
                logPd.setLogContent(api.msg);
                logPd.setCreateUser("sys");
                logPd.setOrderDistributor(pageData.getOrderDistributor());
                logPd.setElectronicTicket(pageData.getElectronicTicket());
                logPd.setOrderQuantity(pageData.getOrderQuantity());
                logPd.setSelfMachineNo(pageData.getSelfMachineNo());
                orderLogDao.save(logPd);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //logger.debug(api.msg+"：保存日志结束");
    }
    /**
     * 保存日志
     * @throws Exception
     */
    public void saveLog(PageData logPd,ApiEnum api) {
        //logger.debug(api.msg+"：保存日志开始");
        try {
            logPd.put("LOG_TYPE", api.code);
            logPd.put("LOG_CONTENT", api.msg);
            logPd.put("CREATE_USER", "sys");
            //executeInsert("createOrderLog",logPd);
        }catch (Exception e){
            e.printStackTrace();
        }
       // logger.debug(api.msg+"：保存日志结束");
    }

    /**
     * 接口字段配置信息，将数据库字段转换为标准输出
     * @param APINo
     * @param APIversion
     * @return
     */
    public List<OmsApiFieldconfigDO> getAPIFieldTransInfo(String APINo, String APIversion) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("apino",APINo);
        map.put("apiversion",APIversion);
        try {
            return omsApiFieldconfigDao.list(map);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     *根据编码获取值信息,传入sql
     * @param code
     * @param formatSql
     * @return
     */
    public String getNameByCode(String code,String formatSql) {
        PageData pdGetNameByCode = new PageData();
        String cmdGetNameByCode = "getNameByCode";
        pdGetNameByCode.put("sql", MessageFormat.format(formatSql,code));
        try {
           // return (String) executeQueryOne(cmdGetNameByCode, pdGetNameByCode).get("name");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return "";
    }
    /**
     * 订单 转换成标准 查询,参数转换
     * @param pd
     * @return
     */
    public PageData buildOrderQuery(PageData pd) {
        PageData pdres = new PageData();
        pdres.put("ORDER_NO", pd.get("orderNo").toString());
        pdres.put("DISTRIBUTION_NO", pd.get("distributionNo").toString());
        return pdres;
    }

    /**
     * 订单 转换成标准 显示（大转小） 用于返回数据格式转换
     * @param pds 需要转换的数据
     * @param version 接口版本
     * @param apiType 接口类型
     * @return
     * @throws Exception
     */
    public List<PageData> buildOrdersInfo (List<OrderSpotDO> pds, String version, String apiType){
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(pds));
        return  buildReturnInfo(jsonArray,version,apiType);
    }

    /**
     * 订单 转换成标准 显示（大转小） 用于返回数据格式转换
     * @param pds 需要转换的数据
     * @param version 接口版本
     * @param apiType 接口类型
     * @return
     * @throws Exception
     */
    public List<PageData> buildOrderStatusInfo (List<OrderLogDO> pds, String version, String apiType){
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(pds));
        return  buildReturnInfo(jsonArray,version,apiType);
    }

    public List<PageData> buildProductsInfo(List<SpotTicketDO> pds,String version)
    {
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(pds));
        return buildReturnInfo(jsonArray,version,"022001");
    }

    public List<PageData> buildReturnInfo(JSONArray jsonArray,String version, String apiType)
    {
        String transAfter = "";
        List<PageData> pdsres = new ArrayList<PageData>();
        List<OmsApiFieldconfigDO> pdls = getAPIFieldTransInfo(apiType,version);
        for(int i=0;i<jsonArray.size();i++){
            PageData pdres = new PageData();
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            for(OmsApiFieldconfigDO omsApiFieldconfigDO:pdls)
            {
                transAfter = omsApiFieldconfigDO.getTransafter();
                pdres.put(transAfter,jsonObject.getString(transAfter));
            }
            pdsres.add(pdres);
        }
        return pdsres;
    }

    /**
     * 数据 转换成标准（小转大）用于sql操作
     * @param requestVo
     * @return
     */
    public PageData buildOrderUpdateInfo(RequestVo requestVo,String version,String apiType) {
        String transAfter = "";
        PageData pdres = new PageData();
        JSONObject jsonObject = JSONObject.parseObject(requestVo.getData());
        for(OmsApiFieldconfigDO pd1 :getAPIFieldTransInfo(apiType,version))
        {
            transAfter = pd1.getTransafter();
            pdres.put(transAfter,jsonObject.getString(transAfter));
        }
        //取消订单
        pdres.put("ORDER_STATUS", "004003");
        return pdres;
    }

    /**
     * 获取票号
     * @param data
     * @param type
     * @return
     * @throws Exception
     */
    public String getElectronicTicket(JSONObject data, String type) {
        String deviceNo = "00";
        String electronicTicket = "C"+ MakeOrderNum.makeOrderNum();
        if(Const.ORDER_SELF.equals(type)){
            String selfMachineNo = data.getString("selfMachineNo");
            if(StringUtils.isNotEmpty(selfMachineNo)){
//                PageData macPd = (PageData) CacheUtil.getCache(CacheUtil.prefix_getMac+selfMachineNo);
//                if(macPd != null){
//                    if(macPd.containsKey("EQUIPMENT_NUMBER")){
//                        deviceNo = macPd.getString("EQUIPMENT_NUMBER");
//                    }
//                }else{
//                    PageData devicePd = new PageData();
//                    devicePd.put("deviceNo",selfMachineNo);
//                    PageData macpd = (PageData) daoSupport.findForObject("SelfServiceDeviceMapper.querySelfServiceDeviceNo", devicePd);
//                    if(macpd != null){
//                        deviceNo = macpd.getString("EQUIPMENT_NUMBER");
//                    }
                    //CacheUtil.setCache(CacheUtil.prefix_getMac+selfMachineNo,macpd);
//                }
            }
        }else{
            String macAddress = GetMacUtil.getMACAddress();
        //logger.debug("下单：macAddress==============>"+macAddress);
            if(!("00".equals(macAddress))){
                PageData devicePd = new PageData();
                devicePd.put("DEVICE_MAC_ENCRYPT",macAddress);
//                PageData macpd = (PageData) daoSupport.findForObject("SelfServiceDeviceMapper.querySelfServiceDeviceMac", devicePd);
//                if(macpd != null){
//                    deviceNo = macpd.getString("EQUIPMENT_NUMBER");
//                }
            }
        }
        //logger.debug("deviceNo======================="+deviceNo);
        electronicTicket = electronicTicket+deviceNo;
        //logger.debug("electronicTicket======================="+electronicTicket);
        return electronicTicket;
    }
    /**
     * 发送 post 请求
     * @param url
     * @param json json字符串
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "resource" })
    public String  postData(String url, String json) throws Exception {
        HttpPost post = new HttpPost(url);
        if(StringUtils.isNotBlank(json)) {
            StringEntity entity = new StringEntity(json, "utf-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            post.setEntity(entity);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            org.apache.http.HttpResponse httpResponse = httpClient.execute(post);
            if(httpResponse.getStatusLine().getStatusCode() == 200) {
                org.apache.http.HttpEntity httpEntity = httpResponse.getEntity();
                //取出应答字符串
                String result = EntityUtils.toString(httpEntity);
                System.out.println("result================================"+result);
                if(StringUtils.isNotEmpty(result)) {
                    return result;
                }
            }
            httpClient.close();
        }
        return null;
    }
}
