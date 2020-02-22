package com.ecotourism.api.shop.service.impl;

import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.api.domain.common.OpenIdRequestParams;
import com.ecotourism.api.api.domain.shop.car.*;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.common.utils.StringUtils;
import com.ecotourism.api.shop.dao.ShoppingCartDao;
import com.ecotourism.api.shop.domain.ShoppingCartDO;
import com.ecotourism.api.shop.domain.ShoppingCartUserDO;
import com.ecotourism.api.shop.service.ShoppingCartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Autowired
	private ShoppingCartDao shoppingCartDao;

	@Override
	public int save(ShoppingCartDO shoppingCart){
		return shoppingCartDao.save(shoppingCart);
	}

	/**
	 * @Description 通过openId和产品编号获取购物车数据
	 * @author 陈启勇
	 * @Date 2018/9/17 17:20
	 * @Param [shoppingCartDO]
	 * @return com.ecotourism.api.shop.domain.ShoppingCartDO
	 */
	public ShoppingCartDO getShopCar(ShoppingCartDO  shoppingCartDO){
		return shoppingCartDao.getShopCar(shoppingCartDO);
	}

	/**
	 * @Description 查询购物车数据列表
	 * @author 陈启勇
	 * @Date 2018/9/18 15:53
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	public R listShopCars(RequestVo requestVo){
		ShopCarListRequestParams param = (ShopCarListRequestParams) requestVo.getParamsVo();
		param.setApplicationNo(requestVo.getApplicationNo());
		Integer pageNumber = param.getPageNumber();
		Integer pageSize = param.getPageSize();
		if(pageNumber!=null && pageSize!=null){
			int start = (pageNumber-1)*pageSize;
			param.setPageNumber(start);
		}
		List<ShoppingCartDO> list = shoppingCartDao.list(param);
		return R.ok(list);
	}
	/**
	 * @Description 删除购物车产品
	 * @author 陈启勇
	 * @Date 2018/9/18 15:53
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	@Transactional
	public R deleteShopCar(RequestVo requestVo){
		DeleteShopCarParams param = (DeleteShopCarParams) requestVo.getParamsVo();
		param.setApplicationNo(requestVo.getApplicationNo());
		shoppingCartDao.deleteShopCar(param);
		return R.ok();
	}

	/**
	 * @Description 获取购物车总数量
	 * @author 陈启勇
	 * @Date 2019/3/4 18:04
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	public R getShopCarTotalCount(RequestVo requestVo){
		OpenIdRequestParams param = (OpenIdRequestParams) requestVo.getParamsVo();
		param.setApplicationNo(requestVo.getApplicationNo());
		int shopCarTotalCount = shoppingCartDao.getShopCarTotalCount(param);
		return R.ok(shopCarTotalCount);
	}

	/**
	 * @Description 修改购物车产品
	 * @author 陈启勇
	 * @Date 2018/9/18 15:53
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	@Transactional
	public R updateShopCar(RequestVo requestVo){
		ShopCarUpdateParam param = (ShopCarUpdateParam) requestVo.getParamsVo();
		param.setApplicationNo(requestVo.getApplicationNo());
		shoppingCartDao.updateCartData(param);
		String id1 = param.getId();
		shoppingCartDao.deleteShopCarUser(id1);
		List<ShopCarUserParam> users = param.getUsers();
		for (ShopCarUserParam user : users) {
			ShoppingCartUserDO shoppingCartUserDO = new ShoppingCartUserDO();
			shoppingCartUserDO.setShopCarId(id1);
			BeanUtils.copyProperties(user,shoppingCartUserDO);
			shoppingCartDao.saveShopCarUser(shoppingCartUserDO);
		}
		return R.ok();
	}
	/**
	 * @Description 购物车增加或修改
	 * @author 陈启勇
	 * @Date 2018/9/17 11:32
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	@Transactional
	public R saveShopCar(RequestVo requestVo){
		ShopCarSaveOrUpdateRequestParams param = (ShopCarSaveOrUpdateRequestParams) requestVo.getParamsVo();
		List<ShopCarSaveOrUpdateRequestParams.ShopCarDo> data = param.getData();
		String openId = param.getOpenId();
		String applicationNo = requestVo.getApplicationNo();
		String ids="";
		for (ShopCarSaveOrUpdateRequestParams.ShopCarDo datum : data) {
			ShoppingCartDO shoppingCartDO = new ShoppingCartDO();
			BeanUtils.copyProperties(datum,shoppingCartDO);
			shoppingCartDO.setOpenId(openId);
			shoppingCartDO.setApplicationNo(applicationNo);
			List<ShopCarUserParam> users = datum.getUsers();
			shoppingCartDao.save(shoppingCartDO);
			String id = String.valueOf(shoppingCartDO.getId());
			for (ShopCarUserParam usersParam : users) {
				ShoppingCartUserDO shoppingCartUserDO = new ShoppingCartUserDO();
				shoppingCartUserDO.setShopCarId(id);
				BeanUtils.copyProperties(usersParam,shoppingCartUserDO);
				shoppingCartDao.saveShopCarUser(shoppingCartUserDO);
			}
			if(StringUtils.isBlank(ids)){
				ids = id;
			}else{
				ids +=","+id;
			}

		}
		return R.ok(ids);
	}




}
