package com.master.trainingcentermanagement.service;

import com.master.trainingcentermanagement.dto.ParticipantDTO;
import com.master.trainingcentermanagement.entity.Participant;

import java.util.List;


public interface ParticipantService {

    ParticipantDTO saveParticipant(ParticipantDTO participant) ;

    List<ParticipantDTO> listParticipants() ;

    void deleteParticipant(Long id) ;
}
