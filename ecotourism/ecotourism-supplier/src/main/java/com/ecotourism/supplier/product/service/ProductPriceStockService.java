package com.ecotourism.supplier.product.service;

import com.ecotourism.supplier.product.domain.ProductPriceStockDO;

import java.util.List;

public interface ProductPriceStockService {
    void saveProductPriceStock(ProductPriceStockDO params, String dates);
    List<ProductPriceStockDO> getProductPriceStockByDates(String productNo, List<String> dates);
    int deleteProductPriceStockByDates(String productNo, List<String> dates);
}
