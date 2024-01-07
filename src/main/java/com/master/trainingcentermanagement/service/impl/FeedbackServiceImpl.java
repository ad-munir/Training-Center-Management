package com.master.trainingcentermanagement.service.impl;

import com.master.trainingcentermanagement.Repository.FeedbackRepo;
import com.master.trainingcentermanagement.dto.CompanyDTO;
import com.master.trainingcentermanagement.dto.FeedbackDTO;
import com.master.trainingcentermanagement.entity.Company;
import com.master.trainingcentermanagement.entity.Feedback;
import com.master.trainingcentermanagement.service.FeedbackService;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackRepo feedbackRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public FeedbackDTO saveFeedback(FeedbackDTO feedback) {

        Feedback fdb = modelMapper.map(feedback, Feedback.class);
        fdb = feedbackRepo.save(fdb);


        return modelMapper.map(fdb, FeedbackDTO.class);
    }

    @Override
    public List<FeedbackDTO> listFeedbacks() {

        return feedbackRepo.findAll()
                .stream()
                .map(e -> modelMapper.map(e,FeedbackDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deletefeedback(Long id) {
        feedbackRepo.deleteById(id);
    }


}
