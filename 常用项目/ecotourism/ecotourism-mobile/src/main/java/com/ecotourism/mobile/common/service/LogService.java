package com.ecotourism.mobile.common.service;

import com.ecotourism.mobile.common.domain.LogDO;
import com.ecotourism.mobile.common.domain.PageDO;
import com.ecotourism.mobile.common.utils.Query;
import org.springframework.stereotype.Service;

@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
