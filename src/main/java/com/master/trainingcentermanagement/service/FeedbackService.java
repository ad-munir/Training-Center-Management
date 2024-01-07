package com.master.trainingcentermanagement.service;

import com.master.trainingcentermanagement.dto.FeedbackDTO;
import com.master.trainingcentermanagement.entity.Feedback;

import java.util.List;


public interface FeedbackService {


    FeedbackDTO saveFeedback(FeedbackDTO feedback) ;

    List<FeedbackDTO> listFeedbacks();

    void deletefeedback(Long id) ;
}
