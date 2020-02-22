package com.ecotourism.supplier.print.service;

import com.ecotourism.supplier.print.domain.PrintImgDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-11-20 11:13:06
 */
public interface PrintImgService {
	
	PrintImgDO get(Long id);
	
	List<PrintImgDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PrintImgDO printImg);
	
	int update(PrintImgDO printImg);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
