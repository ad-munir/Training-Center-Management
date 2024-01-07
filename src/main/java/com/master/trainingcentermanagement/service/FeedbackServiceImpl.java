package com.master.trainingcentermanagement.service;

import com.master.trainingcentermanagement.Repository.FeedbackRepo;
import com.master.trainingcentermanagement.entity.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl {

    @Autowired
    FeedbackRepo feedbackRepo;

    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepo.save(feedback);
    }

    public List<Feedback> listfeedback() {
        return feedbackRepo.findAll();
    }

    public void deletefeedback(Long id) {
        feedbackRepo.deleteById(id);
    }
}
