package com.ecotourism.mobile.mobile.service;

import com.ecotourism.mobile.mobile.domain.ProductCollectionDO;

import java.util.List;

public interface ProductCollectionService {
    List<ProductCollectionDO> getProductCollectionByOpenId(String openId);
    ProductCollectionDO getProductCollectionByProductNo(String openId, String productNo);
    void addCollection(String openId, String productNo);
    void deleteCollection(String openId, String productNo);
    List<ProductCollectionDO> getCollectionByPage(String openId, int pageNumber, int pageSize);
}
