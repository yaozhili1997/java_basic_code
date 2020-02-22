package com.ecotourism.supplier.product.dao;

import com.ecotourism.supplier.product.domain.ProductPriceStockDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductPriceStockDao {
    ProductPriceStockDO get(@Param("productNo") String productNo, @Param("date") String date);
    int save(ProductPriceStockDO params);
    int update(ProductPriceStockDO params);
    int remove(@Param("productNo") String productNo, @Param("date") String date);
    List<ProductPriceStockDO> getProductPriceStockByDates(@Param("productNo") String productNo, @Param("dates") List<String> dates);
    int deleteProductPriceStockByDates(@Param("productNo") String productNo, @Param("dates") List<String> dates);
}
