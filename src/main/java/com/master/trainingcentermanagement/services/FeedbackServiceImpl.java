package com.master.trainingcentermanagement.services;

import com.master.trainingcentermanagement.Repositories.FeedbackRepo;
import com.master.trainingcentermanagement.entities.Feedback;
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
