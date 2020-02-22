package com.ecotourism.api.product.service.impl;

import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.api.domain.procuct.ListProductRequestParam;
import com.ecotourism.api.api.domain.procuct.ProductRequestParams;
import com.ecotourism.api.application.domain.ApplicationDO;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.product.dao.ProductDao;
import com.ecotourism.api.product.domain.ProductDO;
import com.ecotourism.api.product.domain.ProductPriceStock;
import com.ecotourism.api.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	
	@Override
	public ProductDO get(String productNo){
		return productDao.get(productNo);
	}
	public ProductDO getByPriceStock(String productNo,String playTime){
		return productDao.getByPriceStock(productNo,playTime);
	}
	/**
	 * @Description 获取产品
	 * @author 陈启勇
	 * @Date 2018/8/29 15:18
	 * @Param [productNo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	public R getProduct(RequestVo requestVo){
		ProductRequestParams param = (ProductRequestParams) requestVo.getParamsVo();
		String productNo = param.getProductNo();
		ProductDO productDO = productDao.get(productNo);
		if(productDO!=null){
			String stockType = productDO.getStockType();
			if("2".equals(stockType)){
				List<ProductPriceStock> productPriceStocks = productDao.listPriceStock(param);
				productDO.setPriceStocks(productPriceStocks);
			}
		}
		return R.ok(productDO);
	}
	/**
	 * @Description 获取产品列表
	 * @author 陈启勇
	 * @Date 2018/8/29 15:54
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	public R listProducts(RequestVo requestVo){
		ListProductRequestParam param = (ListProductRequestParam) requestVo.getParamsVo();
		ApplicationDO applicationDO = requestVo.getApplicationDO();
		param.setDistributionNo(applicationDO.getDistributionNo());
		Integer pageNumber = param.getPageNumber();
		Integer pageSize = param.getPageSize();
		if(pageNumber!=null && pageSize!=null){
			int start = (pageNumber-1)*pageSize;
			param.setPageNumber(start);
		}
		List<ProductDO> list = productDao.listSimple(param);
		return R.ok(list);
	}
}
