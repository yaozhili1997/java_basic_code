package com.ecotourism.supplier.report.dao;

import com.ecotourism.supplier.common.utils.PageTotal;
import com.ecotourism.supplier.report.domain.LineReportDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-09 16:11:27
 */
@Mapper
public interface LineReportReadDao {
	
	List<LineReportDO> getTodayLineTotal(Map<String, Object> map);
	List<LineReportDO> getLineReport(Map<String, Object> map);
	int getLineReportCount(Map<String, Object> map);
	PageTotal getLineReportSum(Map<String, Object> map);

	List<LineReportDO> getCarReport(Map<String, Object> map);
	int getCarReportCount(Map<String, Object> map);
	PageTotal getCarReportSum(Map<String, Object> map);
}
