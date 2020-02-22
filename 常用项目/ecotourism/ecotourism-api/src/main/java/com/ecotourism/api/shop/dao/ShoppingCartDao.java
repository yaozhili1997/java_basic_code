package com.ecotourism.api.shop.dao;

import com.ecotourism.api.api.domain.common.OpenIdRequestParams;
import com.ecotourism.api.api.domain.shop.car.DeleteShopCarParams;
import com.ecotourism.api.api.domain.shop.car.ShopCarListRequestParams;
import com.ecotourism.api.api.domain.shop.car.ShopCarUpdateParam;
import com.ecotourism.api.shop.domain.ShoppingCartDO;
import com.ecotourism.api.shop.domain.ShoppingCartUserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 购物车表
 * @author 陈启勇
 * @date 2018-09-17 10:50:11
 */
@Mapper
public interface ShoppingCartDao {

	ShoppingCartDO getShopCar(ShoppingCartDO  shoppingCartDO);

	List<ShoppingCartDO> list(ShopCarListRequestParams param);

	int getCount(ShoppingCartDO  shoppingCartDO);
	int getShopCarTotalCount(OpenIdRequestParams param);
	int getShopCarUserCount(ShoppingCartUserDO shoppingCartUserDO);
	int save(ShoppingCartDO shoppingCart);
	int saveShopCarUser(ShoppingCartUserDO shoppingCartUserDO);
	int updateCartData(ShopCarUpdateParam param);
	int updateCartUserData(ShoppingCartUserDO shoppingCartUserDO);
	int deleteShopCar(DeleteShopCarParams param);
	int deleteShopCarUser(String shopCarId);
}
