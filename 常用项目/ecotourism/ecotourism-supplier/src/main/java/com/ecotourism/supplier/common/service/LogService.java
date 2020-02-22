package com.ecotourism.supplier.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecotourism.supplier.common.domain.LogDO;
import com.ecotourism.supplier.common.domain.PageDO;
import com.ecotourism.supplier.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
