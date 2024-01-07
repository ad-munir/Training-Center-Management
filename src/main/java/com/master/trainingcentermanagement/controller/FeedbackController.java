package com.master.trainingcentermanagement.controller;


import com.master.trainingcentermanagement.dto.FeedbackDTO;
import com.master.trainingcentermanagement.entity.Feedback;
import com.master.trainingcentermanagement.service.impl.FeedbackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feedback")

public class FeedbackController {

    @Autowired
    FeedbackServiceImpl feedbackService;
    @PostMapping
    public FeedbackDTO addFeedback(@RequestBody FeedbackDTO feedback){
        return feedbackService.saveFeedback(feedback);

    }

    @GetMapping
    public List<FeedbackDTO> listFeedbacks(){

        return feedbackService.listFeedbacks();
    }

    @DeleteMapping("/{id}")
    public void  deleteFeedback(@PathVariable Long id){
        feedbackService.deletefeedback(id);
    }

}
