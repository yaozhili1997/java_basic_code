package com.ecotourism.mobile.mobile.service.impl;

import com.ecotourism.mobile.mobile.dao.PaymentAlipayDao;
import com.ecotourism.mobile.mobile.dao.PaymentWechatDao;
import com.ecotourism.mobile.mobile.domain.PaymentAlipayDO;
import com.ecotourism.mobile.mobile.domain.PaymentWechatDO;
import com.ecotourism.mobile.mobile.service.PaymentAlipayService;
import com.ecotourism.mobile.mobile.service.PaymentWechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentAlipayServiceImpl implements PaymentAlipayService {

    @Autowired
    private PaymentAlipayDao paymentAlipayDao;

    public PaymentAlipayDO getPaymentAlipayByUserNo(String userNo) {
        return paymentAlipayDao.getPaymentAlipayByUserNo(userNo);
    }
}
