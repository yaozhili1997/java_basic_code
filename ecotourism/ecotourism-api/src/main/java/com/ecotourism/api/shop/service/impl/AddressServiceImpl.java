package com.ecotourism.api.shop.service.impl;

import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.api.domain.common.OpenIdRequestParams;
import com.ecotourism.api.api.domain.shop.address.AddressSaveOrUpdateParams;
import com.ecotourism.api.api.domain.shop.address.AddressSetDefaultParams;
import com.ecotourism.api.api.domain.shop.address.ListAddressRequestParams;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.common.utils.StringUtils;
import com.ecotourism.api.shop.dao.AddressDao;
import com.ecotourism.api.shop.domain.AddressDO;
import com.ecotourism.api.shop.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao;

	@Override
	public int save(AddressDO address){
		return addressDao.save(address);
	}
	
	@Override
	public int update(AddressDO address){
		return addressDao.update(address);
	}

	/**
	 * @Description 获取默认收货地址
	 * @author 陈启勇
	 * @Date 2018/9/19 15:36
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	public R getDefault(RequestVo requestVo){
		OpenIdRequestParams param = (OpenIdRequestParams) requestVo.getParamsVo();
		AddressDO addressDO = new AddressDO();
		addressDO.setOpenId(param.getOpenId());
		addressDO.setApplicationNo(requestVo.getApplicationNo());
		AddressDO aDefault = addressDao.getDefault(addressDO);
		return R.ok(aDefault);
	}
	/**
	 * @Description 默认收货地址设置
	 * @author 陈启勇
	 * @Date 2018/9/19 15:36
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	@Transactional
	public R updateDefault(RequestVo requestVo){
		AddressSetDefaultParams param = (AddressSetDefaultParams) requestVo.getParamsVo();
		param.setApplicationNo(requestVo.getApplicationNo());
		addressDao.clearnDefault(param);
		addressDao.updateDefault(param);
		return R.ok();
	}
	/**
	 * @Description 删除收货地址
	 * @author 陈启勇
	 * @Date 2018/9/19 15:36
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	@Transactional
	public R deleteAddress(RequestVo requestVo){
		AddressSetDefaultParams param = (AddressSetDefaultParams) requestVo.getParamsVo();
		param.setApplicationNo(requestVo.getApplicationNo());
		addressDao.remove(param);
		return R.ok();
	}
	/**
	 * @Description 获取收货地址
	 * @author 陈启勇
	 * @Date 2018/9/19 15:36
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	public R get(RequestVo requestVo){
		AddressSetDefaultParams param = (AddressSetDefaultParams) requestVo.getParamsVo();
		AddressDO addressDO = new AddressDO();
		BeanUtils.copyProperties(param,addressDO);
		addressDO.setApplicationNo(requestVo.getApplicationNo());
		return R.ok(addressDao.get(addressDO));
	}
	/**
	 * @Description 获取收货地址列表
	 * @author 陈启勇
	 * @Date 2018/9/19 15:36
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	public R listAddress(RequestVo requestVo){
		ListAddressRequestParams param = (ListAddressRequestParams) requestVo.getParamsVo();
		param.setApplicationNo(requestVo.getApplicationNo());
		Integer pageNumber = param.getPageNumber();
		Integer pageSize = param.getPageSize();
		if(pageNumber!=null && pageSize!=null){
			int start = (pageNumber-1)*pageSize;
			param.setPageNumber(start);
		}
		List<AddressDO> list = addressDao.list(param);
		return R.ok(list);
	}

	/**
	 * @Description 增加或修改地址
	 * @author 陈启勇
	 * @Date 2018/9/19 15:47
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	@Transactional
	public R saveOrUpdate(RequestVo requestVo){
		AddressSaveOrUpdateParams param = (AddressSaveOrUpdateParams) requestVo.getParamsVo();
		AddressDO addressDO = new AddressDO();
		BeanUtils.copyProperties(param,addressDO);
		addressDO.setApplicationNo(requestVo.getApplicationNo());
		String addressNo = addressDO.getAddressNo();
		if(StringUtils.isBlank(addressNo)){
			AddressDO aDefault = addressDao.getDefault(addressDO);
			addressDO.setIsDefault("0");
			if(aDefault==null){
				addressDO.setIsDefault("1");
			}
			addressDO.setAddressNo(UUID.randomUUID().toString());
			addressDao.save(addressDO);
		}else{
			addressDao.update(addressDO);
		}
		return R.ok();
	}
}
