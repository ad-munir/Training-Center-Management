package com.master.trainingcentermanagement.service;

import com.master.trainingcentermanagement.dto.FeedbackDto;

import java.util.List;


public interface FeedbackService {


    FeedbackDto saveFeedback(FeedbackDto feedback) ;

    List<FeedbackDto> listFeedbacks();

    void deletefeedback(Long id) ;
}
