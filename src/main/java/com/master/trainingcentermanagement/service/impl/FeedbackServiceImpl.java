package com.master.trainingcentermanagement.service.impl;

import com.master.trainingcentermanagement.entity.Participant;
import com.master.trainingcentermanagement.repository.FeedbackRepo;
import com.master.trainingcentermanagement.dto.FeedbackDto;
import com.master.trainingcentermanagement.entity.Feedback;
import com.master.trainingcentermanagement.repository.ParticipantRepo;
import com.master.trainingcentermanagement.service.FeedbackService;
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
    @Autowired
    ParticipantRepo participantRepo ;


    @Override
    public FeedbackDto saveFeedback(FeedbackDto feedback) {

        Long participantId = feedback.getParticipantId();
        Participant participant = participantRepo.findById(participantId).get();
        participant.setEvaluated(true);
        participant = participantRepo.save(participant);
        Feedback fdb = modelMapper.map(feedback, Feedback.class);
        fdb = feedbackRepo.save(fdb);


        return modelMapper.map(fdb, FeedbackDto.class);
    }

    @Override
    public List<FeedbackDto> listFeedbacks() {

        return feedbackRepo.findAll()
                .stream()
                .map(e -> modelMapper.map(e, FeedbackDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deletefeedback(Long id) {
        feedbackRepo.deleteById(id);
    }


}
