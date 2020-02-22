package com.ecotourism.api.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ecotourism.api.system.domain.RoleDO;

@Service
public interface RoleService {

	RoleDO get(Long id);

	List<RoleDO> list(Map<String, Object> map);

	int save(RoleDO role);

	int update(RoleDO role);

	int remove(Long id);

	List<RoleDO> list(Long userId);

	List<RoleDO> list(Long userId,Map<String, Object> map);

	int batchremove(Long[] ids);
}
