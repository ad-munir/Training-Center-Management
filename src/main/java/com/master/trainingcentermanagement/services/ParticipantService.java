package com.master.trainingcentermanagement.services;

import com.master.trainingcentermanagement.Repositories.FeedbackRepo;
import com.master.trainingcentermanagement.Repositories.ParticipantRepo;
import com.master.trainingcentermanagement.entities.Feedback;
import com.master.trainingcentermanagement.entities.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParticipantService {


    @Autowired
    ParticipantRepo participantRepo;

    public Participant saveParticipant(Participant feedback) {

        return participantRepo.save(feedback);
    }

    public List<Participant> listParticipant() {
        return participantRepo.findAll();
    }

    public void deleteParticipant(Long id) {
        participantRepo.deleteById(id);
    }
}
