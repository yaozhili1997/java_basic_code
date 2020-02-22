package com.ecotourism.manage.report.dao;

import com.ecotourism.manage.report.domain.SaleTicketDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 景区门票
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-06 21:36:20
 */
@Mapper
public interface SpotOrderReadDao {
	
	List<SaleTicketDO> getTodaySaleTotal(Map<String, Object> map);
}
