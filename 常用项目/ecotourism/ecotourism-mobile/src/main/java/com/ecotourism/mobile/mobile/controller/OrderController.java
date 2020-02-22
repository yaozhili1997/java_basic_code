package com.ecotourism.mobile.mobile.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ecotourism.mobile.common.config.OrderApiUrlConfig;
import com.ecotourism.mobile.common.controller.BaseController;
import com.ecotourism.mobile.common.utils.HttpUtils;
import com.ecotourism.mobile.common.utils.R;
import com.ecotourism.mobile.common.utils.StringUtils;
import com.ecotourism.mobile.mobile.domain.OrderCustomerIdCardDO;
import com.ecotourism.mobile.mobile.domain.OrderDO;
import com.ecotourism.mobile.mobile.domain.QrDO;
import com.ecotourism.mobile.mobile.service.OrderCustomerIdCardService;
import com.ecotourism.mobile.mobile.service.QrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

    @Value("${ecotourism.wcProductType}")
    private String wcProductType;

    @Autowired
    private OrderApiUrlConfig orderApiUrlConfig;

    @Autowired
    private OrderCustomerIdCardService orderCustomerIdCardService;

    @Autowired
    private QrService qrService;

    @RequestMapping("/book")
    public String book(String productNo, String shoppingCarId, Model model) {
        model.addAttribute("productNo", productNo);
        model.addAttribute("shoppingCarId", shoppingCarId);
        model.addAttribute("wcProductType", wcProductType);
        try {
            JSONObject param = new JSONObject();
            param.put("productNo", productNo);
            String result = HttpUtils.postJson(orderApiUrlConfig.getProductUrl(), param.toString());
            JSONObject object = JSONObject.parseObject(result);
            if ("success".equals(object.getString("status"))) {
               JSONObject data = object.getJSONObject("data");
               String productType = data.getString("productType");
               // 如果产品类型为文创产品043004，则跳转文创产品订购页面
               if (wcProductType.equals(productType)) {
                   return "mobile/goods_book";
               } else {
                   return "mobile/bus_ticket_book";
               }
            } else {
                return "redirect:/index";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/index";
        }
    }

    @RequestMapping("/createOrder")
    @ResponseBody
    public R createOrder(String data) {
        try {
            JSONArray dataArr = JSONArray.parseArray(data);
            // 保存身份证信息
            for (int i = 0; i < dataArr.size(); i++) {
                JSONObject object = dataArr.getJSONObject(i);
                if (StringUtils.isNotEmpty(object.getString("customerUserId"))) {
                    OrderCustomerIdCardDO idCardDO = new OrderCustomerIdCardDO();
                    idCardDO.setName(object.getString("customerName"));
                    idCardDO.setIdcardNo(object.getString("customerUserId"));
                    idCardDO.setMobile(object.getString("customerPhone"));
                    idCardDO.setOpenid(getLoginOpenid());
                    orderCustomerIdCardService.saveCustomerIdCard(idCardDO);
                }
            }
            JSONObject param = new JSONObject();
            param.put("openId", getLoginOpenid());
            param.put("pushUserNo", request.getSession().getAttribute("pushUserNo"));
            param.put("data", dataArr);
            String result = HttpUtils.postJson(orderApiUrlConfig.getCreateOrderUrl(), param.toString());
            System.out.println(result);
            JSONObject object = JSONObject.parseObject(result);
            if ("success".equals(object.getString("status"))) {
                String orderNo = object.getJSONObject("data").getString("orderNo");
                return pay(orderNo);
            } else {
                return R.error(object.getString("errorMsg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    @RequestMapping("/pay")
    @ResponseBody
    public R pay(String orderNo) {
        try {
            String payResult = null;
            if (LOGIN_PLATFORM_ALIPAY.equals(getLoginPlatform())) {
                payResult = createAlipay(orderNo, getLoginOpenid());
            } else if (LOGIN_PLATFORM_WX.equals(getLoginPlatform())) {
                payResult = createWxPay(orderNo, getLoginOpenid());
            }
            System.out.println(payResult);
            if (payResult != null) {
                JSONObject object = JSONObject.parseObject(payResult);
                if ("success".equals(object.getString("status"))) {
                    R r = R.ok();
                    r.put("data", object);
                    r.put("orderNo", orderNo);
                    return r;
                } else {
                    return R.error(object.getString("errorMsg"));
                }
            } else {
                return R.error();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    @RequestMapping("/getCustomerIdCardList")
    @ResponseBody
    public R getCustomerIdCardList() {
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("list", orderCustomerIdCardService.getCustomerIdCardList(getLoginOpenid()));
            return R.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    @RequestMapping("/getOneCustomerIdCard")
    @ResponseBody
    public R getOneCustomerIdCard() {
        try {
            List list = orderCustomerIdCardService.getCustomerIdCardList(getLoginOpenid());
            Map<String, Object> data = new HashMap<>();
            if (list.size() > 0) {
                data.put("data", list.get(0));
            } else {
                data.put("data", null);
            }
            return R.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    private String createWxPay(String orderNo, String openId) throws Exception {
        JSONObject params = new JSONObject();
        params.put("orderNo", orderNo);
        params.put("openId", openId);
        return HttpUtils.postJson(orderApiUrlConfig.getWxPayUrl(), params.toString());
    }

    private String createAlipay(String orderNo, String openId) throws Exception {
        JSONObject params = new JSONObject();
        params.put("orderNo", orderNo);
        params.put("openId", openId);
        return HttpUtils.postJson(orderApiUrlConfig.getAlipayParams(), params.toString());
    }

    @RequestMapping("/list")
    public String orderList(){
        return "mobile/order_list";
    }

    @RequestMapping("/details")
    public String orderDetails(String orderNo, Model model) {
//        List<QrDO> list = qrService.queryOrderInfoList(orderNo);
        model.addAttribute("orderNo", orderNo);
        return "mobile/order_details";
    }

    @RequestMapping("/payResult")
    public String payResult(String orderNo, Model model) {
        model.addAttribute("orderNo", orderNo);
        return "mobile/pay_result";
    }

}
