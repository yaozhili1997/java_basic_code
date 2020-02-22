package com.ecotourism.api.product.service;

import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.product.domain.ProductDO;
import java.util.List;
import java.util.Map;

/**
 * 景区门票
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-23 16:31:01
 */
public interface ProductService {
	ProductDO getByPriceStock(String productNo,String playTime);
	ProductDO get(String productNo);
	/**
	 * @Description 获取产品
	 * @author 陈启勇
	 * @Date 2018/8/29 15:18
	 * @Param [productNo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	R getProduct(RequestVo requestVo);

	/**
	 * @Description 获取产品列表
	 * @author 陈启勇
	 * @Date 2018/8/29 15:54
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	R listProducts(RequestVo requestVo);
}
