package com.ecotourism.mobile.mobile.service.impl;

import com.ecotourism.mobile.mobile.dao.ProductCollectionDao;
import com.ecotourism.mobile.mobile.domain.ProductCollectionDO;
import com.ecotourism.mobile.mobile.service.ProductCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCollectionServiceImpl implements ProductCollectionService {

    @Autowired
    private ProductCollectionDao productCollectionDao;

    public List<ProductCollectionDO> getProductCollectionByOpenId(String openId) {
       return productCollectionDao.get(openId, null);
    }

    public ProductCollectionDO getProductCollectionByProductNo(String openId, String productNo) {
       List<ProductCollectionDO> list = productCollectionDao.get(openId, productNo);
       if (list.size() > 0) {
           return list.get(0);
       } else {
           return null;
       }
    }

    public void addCollection(String openId, String productNo) {
        productCollectionDao.insert(openId, productNo);
    }

    public void deleteCollection(String openId, String productNo) {
        productCollectionDao.remove(openId, productNo);
    }

    public List<ProductCollectionDO> getCollectionByPage(String openId, int pageNumber, int pageSize) {
        if (pageNumber < 1) {
            pageNumber = 1;
        }
        return productCollectionDao.getList(openId, (pageNumber - 1) * pageSize, pageSize);
    }
}
