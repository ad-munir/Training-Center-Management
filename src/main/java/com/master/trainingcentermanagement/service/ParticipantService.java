package com.master.trainingcentermanagement.service;

import com.master.trainingcentermanagement.entity.Participant;

import java.util.List;


public interface ParticipantService {



    public Participant saveParticipant(Participant feedback) ;

    public List<Participant> listParticipant() ;

    public void deleteParticipant(Long id) ;
}
