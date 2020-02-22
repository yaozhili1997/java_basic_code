package com.ecotourism.api.exception.dao;

import com.ecotourism.api.exception.domain.ExceptionDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 异常信息记录
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-20 18:04:38
 */
@Mapper
public interface ExceptionDao {

	int save(ExceptionDO exception);
}
