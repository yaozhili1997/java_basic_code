package com.ecotourism.mobile.mobile.service;

import com.ecotourism.mobile.mobile.domain.PaymentAlipayDO;

public interface PaymentAlipayService {
    PaymentAlipayDO getPaymentAlipayByUserNo(String userNo);
}
