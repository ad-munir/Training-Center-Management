package com.master.trainingcentermanagement.controller;


import com.master.trainingcentermanagement.dto.ParticipantDTO;
import com.master.trainingcentermanagement.entity.Participant;
import com.master.trainingcentermanagement.service.impl.ParticipantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/participant")

public class ParticipantController {

    @Autowired
    ParticipantServiceImpl participantService;

    @PostMapping
    public ParticipantDTO saveParticipant(@RequestBody ParticipantDTO participant){
        return participantService.saveParticipant(participant);

    }

    @GetMapping
    public List<ParticipantDTO> listParticipants(){

        return participantService.listParticipants();
    }

    @DeleteMapping("/{id}")
    public void  deleteParticipant(@PathVariable Long id){
        participantService.deleteParticipant(id);
    }
}
