package com.ecotourism.mobile.mobile.service;

import com.ecotourism.mobile.mobile.domain.OrderCustomerIdCardDO;

import java.util.List;

public interface OrderCustomerIdCardService {
    void saveCustomerIdCard(OrderCustomerIdCardDO params);
    List<OrderCustomerIdCardDO> getCustomerIdCardList(String openid);
}
