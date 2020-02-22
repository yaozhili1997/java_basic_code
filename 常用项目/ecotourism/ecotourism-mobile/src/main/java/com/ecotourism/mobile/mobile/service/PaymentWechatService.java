package com.ecotourism.mobile.mobile.service;

import com.ecotourism.mobile.mobile.domain.PaymentWechatDO;

public interface PaymentWechatService {
    PaymentWechatDO getPaymentWechatByUserNo(String userNo);
}
