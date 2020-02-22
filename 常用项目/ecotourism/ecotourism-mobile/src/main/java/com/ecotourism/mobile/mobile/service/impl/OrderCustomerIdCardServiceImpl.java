package com.ecotourism.mobile.mobile.service.impl;

import com.ecotourism.mobile.mobile.dao.OrderCustomerIdCardDao;
import com.ecotourism.mobile.mobile.domain.OrderCustomerIdCardDO;
import com.ecotourism.mobile.mobile.service.OrderCustomerIdCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCustomerIdCardServiceImpl implements OrderCustomerIdCardService {

    @Autowired
    private OrderCustomerIdCardDao orderCustomerIdCardDao;

    public void saveCustomerIdCard(OrderCustomerIdCardDO params) {
        List<OrderCustomerIdCardDO> list = orderCustomerIdCardDao.findByIdCardNo(params.getIdcardNo(), params.getOpenid());
        if (list.size() > 0) {
            OrderCustomerIdCardDO entity = list.get(0);
            entity.setIdcardNo(params.getIdcardNo());
            entity.setName(params.getName());
            entity.setMobile(params.getMobile());
            orderCustomerIdCardDao.update(entity);
        } else {
            orderCustomerIdCardDao.insert(params);
        }
    }


    public List<OrderCustomerIdCardDO> getCustomerIdCardList(String openid) {
        return orderCustomerIdCardDao.getListByOpenid(openid);
    }
}
