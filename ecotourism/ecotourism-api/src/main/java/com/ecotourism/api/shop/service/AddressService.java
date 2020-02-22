package com.ecotourism.api.shop.service;

import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.shop.domain.AddressDO;
import org.springframework.data.annotation.Transient;
import org.springframework.transaction.annotation.Transactional;

/**
 * 收货地址管理
 * @date 2018-09-19 15:08:27
 */
public interface AddressService {
	int save(AddressDO address);
	int update(AddressDO address);

	/**
	 * @Description 获取默认收货地址
	 * @author 陈启勇
	 * @Date 2018/9/19 15:36
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	R getDefault(RequestVo requestVo);

	/**
	 * @Description 默认收货地址设置
	 * @author 陈启勇
	 * @Date 2018/9/19 15:36
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	R updateDefault(RequestVo requestVo);
	/**
	 * @Description 删除收货地址
	 * @author 陈启勇
	 * @Date 2018/9/19 15:36
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	R deleteAddress(RequestVo requestVo);
	/**
	 * @Description 获取收货地址列表
	 * @author 陈启勇
	 * @Date 2018/9/19 15:36
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	R listAddress(RequestVo requestVo);

	/**
	 * @Description 增加或修改地址
	 * @author 陈启勇
	 * @Date 2018/9/19 15:47
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	R saveOrUpdate(RequestVo requestVo);
	/**
	 * @Description 获取收货地址
	 * @author 陈启勇
	 * @Date 2018/9/19 15:36
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	R get(RequestVo requestVo);
}
