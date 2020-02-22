package com.ecotourism.api.shop.service;

import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.shop.domain.ShoppingCartDO;
import org.springframework.data.annotation.Transient;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 购物车表
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-09-17 10:50:11
 */
public interface ShoppingCartService {
	
	int save(ShoppingCartDO shoppingCart);
	/**
	 * @Description 通过openId和产品编号获取购物车数据
	 * @author 陈启勇
	 * @Date 2018/9/17 17:20
	 * @Param [shoppingCartDO]
	 * @return com.ecotourism.api.shop.domain.ShoppingCartDO
	 */
	ShoppingCartDO getShopCar(ShoppingCartDO  shoppingCartDO);
	/**
	 * @Description 购物车增加
	 * @author 陈启勇
	 * @Date 2018/9/17 11:32
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	R saveShopCar(RequestVo requestVo);

	/**
	 * @Description 查询购物车数据列表
	 * @author 陈启勇
	 * @Date 2018/9/18 15:53
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	R listShopCars(RequestVo requestVo);

	/**
	 * @Description 删除购物车产品
	 * @author 陈启勇
	 * @Date 2018/9/18 15:53
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	R deleteShopCar(RequestVo requestVo);
	/**
	 * @Description 修改购物车产品
	 * @author 陈启勇
	 * @Date 2018/9/18 15:53
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	R updateShopCar(RequestVo requestVo);

	/**
	 * @Description 获取购物车总数量
	 * @author 陈启勇
	 * @Date 2019/3/4 18:04
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	R getShopCarTotalCount(RequestVo requestVo);
}
