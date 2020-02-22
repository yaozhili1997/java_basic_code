package com.ecotourism.oms.oms.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ecotourism.oms.common.exception.MyException;
import com.ecotourism.oms.common.utils.DateUtil;
import com.ecotourism.oms.common.utils.PageData;
import com.ecotourism.oms.oms.config.ApiEnum;
import com.ecotourism.oms.oms.config.Const;
import com.ecotourism.oms.oms.config.ResultMsg;
import com.ecotourism.oms.oms.dao.*;
import com.ecotourism.oms.oms.domain.*;
import com.ecotourism.oms.oms.service.CommonService;
import com.ecotourism.oms.oms.service.CreateOrderService;
import com.ecotourism.oms.oms.util.Error;
import com.ecotourism.oms.oms.util.IdCardUtil;
import com.ecotourism.oms.oms.util.MakeOrderNum;
import com.ecotourism.oms.oms.util.Tools;
import com.ecotourism.oms.product.dao.PriceStockDao;
import com.ecotourism.oms.product.domain.PriceStockDO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CreateOrderServiceImpl implements CreateOrderService {
    private static final Logger logger = LoggerFactory.getLogger(CreateOrderServiceImpl.class);
    private static PageData orderNoApply= new PageData();//防重复提交
    private static SimpleDateFormat datesdf=new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    CommonService commonService;
    @Autowired
    SpotTicketDao spotTicketDao;
    @Autowired
    OrderSpotDao orderSpotDao;
    @Autowired
    StockDao stockDao;
    @Autowired
    CooperationPrestoreDao cooperationPrestoreDao;
    @Autowired
    CapitalFlowDao capitalFlowDao;
    @Autowired
    SupplierDao supplierDao;
    @Autowired
    PriceStockDao priceStockDao;
    @Override
    @Transactional
    public String createOrder(RequestVo requestVo, String type) throws Exception{
        ResultMsg resultMsg = checkRepeatSubmit(requestVo);
        if(!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code())) return Error.getError(resultMsg.getReturn_code(),resultMsg.getReturn_msg());
        JSONObject data = (JSONObject) resultMsg.getObj();
        CooperationDistributionDO cooperationDistributionDO = requestVo.getCooperationDistributionDO();
        resultMsg = orderCheck(data,cooperationDistributionDO,type);
        if(!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code())) return Error.getError(resultMsg.getReturn_code(),resultMsg.getReturn_msg());
        PageData obj = (PageData) resultMsg.getObj();
        List<PageData> listPd = (List<PageData>) obj.get("listPd");
        PageData products = (PageData) obj.get("products");//产品信息
        List<OrderSpotDO> list = new ArrayList<OrderSpotDO>();
        BigDecimal totalPrice = new BigDecimal(0);
        String orderNo = data.getString("orderNo");
        OrderSpotDO pdcommon = getCreateCommonOrderPd(requestVo,data, type);
        String whetherSendSms = cooperationDistributionDO.getWhetherSendSms();
        for(PageData queryPd:listPd){
            String productNo = queryPd.getString("productNo");
            SpotTicketDO pro = (SpotTicketDO) products.get(productNo);//获取产品信息
            BigDecimal pay_price = pro.getPayPrice().setScale(2);//售价
            Date playDate = datesdf.parse(queryPd.getString("playTime"));
            //判断是否含有活动价
            Map<String, Object> map = new HashMap<>();
            map.put("productNo",productNo);
            map.put("playDate",playDate);
            PriceStockDO priceStockDO = null;
            List<PriceStockDO> stockList = priceStockDao.list(map);
            if(stockList.size()>0){
                priceStockDO = stockList.get(0);
            }
            if(priceStockDO !=null){
                pay_price = priceStockDO.getSalePrice().setScale(2);
            }
            String num = queryPd.getString("nums");
            String subOrderNo = queryPd.getString("subOrderNo");
            BigDecimal total = pay_price.multiply(new BigDecimal(num)).setScale(2);
            totalPrice = totalPrice.add(total);
            OrderSpotDO pdInsert = new OrderSpotDO();
            BeanUtils.copyProperties(pdcommon,pdInsert);
            pdInsert.setOrderNo(orderNo);
            pdInsert.setProductNo(productNo);
            pdInsert.setOrderQuantity(Integer.parseInt(num));
            pdInsert.setNums(num);
            pdInsert.setPayPrice(pay_price);
            pdInsert.setTotalAmount(total);
            String electronicTicket = commonService.getElectronicTicket(data,type);
            pdInsert.setElectronicTicket(electronicTicket);
            pdInsert.setSubOrderNo(subOrderNo);
            if(StringUtils.isBlank(subOrderNo)){
                pdInsert.setSubOrderNo(electronicTicket);
            }
            pdInsert.setProductName(pro.getProductName());
            pdInsert.setCompanyNo(pro.getCompanyNo());
            pdInsert.setCustomerName(queryPd.getString("customerName"));
            pdInsert.setCustomerPhone(queryPd.getString("customerPhone"));
            pdInsert.setCustomerUserId(queryPd.getString("customerUserId"));
            pdInsert.setPlayTime(playDate);
            pdInsert.setSpotNo(pro.getSpotNo());
            //是否启用产品库存
//          String whether_limit_stock = pro.getWhetherLimitStock();
//            if("1".equals(whether_limit_stock)){//启用
            updateProductStock(pro,priceStockDO,num,playDate);//减库存
//            }
            if(!Const.CODE_043008.equals(pro.getProductType())){//判断是否为套票产品
                pdInsert.setTicketType(pro.getTickType());
                pdInsert.setTicketNo(pro.getTicketNo());
            }else{
                saveSecondOrder(pdInsert,type);
            }
            if("1".equals(whetherSendSms)){//判断:下单发送短彩信
                String template_sms_no = pro.getTemplateSmsNo();//短信模板ID
                String template_mms_no = pro.getTemplateMmsNo();//彩信模板ID
                if(StringUtils.isNotBlank(template_sms_no) || StringUtils.isNotBlank(template_mms_no) ){
                    pdInsert.setMessageStatus("018003");//短信状态：待发送
                }
            }else{
                pdInsert.setMessageStatus("018002");//短信状态：待发送
            }
            String is_self = pro.getIsSelf();
            if("0".equals(is_self)){//非自有
                String ticketSupplier = pro.getTicketSupplier();//票种供应商
                SupplierDO supplierDO = supplierDao.get(ticketSupplier);
                if(supplierDO ==null){
                    throw new MyException(commonService.getError(ApiEnum.supplierNull.code, ApiEnum.supplierNull.msg));
                }
                pdInsert.setOrderStatus("004007");//出票中
                pdInsert.setPiaogoOrderNo(electronicTicket);
                pdInsert.setElectronicTicket("");
            }
            orderSpotDao.save(pdInsert);
            list.add(pdInsert);
        }
        if("006004".equals(cooperationDistributionDO.getPayType())){
            updateCooFlow(cooperationDistributionDO,orderNo,totalPrice);//购买扣款
        }
        commonService.saveLog(list, ApiEnum.createOrder);//保存日志
        List<PageData> buildList =  commonService.buildOrdersInfo(list,requestVo.getApiVersion(),Const.CODE_022002);
        return commonService.getResultOk(requestVo, buildList);
    }
    /**
     * @Description 检测产品库存
     * @Author scotte
     * @Date 2018/12/7 14:27
     * @Param [pro, num]
     * @return void
     */
    public ResultMsg checkProductStock(SpotTicketDO pro,PriceStockDO priceStockDO, String num,Date playDate) {
        int stockType = pro.getStockType();
        if(stockType ==1){ //限制总库存
            //总库存
            int totalStockNum = pro.getTotalStockNum();
            //已售总库存
            int totalStockSaleNum = pro.getTotalStockSaleNum();
            if(totalStockNum<(totalStockSaleNum+Integer.parseInt(num))){
                throw new MyException(commonService.getError(ApiEnum.productStockNotNum.code,ApiEnum.productStockNotNum.msg));
            }else{
                ProductStock productStock = new ProductStock();
                productStock.setProductNo(pro.getProductNo());
                productStock.setSaleNum(Integer.parseInt(num));
                spotTicketDao.update(productStock);
            }
        }else if(stockType ==2){ //限制日库存
            if(priceStockDO !=null){
                //已售数量
                int saleNum = priceStockDO.getSaleNum();
                //库存数量
                int stockNum = priceStockDO.getStockNum();
                if(stockNum<(saleNum+Integer.parseInt(num))){
                    throw new MyException(commonService.getError(ApiEnum.productStockDayNotNum.code,ApiEnum.productStockDayNotNum.msg));
                }else{
                    PriceStockDO priceStock = new PriceStockDO();
                    priceStock.setSaleNum(Integer.parseInt(num));
                    priceStock.setProductNo(pro.getProductNo());
                    priceStock.setDate(playDate);
                    priceStockDao.update(priceStock);
                }
            }else{
                ResultMsg.getOK();
            }
        }
        return ResultMsg.getOK();
    }

    /**
     * @Description 检测订单库存
     * @Author scotte
     * @Date 2018/12/7 14:27
     * @Param [pro, num]
     * @return void
     */
    public ResultMsg checkOrderStock(SpotTicketDO pro,List<PriceStockDO> list, String num) {
        int stockType = pro.getStockType();
        if(stockType ==1){ //限制总库存
            //总库存
            int totalStockNum = pro.getTotalStockNum();
            //已售总库存
            int totalStockSaleNum = pro.getTotalStockSaleNum();
            if(totalStockNum<(totalStockSaleNum+Integer.parseInt(num))){
                throw new MyException(commonService.getError(ApiEnum.productStockNotNum.code,ApiEnum.productStockNotNum.msg));
            }
        }else if(stockType ==2){ //限制日库存
            if(list.size()>0){
                PriceStockDO priceStockDO = list.get(0);
                if(priceStockDO !=null){
                    //已售数量
                    int saleNum = priceStockDO.getSaleNum();
                    //库存数量
                    int stockNum = priceStockDO.getStockNum();
                    if(stockNum<(saleNum+Integer.parseInt(num))){
                        throw new MyException(commonService.getError(ApiEnum.productStockDayNotNum.code,ApiEnum.productStockDayNotNum.msg));
                    }
                }
            }
        }
        return ResultMsg.getOK();
    }
    /**
     * @Description 检测产品库存
     * @Author scotte
     * @Date 2018/12/7 14:27
     * @Param [pro, num]
     * @return void
     */
    public ResultMsg checkProductStock(SpotTicketDO pro, String num) {
        String PRODUCT_NO = pro.getProductNo();
        StockDO stock = new StockDO();
        stock.setProductNo(PRODUCT_NO);
        stock.setAbbreviation("1");
        stock.setNowTime(new Date());
        StockDO stockNew = stockDao.findProductStock(stock);
        if(stockNew==null){
            throw new MyException(commonService.getError(ApiEnum.productStockNotExists.code,ApiEnum.productStockNotExists.msg));
        }
        Integer surplus_stock_num = stockNew.getSurplusStockNum();
        if(surplus_stock_num == null){//库存是否存在
            throw new MyException(commonService.getError(ApiEnum.productStockNotExists.code,ApiEnum.productStockNotExists.msg));
        }
        if(Integer.valueOf(num)>Integer.valueOf(surplus_stock_num)){//检测数量
            throw new MyException(commonService.getError(ApiEnum.productStockNotNum.code,ApiEnum.productStockNotNum.msg));
        }
        stock.setNum(Integer.valueOf(num));
        return ResultMsg.getOK(stock);
    }

    @Override
    public void updateProductStock(SpotTicketDO pro,PriceStockDO priceStockDO, String num,Date playDate) {
        checkProductStock(pro,priceStockDO, num,playDate);
    }

    @Override
    public void updateOrderProductStock(SpotTicketDO pro, String num) {
        ResultMsg resultMsg = checkProductStock(pro, num);
        stockDao.updateProductStockNum((StockDO) resultMsg.getObj());//减产品库存
    }

    @Override
    public ResultMsg orderCheck(JSONObject json, CooperationDistributionDO cooperationDistributionDO, String type) throws Exception{
        ResultMsg resultMsg = orderCheckJson(json,cooperationDistributionDO,type);//检测参数：判空及格式，获取List<PageData>票信息
        if(!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code())) return resultMsg;
        List<PageData> listPd = (List<PageData>) resultMsg.getObj();
        resultMsg = orderCooCheck(json,cooperationDistributionDO);//分销商规则检测
        if(!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code())) return resultMsg;
        resultMsg = commonService.hasOrder(json,ApiEnum.createOrder);//检测订单是否存在
        if(!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code())) return resultMsg;
        resultMsg = orderProductCheck(json,cooperationDistributionDO, listPd);//产品规则检测
        if(!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code())) return resultMsg;
        PageData products = (PageData) resultMsg.getObj();
        PageData pageData = new PageData();
        pageData.put("listPd",listPd);
        pageData.put("products",products);
        resultMsg.setObj(pageData);
        return resultMsg;
    }

    /**
     * 传入参数JSONObject：为购票请求参数中data订单数据转换的JSONObject对象 !=null
     * 购票：参数检测（成功返回的是票信息List<PageData>对象,包含产品编号和数量）
     * @return
     */
    public ResultMsg orderCheckJson(JSONObject json,CooperationDistributionDO cooperationDistributionDO,String type) {
        logger.debug("购票：订单来源：参数==>"+type);
        String orderNo = json.getString("orderNo");
        System.out.println("json=========================================="+json.toString());
        if(StringUtils.isBlank(orderNo)){
            return ResultMsg.getResultMsg(ApiEnum.paramError.code,"订单号不能为空！");
        }
        JSONArray jsonArray = json.getJSONArray("data");
        if(!Const.ORDER_SELF.equals(type)){
            for(int i=0;i<jsonArray.size();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String customerPhone = jsonObject.getString("customerPhone");
                if(StringUtils.isBlank(customerPhone)){
                    return ResultMsg.getResultMsg(ApiEnum.paramError.code,"手机号不能为空！");
                }
                if(!Tools.checkMobileNumber(customerPhone)){//手机号格式验证
                    return ResultMsg.getResultMsg(ApiEnum.phoneNumException.code,ApiEnum.phoneNumException.msg);
                }
                String customerName = jsonObject.getString("customerName");
                if(StringUtils.isBlank(customerName)){
                    return ResultMsg.getResultMsg(ApiEnum.paramError.code,"用户名不能为空！");
                }
                //身份证验证
                String customerUserId = jsonObject.getString("customerUserId");
                if(StringUtils.isNotBlank(customerUserId) && !IdCardUtil.is18ByteIdCardComplex(customerUserId)){
                    return ResultMsg.getResultMsg(ApiEnum.idCardNumException.code,ApiEnum.idCardNumException.msg);
                }
                String playTime = jsonObject.getString("playTime");
                if(StringUtils.isBlank(playTime)){
                    return ResultMsg.getResultMsg(ApiEnum.paramError.code,"游玩时间不能为空！");
                }
                String today = DateUtil.getTime();//当前时间
                long todaySdf;//现在时间(购买时间)
                long playDaySdf;//游玩时间
                try {
                    todaySdf = datesdf.parse(today).getTime();
                    playDaySdf = datesdf.parse(playTime).getTime();//游玩当天时间
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResultMsg.getResultMsg(ApiEnum.paramError.code,"游玩时间格式异常！");
                }
                if( playDaySdf<todaySdf){//游玩时间
                    return ResultMsg.getResultMsg(ApiEnum.buyOutTimeError.code,ApiEnum.buyOutTimeError.msg);
                }
            }
        }
        String payType = json.getString("payType");
        if(StringUtils.isBlank(payType)){
            return ResultMsg.getResultMsg(ApiEnum.paramError.code,"支付方式不能为空！");
        }
        String payStatus = json.getString("payStatus");
        if(StringUtils.isBlank(payStatus) && json.containsKey("payStatus")){
            return ResultMsg.getResultMsg(ApiEnum.paramError.code,"支付状态不能为空！");
        }

        String data = json.getString("data");
        if(StringUtils.isBlank(data)){
            return ResultMsg.getResultMsg(ApiEnum.paramError.code,"票信息不能为空！");
        }
        List<PageData> parseArray =null;
        try {
            parseArray = JSONArray.parseArray(json.getString("data"), PageData.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.getResultMsg(ApiEnum.paramError.code,"票信息格式错误！格式如：data[{}]");
        }
        for (PageData pageData2 : parseArray) {
            String productNo = pageData2.getString("productNo");
            if(StringUtils.isBlank(productNo)){
                return ResultMsg.getResultMsg(ApiEnum.paramError.code,"产品编号不能为空！");
            }
            String nums = pageData2.getString("nums");
            if(StringUtils.isBlank(nums)){
                return ResultMsg.getResultMsg(ApiEnum.paramError.code,"产品数量不能为空！");
            }
            if(Integer.valueOf(nums)<1){
                return ResultMsg.getResultMsg(ApiEnum.paramError.code,"产品数量不能小于1！");
            }
        }
        logger.debug("购票：下单参数检测==>通过检测");
        return ResultMsg.getOK(parseArray);
    }

    /**
     * 购票：分销商规则检测
     * @param json 购票请求参数json  !=null
     * @return
     */
    public ResultMsg orderCooCheck(JSONObject json,CooperationDistributionDO cooperationDistributionDO){
        String bookToday = cooperationDistributionDO.getBookToday();//是否可以预定当天的票
        if("0".equals(bookToday)){
            String playTime = json.getString("playTime");//游玩时间
            String purchaseTime = DateUtil.getTime();//当前系统时间 yyyy-MM-dd HH:mm:ss
            long todaySdf = 0;//yyyy-MM-dd
            long playDaySdf = 0;//游玩当天时间 yyyy-MM-dd
            try {
                todaySdf = datesdf.parse(purchaseTime).getTime();
                playDaySdf = datesdf.parse(playTime).getTime();
                if(playDaySdf==todaySdf){
                    return ResultMsg.getResultMsg(ApiEnum.bookTodayNot.code,ApiEnum.bookTodayNot.msg);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        logger.debug("购票：分销商下单规则检测==>通过检测");
        return ResultMsg.getOK();
    }

    /**
     * 购票：产品规则检测（只读）,购票前检测
     * @param json 购票请求参数json  !=null
     * @param listPd json中的票信息 !=null
     * @return
     */
    private ResultMsg orderProductCheck(JSONObject json,CooperationDistributionDO cooperationDistributionDO,List<PageData> listPd) throws Exception {
        String sale_channel_code = cooperationDistributionDO.getSaleChannelCode();
        PageData productDatas = new PageData();
        String productNo = "";
        for (PageData pd : listPd) {
            String PRODUCT_NO = pd.getString("productNo");
//            if(productNo.contains(PRODUCT_NO)){
//                return ResultMsg.getResultMsg(ApiEnum.productRepeat.code,ApiEnum.productRepeat.msg);
//            }
//            productNo+=PRODUCT_NO;
            //获取产品信息
            //PageData pro = clientHelperProductService.getProduct(PRODUCT_NO);
            List<SpotTicketDO> products = new ArrayList<SpotTicketDO>();
            SpotTicketDO productNotSpot = spotTicketDao.get(PRODUCT_NO);
            //产品渠道验证
            String distributionChannel = productNotSpot.getDistributionChannel();
            if(!sale_channel_code.contains(distributionChannel)){
                return ResultMsg.getResultMsg(ApiEnum.productReleased.code,ApiEnum.productReleased.msg);
            }
            String num = pd.getString("nums");//产品数量
            //验证金额
            String VERIFICATION_AMOUNT = pd.getString("VERIFICATION_AMOUNT");
            if("1".equals(VERIFICATION_AMOUNT)){
                logger.debug("购票：验证金额");
                String payPrice1 = pd.getString("payPrice");
                if(StringUtils.isBlank(payPrice1)){
                    return ResultMsg.getResultMsg(ApiEnum.paramError.code,"单价不能为空！");
                }
                String totalAmount1 = pd.getString("totalAmount");
                if(StringUtils.isBlank(totalAmount1)){
                    return ResultMsg.getResultMsg(ApiEnum.paramError.code,"总金额不能为空！");
                }
                BigDecimal payPrice = new BigDecimal(payPrice1).setScale(2);
                try {
                    BigDecimal pay_price = productNotSpot.getPayPrice().setScale(2);//产品售价
                    BigDecimal totalAmount = new BigDecimal(totalAmount1).setScale(2);//入参总价
                    BigDecimal nums = new BigDecimal(num);//数量
                    if(!pay_price.equals(payPrice)|| !pay_price.multiply(nums).equals(totalAmount)){
                        return ResultMsg.getResultMsg(ApiEnum.amountDataException.code,ApiEnum.amountDataException.msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResultMsg.getResultMsg(ApiEnum.paramError.code,"金额格式异常！");
                }
            }
            //if(CodeUtil.CODE_043008.equals(productNotSpot.getString("PRODUCT_TYPE"))){//判断是否为套票产品

           // }else{
               // PageData product = clientHelperProductService.getProduct(PRODUCT_NO);
                products.add(productNotSpot);
           // }
            String playTime = pd.getString("playTime");//游玩时间
            long playDaySdf = datesdf.parse(playTime).getTime();//游玩当天时间 yyyy-MM-dd
            //预售时间检测
            String whether_shelves_advance = productNotSpot.getWhetherShelvesAdvance();
            if("1".equals(whether_shelves_advance)){
                Date advanceStartDate = productNotSpot.getAdvanceStartDate();
                Date advanceEndDate = productNotSpot.getAdvanceEndDate();
                if(advanceStartDate !=null){
                    long timeStart = advanceStartDate.getTime();
                    long timeEnd = advanceEndDate.getTime();
                    if(playDaySdf<timeStart || playDaySdf>timeEnd){
                        return ResultMsg.getResultMsg(ApiEnum.preSaleException.code,ApiEnum.preSaleException.msg);
                    }
                }
            }
            //产品限购检测
            String whether_limit_sell = productNotSpot.getWhetherLimitSell();
            if("1".equals(whether_limit_sell)){
                ResultMsg resultMsg = checkLimitSell(productNotSpot, num, playTime);
                if(!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code())) return ResultMsg.getResultMsg(resultMsg.getReturn_code(),resultMsg.getReturn_msg());
            }
            for (SpotTicketDO pro : products) {//子产品规则验证
                String product_no = pro.getProductNo();
                productDatas.put(product_no, pro);
            }
            //产品库存检测
            //判断是否含有活动价
            Map<String, Object> map = new HashMap<>();
            map.put("productNo",PRODUCT_NO);
            map.put("playDate",playTime);
            List<PriceStockDO> stockList = priceStockDao.list(map);
            ResultMsg resultMsg = checkOrderStock(productNotSpot,stockList, String.valueOf(num));
            if(!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code())) return resultMsg;
        }
        logger.debug("购票：产品规则检测==>结束：通过检测");
        return ResultMsg.getOK(productDatas);
    }

    /**
     * 产品限购检测
     * @param product
     * @return
     */
    private ResultMsg checkLimitSell(SpotTicketDO product,String num,String playTime) throws Exception {
        String SELL_DATE_TYPE = product.getSellDateType();
        String LIMIT_SELL_NUM = product.getLimitSellNum();
        if(StringUtils.isNotBlank(LIMIT_SELL_NUM) && StringUtils.isNotBlank(SELL_DATE_TYPE)){
            SpotTicketDO pageData1 = new SpotTicketDO();
            pageData1.setProductNo(product.getProductNo());
            pageData1.setSellDateType(SELL_DATE_TYPE);
//            pageData1.set
//            pageData1.put("PRODUCT_NO",product.getProductNo());
//            pageData1.put("SELL_DATE_TYPE",SELL_DATE_TYPE);
//            pageData1.put("playTime",playTime);
            //PageData count = executeQueryOne("getCountLimitSell", pageData1);
//            if(count !=null){
//                String totalNum = count.getString("totalNum");
//                if(StringUtils.isNotBlank(totalNum) && StringUtils.isNotBlank(num)){
//                    long total = Long.valueOf(totalNum) + Long.valueOf(num);
//                    long limit_sell_num = Long.valueOf(LIMIT_SELL_NUM);
//                    if(total > limit_sell_num){
//                        String msg = "";
//                        if("042001".equals(SELL_DATE_TYPE)) msg = "每年";
//                        if("042002".equals(SELL_DATE_TYPE)) msg = "每月";
//                        if("042003".equals(SELL_DATE_TYPE)) msg = "每日";
//                        return ResultMsg.getResultMsg(ApiEnum.limitSaleException.code,ApiEnum.limitSaleException.msg.replaceAll("msg",msg));
//                    }
//                }
//            }
        }
        return ResultMsg.getOK();
    }

    @Override
    public void updateCooFlow(CooperationDistributionDO cooperationDistributionDO, String orderNo, BigDecimal totalPrice)  {
        String distributionNo = cooperationDistributionDO.getDistributionNo();
        String payType = cooperationDistributionDO.getPayType();
        CooperationPrestoreDO prestore = new CooperationPrestoreDO();
        prestore = cooperationPrestoreDao.get(distributionNo);
        if(prestore !=null){
            BigDecimal prestoreAmount = prestore.getPrestoreAmount();
            BigDecimal prestorePrice =  prestoreAmount.subtract(totalPrice);
            if(prestorePrice.compareTo(new BigDecimal(0))>=0){
                String name = cooperationDistributionDO.getName();
                logger.debug("购票："+name+"==>当前余额==> "+prestoreAmount);
                prestore.setSellPrestoreAmount(totalPrice);
                cooperationPrestoreDao.updatePrestore(prestore);
                logger.debug("购票：购票扣款==> "+distributionNo+"==>"+totalPrice);
            }else{
                throw new MyException(commonService.getError(ApiEnum.cooPrestore.code, ApiEnum.cooPrestore.msg));
            }
        }else{
            throw new MyException(commonService.getError(ApiEnum.cooIsNOT.code, ApiEnum.cooIsNOT.msg));
        }
        CapitalFlowDO capitalFlow = new CapitalFlowDO();
        capitalFlow.setDistributionNo(distributionNo);
        capitalFlow.setSettlementNo(null);
        capitalFlow.setOrderNo(orderNo);
        capitalFlow.setPayType(payType);
        capitalFlow.setHouston(new BigDecimal(0));
        capitalFlow.setOutOfAccount(totalPrice);
        capitalFlow.setTransactionTime(new Date());
        capitalFlow.setRemarks("购票扣款");
        capitalFlow.setCreateUser("admin");
        capitalFlow.setCreateTime(new Date());
        capitalFlowDao.save(capitalFlow);
    }

    @Override
    public void orderSendSms(List<PageData> list, PageData rsp, JSONObject data) {

    }

    @Override
    public PageData buildOrderInsertInfo(PageData pd, String distributionNo, String version, PageData pro) {
        return null;
    }

    @Override
    public OrderSpotDO getCreateCommonOrderPd(RequestVo requestVo, JSONObject data, String type) {
        OrderSpotDO orderSpotDO = new OrderSpotDO();
        String ip = requestVo.getIP();//订单来源ip
        CooperationDistributionDO cooperationDistributionDO = requestVo.getCooperationDistributionDO();
        String pushUserNo = data.getString("pushUserNo");//地推用户编号
        String distributionUser = data.getString("distributionUser");//人工下单用户
        String checkCode = MakeOrderNum.checkSixCode();
        Date nowDate = new Date();
        orderSpotDO.setPayType(data.getString("payType"));
        orderSpotDO.setPayStatus(data.getString("payStatus"));
        orderSpotDO.setPurchaseTime(nowDate);
        orderSpotDO.setConsumptionTime(nowDate);
        orderSpotDO.setPushUserNo(pushUserNo);
        orderSpotDO.setDistributionUser(distributionUser);
        orderSpotDO.setOrderVoucherno(checkCode);
        orderSpotDO.setIp(ip);
        //记录自助售票机编号
        if(Const.ORDER_SELF.equals(type)){
            orderSpotDO.setSelfMachineNo(data.getString("selfMachineNo"));
        }else{
            orderSpotDO.setPayStatus(data.getString("payStatus"));
        }
        orderSpotDO.setOrderStatus("004001");
        orderSpotDO.setRefundStatus("002001");
        orderSpotDO.setOrderDistributor(cooperationDistributionDO.getDistributionNo());
        return  orderSpotDO;
    }

    @Override
    public ResultMsg checkRepeatSubmit(RequestVo requestVo) {
        String data = requestVo.getData();
        if(StringUtils.isBlank(data)){
            return ResultMsg.getResultMsg(ApiEnum.paramError.code,ApiEnum.paramError.msg);
        }
        JSONObject json =null;
        try {
            json = JSONObject.parseObject(data);
        } catch (Exception e) {
            return ResultMsg.getResultMsg(ApiEnum.jsonException.code,ApiEnum.jsonException.msg);
        }
        String orderNocheck = json.getString("orderNo")+requestVo.getCid();
        if(orderNoApply.containsKey(orderNocheck)){
            long oldTime = (Long)orderNoApply.get(orderNocheck);
            if(new Date().getTime()-oldTime<1000*10){
                logger.debug("购票：订单号重复提交！");
                return ResultMsg.getResultMsg(ApiEnum.paramError.code,"订单号重复提交！");
            }else{
                orderNoApply.clear();
                orderNoApply.put(orderNocheck,new Date().getTime());
            }
        }else{
            orderNoApply.clear();
            orderNoApply.put(orderNocheck,new Date().getTime());
        }
        logger.debug("购票：重复提交检测==》通过检测");
        json.put("cid",requestVo.getCid());
        json.put("distributionNo",requestVo.getDistributionNo());
        return ResultMsg.getOK(json);
    }

    @Override
    public void saveSecondOrder(OrderSpotDO pd, String type) {

    }

    @Override
    public String checkInsertOrder(RequestVo requestVo, String type) throws Exception{
        JSONObject json = JSONObject.parseObject(requestVo.getData());
        CooperationDistributionDO rsp = requestVo.getCooperationDistributionDO();
        ResultMsg resultMsg = orderCheck(json,rsp,type);
        if(!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code())) return commonService.getError(resultMsg.getReturn_code(),resultMsg.getReturn_msg());
        return "success";
    }
}
