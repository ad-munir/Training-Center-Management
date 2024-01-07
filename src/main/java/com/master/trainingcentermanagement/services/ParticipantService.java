package com.master.trainingcentermanagement.services;

import com.master.trainingcentermanagement.Repositories.ParticipantRepo;
import com.master.trainingcentermanagement.entities.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ParticipantService {



    public Participant saveParticipant(Participant feedback) ;

    public List<Participant> listParticipant() ;

    public void deleteParticipant(Long id) ;
}
