package com.ecotourism.supplier.system.service;

import com.ecotourism.supplier.system.domain.RoleDO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface RoleService {

	RoleDO get(Long id);

	List<RoleDO> list(Map<String, Object> map);

	int save(RoleDO role);

	int update(RoleDO role);

	int remove(Long id);

	List<RoleDO> list(Long userId);

	List<RoleDO> list(Long userId, Map<String, Object> map);

	int batchremove(Long[] ids);
}
