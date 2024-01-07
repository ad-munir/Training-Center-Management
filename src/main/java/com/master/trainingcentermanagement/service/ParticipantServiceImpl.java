package com.master.trainingcentermanagement.service;

import com.master.trainingcentermanagement.Repository.ParticipantRepo;
import com.master.trainingcentermanagement.entity.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParticipantServiceImpl {


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
