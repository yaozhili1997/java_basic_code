package com.ecotourism.manage.report.dao;

import com.ecotourism.manage.report.domain.CarReportDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 设备表
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-07-09 19:17:58
 */
@Mapper
public interface CarReportReadDao {
	
	List<CarReportDO> getTodayDeviceTotal(Map<String, Object> map);
}
