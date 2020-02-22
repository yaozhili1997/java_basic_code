package com.ecotourism.mobile.mobile.dao;

import com.ecotourism.mobile.mobile.domain.FeedbackDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedbackDao {
    void insert(FeedbackDO param);
}
