package com.master.trainingcentermanagement.service;

import com.master.trainingcentermanagement.entity.Feedback;

import java.util.List;


public interface FeedbackService {


    public Feedback saveFeedback(Feedback feedback) ;

    public List<Feedback> listfeedback();

    public void deletefeedback(Long id) ;
}
