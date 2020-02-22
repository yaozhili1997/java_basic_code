package com.ecotourism.api.common.service;

import org.springframework.stereotype.Service;

import com.ecotourism.api.common.domain.LogDO;
import com.ecotourism.api.common.domain.PageDO;
import com.ecotourism.api.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
