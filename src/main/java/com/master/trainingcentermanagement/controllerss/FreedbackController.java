package com.master.trainingcentermanagement.controllerss;


import com.master.trainingcentermanagement.entities.Feedback;
import com.master.trainingcentermanagement.services.FeedbackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FreedbackController {

    @Autowired
    FeedbackServiceImpl feedbackService;
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
