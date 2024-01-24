package com.master.trainingcentermanagement.controller;


import com.master.trainingcentermanagement.dto.FeedbackDto;
import com.master.trainingcentermanagement.service.impl.FeedbackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feedbacks")
@CrossOrigin("http://localhost:4200")
public class FeedbackController {

    @Autowired
    FeedbackServiceImpl feedbackService;
    @PostMapping
    public FeedbackDto addFeedback(@RequestBody FeedbackDto feedback){
        return feedbackService.saveFeedback(feedback);

    }

    @GetMapping
    public List<FeedbackDto> listFeedbacks(){

        return feedbackService.listFeedbacks();
    }

    @DeleteMapping("/{id}")
    public void  deleteFeedback(@PathVariable Long id){
        feedbackService.deletefeedback(id);
    }

}
