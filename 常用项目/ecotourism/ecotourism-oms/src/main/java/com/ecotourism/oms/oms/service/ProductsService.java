package com.ecotourism.oms.oms.service;

import com.ecotourism.oms.oms.domain.RequestVo;
import com.ecotourism.oms.oms.domain.SpotTicketDO;

import java.util.List;

public interface ProductsService {

    String getProductsInfo(RequestVo requestVo);

    List<SpotTicketDO> getProducts(RequestVo requestVo);
}
