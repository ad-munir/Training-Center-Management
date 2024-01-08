package com.master.trainingcentermanagement.service;

import com.master.trainingcentermanagement.dto.ParticipantDto;

import java.util.List;


public interface ParticipantService {

    ParticipantDto saveParticipant(ParticipantDto participant) ;

    List<ParticipantDto> listParticipants() ;

    void deleteParticipant(Long id) ;
}
