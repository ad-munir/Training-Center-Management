package com.master.trainingcentermanagement.service;

import com.master.trainingcentermanagement.dto.ParticipantDto;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ParticipantService {

    ParticipantDto saveParticipant(ParticipantDto participant) ;

    List<ParticipantDto> listParticipants() ;

    void deleteParticipant(Long id) ;

    ResponseEntity<String> assignToCourse(Long id);

    ParticipantDto getParticipantById(Long id);
}
