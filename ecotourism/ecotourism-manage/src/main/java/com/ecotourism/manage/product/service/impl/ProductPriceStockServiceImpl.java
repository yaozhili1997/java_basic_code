package com.ecotourism.manage.product.service.impl;

import com.ecotourism.manage.product.dao.ProductPriceStockDao;
import com.ecotourism.manage.product.dao.SpotTicketDao;
import com.ecotourism.manage.product.domain.ProductPriceStockDO;
import com.ecotourism.manage.product.domain.SpotTicketDO;
import com.ecotourism.manage.product.service.ProductPriceStockService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductPriceStockServiceImpl implements ProductPriceStockService {

    @Autowired
    private ProductPriceStockDao productPriceStockDao;
    @Autowired
    private SpotTicketDao spotTicketDao;

    public void saveProductPriceStock(ProductPriceStockDO params, String dates) {
        SpotTicketDO spotTicketDO = new SpotTicketDO();
        spotTicketDO.setUpdateTime(params.getUpdateTime());
        spotTicketDO.setUpdateUser(params.getUpdateUser());
        spotTicketDO.setProductNo(params.getProductNo());
        spotTicketDO.setStockType(params.getStockType());
        spotTicketDO.setTotalStockNum(params.getTotalStockNum());

        spotTicketDao.updateTotalStockNum(spotTicketDO);
        if (StringUtils.isNotEmpty(dates)) {
            String[] dateArr = dates.split(",");
            for (String date : dateArr) {
                ProductPriceStockDO entity = productPriceStockDao.get(params.getProductNo(), date);
                if (entity == null) {
                    entity = new ProductPriceStockDO();
                    entity.setCreateTime(new Date());
                    entity.setCreateUser(params.getUpdateUser());
                    entity.setProductNo(params.getProductNo());
                    entity.setDate(date);
                    entity.setSaleNum(0);
                }
                entity.setStockNum(params.getStockNum());
                entity.setSalePrice(params.getSalePrice());
                entity.setSettlementPrice(params.getSettlementPrice());
                entity.setUpdateTime(params.getUpdateTime());
                entity.setUpdateUser(params.getUpdateUser());
                if (entity.getId() != 0) {
                    productPriceStockDao.update(entity);
                } else {
                    productPriceStockDao.save(entity);
                }
            }
        }

    }

    public List<ProductPriceStockDO> getProductPriceStockByDates(String productNo, List<String> dates) {
        return productPriceStockDao.getProductPriceStockByDates(productNo, dates);
    }

    public int deleteProductPriceStockByDates(String productNo, List<String> dates) {
        return productPriceStockDao.deleteProductPriceStockByDates(productNo, dates);
    }
}
