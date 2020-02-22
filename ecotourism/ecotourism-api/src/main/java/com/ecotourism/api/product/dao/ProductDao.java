package com.ecotourism.api.product.dao;

import java.util.List;
import java.util.Map;

import com.ecotourism.api.api.domain.procuct.ListProductRequestParam;
import com.ecotourism.api.api.domain.procuct.ProductRequestParams;
import com.ecotourism.api.product.domain.ProductDO;
import com.ecotourism.api.product.domain.ProductPriceStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 景区门票
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-23 16:31:01
 */
@Mapper
public interface ProductDao {

	ProductDO get(String productNo);
	ProductDO getByPriceStock(@Param("productNo") String productNo,@Param("playTime") String playTime);
	/**
	 * @Description 查询产品价格/库存 日历
	 * @author 陈启勇
	 * @Date 2018/12/13 15:18
	 * @Param [productNo]
	 * @return com.ecotourism.api.product.domain.ProductPriceStock
	 */
	List<ProductPriceStock> listPriceStock(ProductRequestParams param);

	List<ProductDO> listSimple(ListProductRequestParam param);
}
