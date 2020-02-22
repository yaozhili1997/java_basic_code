package com.ecotourism.mobile.mobile.service.impl;

import com.ecotourism.mobile.mobile.dao.PaymentWechatDao;
import com.ecotourism.mobile.mobile.domain.PaymentWechatDO;
import com.ecotourism.mobile.mobile.service.PaymentWechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentWechatServiceImpl implements PaymentWechatService {

    @Autowired
    private PaymentWechatDao paymentWechatDao;

    public PaymentWechatDO getPaymentWechatByUserNo(String userNo) {
        return paymentWechatDao.getPaymentWechatByUserNo(userNo);
    }
}
