package com.ecotourism.manage.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecotourism.manage.common.domain.LogDO;
import com.ecotourism.manage.common.domain.PageDO;
import com.ecotourism.manage.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
