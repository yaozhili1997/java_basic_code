package com.ecotourism.oms.common.service;

import com.ecotourism.oms.common.domain.LogDO;
import com.ecotourism.oms.common.domain.PageDO;
import com.ecotourism.oms.common.utils.Query;
import org.springframework.stereotype.Service;

@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
