package com.master.trainingcentermanagement.services;

import com.master.trainingcentermanagement.entities.Feedback;

import java.util.List;


public interface FeedbackService {


    public Feedback saveFeedback(Feedback feedback) ;

    public List<Feedback> listfeedback();

    public void deletefeedback(Long id) ;
}
