package com.ecotourism.api.shop.dao;

import com.ecotourism.api.api.domain.shop.address.AddressSetDefaultParams;
import com.ecotourism.api.api.domain.shop.address.ListAddressRequestParams;
import com.ecotourism.api.shop.domain.AddressDO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressDao {


	List<AddressDO> list(ListAddressRequestParams param);
	AddressDO getDefault(AddressDO address);
	AddressDO get(AddressDO address);
	int save(AddressDO address);
	int updateDefault(AddressSetDefaultParams param);
	int clearnDefault(AddressSetDefaultParams param);
	int remove(AddressSetDefaultParams param);
	int update(AddressDO address);
}
