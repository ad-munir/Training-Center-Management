package com.master.trainingcentermanagement.controller;


import com.master.trainingcentermanagement.entities.Course;
import com.master.trainingcentermanagement.entities.Feedback;
import com.master.trainingcentermanagement.services.CourceService;
import com.master.trainingcentermanagement.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FreedbackController {

    @Autowired
    FeedbackService feedbackService;
    @PostMapping("/addFeedback")
    public Feedback addFeedback(@RequestBody Feedback Feedback){
        return feedbackService.saveFeedback(Feedback);

    }

    @GetMapping("/findFeedback")
    public List<Feedback> findFeedback(){

        return feedbackService.listfeedback();
    }

    @DeleteMapping("deleteFeedback/{id}")
    public void  deleteFeedback(@PathVariable Long id){
        feedbackService.deletefeedback(id);
    }

}
