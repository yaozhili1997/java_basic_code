package com.ecotourism.oms.oms.service;


import com.alibaba.fastjson.JSONObject;
import com.ecotourism.oms.common.utils.PageData;
import com.ecotourism.oms.oms.config.ApiEnum;
import com.ecotourism.oms.oms.config.ResultMsg;
import com.ecotourism.oms.oms.domain.*;

import java.util.List;

public interface CommonService {
    /**
     * 返回的错误信息
     * @param errorCode
     * @param errorMsg
     * @return
     */
    String getError(String errorCode, String errorMsg);
    /**
     * 入参pd：请求完整PageData对象
     * json字符串转json对象,转换成功则返回请求中data订单数据JSONObject对象(包含cid)
     * @return
     */
    ResultMsg jsonStringToJson(PageData pd, ApiEnum apiType);

    /**
     * 入参pd：请求完整PageData对象：要求data中没有票数据
     * json字符串转PageData对象,转换成功则返回请求中data订单数据加入PageData对象中，去除data(包含cid)
     * @return
     */
    ResultMsg jsonStringToPd(RequestVo requestVo, ApiEnum apiType);
    /**
     *判断订单是否存在
     * @param json
     * @return
     * @throws Exception
     */
    ResultMsg hasOrder(JSONObject json, ApiEnum api);

    /**
     *获取成功返回
     * @param requestVo 请求参数
     * @param buildList 订单信息
     * @return
     */
    String getResultOk(RequestVo requestVo, List<PageData> buildList);
    /**
     *获取成功返回
     * @param pd 请求参数
     * @param buildList 订单信息
     * @return
     */
    String getResultOk(PageData pd, List<PageData> buildList);
    /**
     * 从参数中获取订单编号
     * @param requestVo
     * @return
     */
    ResultMsg getParamsOrderNo(RequestVo requestVo);
    /**
     * 保存日志
     * @throws Exception
     */
    void saveLog(List<OrderSpotDO> list, ApiEnum api);
    /**
     * 保存日志
     * @throws Exception
     */
    void saveLog(PageData logPd, ApiEnum api);
    /**
     * 接口字段配置信息，将数据库字段转换为标准输出
     * @param APINo
     * @param APIversion
     * @return
     */
    List<OmsApiFieldconfigDO> getAPIFieldTransInfo(String APINo, String APIversion);
    /**
     *根据编码获取值信息,传入sql
     * @param code
     * @param formatSql
     * @return
     */
    String getNameByCode(String code, String formatSql);
    /**
     * 订单 转换成标准 查询,参数转换
     * @param pd
     * @return
     */
    PageData buildOrderQuery(PageData pd);
    /**
     * 订单 转换成标准 显示
     * @param pds 需要转换的数据
     * @param version 接口版本
     * @param apiType 接口类型
     * @return
     * @throws Exception
     */
    List<PageData> buildOrdersInfo(List<OrderSpotDO> pds, String version, String apiType);

    List<PageData> buildOrderStatusInfo(List<OrderLogDO> pds, String version, String apiType);

    /**
     * 订单 转换成标准 显示
     * @param pds 需要转换的数据
     * @param version 接口版本
     * @return
     * @throws Exception
     */
    List<PageData> buildProductsInfo(List<SpotTicketDO> pds, String version);

    /**
     * 数据 转换成标准（小转大）用于sql操作
     * @param requestVo
     * @return
     */
    PageData buildOrderUpdateInfo(RequestVo requestVo, String version, String apiType);
    /**
     * 发送 post 请求
     * @param url
     * @param json
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "resource" })
    String  postData(String url, String json) throws Exception ;
    /**
     * 获取票号
     * @param data
     * @param type
     * @return
     * @throws Exception
     */
    String getElectronicTicket(JSONObject data, String type) ;
}
