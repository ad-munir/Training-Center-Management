package com.master.trainingcentermanagement.service.impl;

import com.master.trainingcentermanagement.repository.ParticipantRepo;
import com.master.trainingcentermanagement.dto.ParticipantDto;
import com.master.trainingcentermanagement.entity.Participant;
import com.master.trainingcentermanagement.service.ParticipantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipantServiceImpl implements ParticipantService {


    @Autowired
    ParticipantRepo participantRepo;
    @Autowired
    private ModelMapper modelMapper;

    public ParticipantDto saveParticipant(ParticipantDto participant) {

        Participant p = modelMapper.map(participant, Participant.class);
        p = participantRepo.save(p);


        return modelMapper.map(p, ParticipantDto.class);
    }

    @Override
    public List<ParticipantDto> listParticipants() {
        return participantRepo.findAll()
                .stream()
                .map(e -> modelMapper.map(e, ParticipantDto.class))
                .collect(Collectors.toList());
    }

    public void deleteParticipant(Long id) {
        participantRepo.deleteById(id);
    }
}
