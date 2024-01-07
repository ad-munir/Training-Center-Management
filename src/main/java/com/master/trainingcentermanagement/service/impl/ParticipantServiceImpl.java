package com.master.trainingcentermanagement.service.impl;

import com.master.trainingcentermanagement.Repository.ParticipantRepo;
import com.master.trainingcentermanagement.dto.CompanyDTO;
import com.master.trainingcentermanagement.dto.FeedbackDTO;
import com.master.trainingcentermanagement.dto.ParticipantDTO;
import com.master.trainingcentermanagement.entity.Company;
import com.master.trainingcentermanagement.entity.Participant;
import com.master.trainingcentermanagement.service.ParticipantService;
import org.hibernate.Hibernate;
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

    public ParticipantDTO saveParticipant(ParticipantDTO participant) {

        Participant p = modelMapper.map(participant, Participant.class);
        p = participantRepo.save(p);


        return modelMapper.map(p, ParticipantDTO.class);
    }

    @Override
    public List<ParticipantDTO> listParticipants() {
        return participantRepo.findAll()
                .stream()
                .map(e -> modelMapper.map(e, ParticipantDTO.class))
                .collect(Collectors.toList());
    }

    public void deleteParticipant(Long id) {
        participantRepo.deleteById(id);
    }
}
