package com.ecotourism.manage.system.service;

import com.ecotourism.manage.common.domain.Tree;
import com.ecotourism.manage.system.domain.DeptDO;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2017-09-27 14:28:36
 */
public interface DeptService {
	
	DeptDO get(Long deptId);
	
	List<DeptDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DeptDO sysDept);
	
	int update(DeptDO sysDept);

	int updateCompany(DeptDO sysDept);
	
	int remove(Long deptId);
	
	int batchRemove(Long[] deptIds);

	Tree<DeptDO> getTree(Map<String, Object> map);
	
	boolean checkDeptHasUser(Long deptId);
}
