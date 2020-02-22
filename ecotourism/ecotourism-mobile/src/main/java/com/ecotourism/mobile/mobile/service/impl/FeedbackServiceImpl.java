package com.ecotourism.mobile.mobile.service.impl;

import com.ecotourism.mobile.mobile.dao.FeedbackDao;
import com.ecotourism.mobile.mobile.domain.FeedbackDO;
import com.ecotourism.mobile.mobile.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackDao feedbackDao;

    public void saveFeedback(FeedbackDO param) {
        feedbackDao.insert(param);
    }
}
