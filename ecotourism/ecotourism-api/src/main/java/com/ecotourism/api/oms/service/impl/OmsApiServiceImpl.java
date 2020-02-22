package com.ecotourism.api.oms.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.domain.order.create.OrderRequestParam;
import com.ecotourism.api.api.domain.order.notice.PayNoticeVo;
import com.ecotourism.api.api.util.ApiUtils;
import com.ecotourism.api.api.util.MatrixToImageWriter;
import com.ecotourism.api.application.domain.ApplicationOrderDO;
import com.ecotourism.api.application.domain.DistributionDO;
import com.ecotourism.api.application.domain.OrderDo;
import com.ecotourism.api.application.domain.OrderResult;
import com.ecotourism.api.common.config.BootdoConfig;
import com.ecotourism.api.common.config.Constant;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.oms.domain.OmsConstant;
import com.ecotourism.api.oms.domain.OmsData;
import com.ecotourism.api.oms.domain.OmsParams;
import com.ecotourism.api.oms.domain.RefundFromOmsDo;
import com.ecotourism.api.oms.service.OmsApiService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 说明：oms下单
 * 创建人：陈启勇
 * 创建时间: 2018/8/23 15:15
 **/
@Service("omsApiService")
public class OmsApiServiceImpl implements OmsApiService{
    @Autowired
    private BootdoConfig bootdoConfig;
    /**
     * @Description 到oms检测是否可下单
     * @author 陈启勇
     * @Date 2018/8/23 16:16
     * @Param [params, distribution]
     * @return com.ecotourism.api.common.utils.R
     */
    public R checkCreateOrder(OrderRequestParam params,DistributionDO distribution){
        OmsParams omsParams = new OmsParams();
        BeanUtils.copyProperties(params,omsParams);
        omsParams.setPayType("006001");
        String json = JSONObject.toJSONString(omsParams);
        String omsApi = OmsConstant.getOmsApi(distribution, json, OmsConstant.checkCreateOrder);
        String result ="";
        try {
            result = send(omsApi, json);
        }catch (Exception e){
            return R.error(ApiEnum.createOrderError.code,"oms==>"+ApiUtils.getExceptionString(e)).setUseMsg(false);
        }
        if(!"success".equals(result)){
            return R.error(ApiEnum.createOrderError.code,JSONObject.parseObject(result).getString("errorMsg"));
        }
        return R.ok();
    }


    /**
     * @Description 到oms下单
     * @author 陈启勇
     * @Date 2018/8/23 16:16
     * @Param [params, distribution]
     * @return com.ecotourism.api.common.utils.R
     */
    public R createOrder(OrderResult order, PayNoticeVo payNoticeVo){
        DistributionDO distribution = payNoticeVo.getApp().getDistribution();
        OmsParams omsParams = new OmsParams();
        omsParams.setOrderNo(order.getOrderNo());
        omsParams.setPayStatus("005001");
        omsParams.setPayType(order.getPayType());
        omsParams.setPushUserNo(order.getPushUserNo());
        ArrayList<OmsData> omsDatas = new ArrayList<>();
        List<OrderDo> orders = order.getOrders();
        for (OrderDo aDo : orders) {
            OmsData omsData = new OmsData();
            omsData.setSubOrderNo(aDo.getSubOrderNo());
            omsData.setCustomerName(aDo.getCustomerName());
            omsData.setCustomerPhone(aDo.getCustomerPhone());
            omsData.setCustomerUserId(aDo.getCustomerUserId());
            omsData.setPlayTime(aDo.getPlayTime());
            omsData.setProductNo(aDo.getProductNo());
            omsData.setNums(String.valueOf(aDo.getOrderQuantity()));
            omsData.setPayPrice(String.valueOf(aDo.getPayPrice()));
            omsData.setTotalAmount(String.valueOf(aDo.getTotalAmount()));
            omsDatas.add(omsData);
        }
        omsParams.setData(omsDatas);
        String json = JSONObject.toJSONString(omsParams);
        String omsApi = OmsConstant.getOmsApi(distribution, json, OmsConstant.createOrder);
        String result ="";
        List<ApplicationOrderDO> orderDos=null;
        try {
            result = send(omsApi, json);
            JSONObject parse = JSONObject.parseObject(result);
            if("success".equals(parse.getString("status"))){
                String data = parse.get("data")==null?"":parse.get("data").toString();
                String basePath = payNoticeVo.getBasePath();
                if(StringUtils.isNotBlank(data)) {
                    orderDos = JSONArray.parseArray(data, ApplicationOrderDO.class);
                    for (ApplicationOrderDO aDo : orderDos) {
                       /* String electronicTicket = aDo.getElectronicTicket();
                        String s = makeQrcode(electronicTicket);
                        aDo.setQrcodeUrl(basePath+s);*/
                        aDo.setOmsResult(result);
                        aDo.setApplicationNo(order.getApplicationNo());
                    }
                    return R.ok(orderDos);
                }
            }
        } catch (Exception e) {
            return R.error(ApiEnum.createOrderError.code,"oms下单==>"+ApiUtils.getExceptionString(e),result).setUseMsg(false);
        }
        return R.error(ApiEnum.createOrderError.code,"oms下单返回==>"+result,result).setUseMsg(false);
    }

   /**
    * @Description 退票
    * @author 陈启勇
    * @Date 2018/9/7 16:11
    * @Param [refundFromOms, distribution]
    * @return com.alibaba.fastjson.JSONObject
    */
    public R refundOrder(RefundFromOmsDo refundFromOms,DistributionDO distribution){
        String json = JSONObject.toJSONString(refundFromOms);
        String omsApi = OmsConstant.getOmsApi(distribution, json, OmsConstant.refundTicket);
        String result ="";
        try {
            result = send(omsApi, json);
            JSONObject parse = JSONObject.parseObject(result);
            if("success".equals(parse.getString("status"))){
                String data = parse.get("data")==null?"":parse.get("data").toString();
                if(StringUtils.isNotBlank(data)) {
                    List<ApplicationOrderDO> orderDos= JSONArray.parseArray(data, ApplicationOrderDO.class);
                    for (ApplicationOrderDO orderDo : orderDos) {
                        orderDo.setRefundStatus("002001");
                    }
                    return R.ok(orderDos);
                }
            }else if("9001".equals(parse.getString("errorCode"))){
                return R.error(ApiEnum.refundOrderError.code,"oms退单返回==>"+result).setUseMsg(false);
            }else if("9020".equals(parse.getString("errorCode"))){//订单已退
                return R.ok();
            }else{
                result = parse.getString("errorMsg");
            }
        }catch (Exception e){
            return R.error(ApiEnum.refundOrderError.code,"oms退单==>"+ApiUtils.getExceptionString(e)).setUseMsg(false);
        }
        return R.error(ApiEnum.refundOrderError.code,result);
    }

    /**
     * 生成图片
     * @param ticketBarcodeNo
     * @return
     */
    private String makeQrcode(String ticketBarcodeNo){
        String outQrcode = null;
        try {
            outQrcode = MatrixToImageWriter.outQrcode(bootdoConfig.getUploadPath(), Constant.UPLOAD_QRCODE_PATH, ticketBarcodeNo);
            outQrcode = outQrcode.replace("\\", "/");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  Constant.FILE_PATH+outQrcode;
    }

    private static String send(String pathParams,String json) throws Exception {
            URL url = new URL(pathParams);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// 提交模式
            httpURLConnection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=utf-8"); // 设置发送数据的格式
            // conn.setConnectTimeout(10000);//连接超时 单位毫秒
            // conn.setReadTimeout(2000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // 发送请求参数
            printWriter.write(json);//json格式
            // flush输出流的缓冲
            printWriter.flush();
            //开始获取数据
            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while((len=bis.read(arr))!= -1){
                bos.write(arr,0,len);
                bos.flush();
            }
            bos.close();
            return bos.toString("utf-8");
    }
}
