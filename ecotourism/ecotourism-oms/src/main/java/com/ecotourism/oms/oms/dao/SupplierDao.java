package com.ecotourism.oms.oms.dao;

import com.ecotourism.oms.oms.domain.SupplierDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 供应商管理
 * @author 陈启勇
 * @email 1992lcg@163.com
 * @date 2018-06-04 21:48:30
 */
@Mapper
public interface SupplierDao {

	SupplierDO get(String supplierNo);

}
