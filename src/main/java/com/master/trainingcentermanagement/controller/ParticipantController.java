package com.master.trainingcentermanagement.controller;


<<<<<<< HEAD
import com.master.trainingcentermanagement.dto.ParticipantDto;
import com.master.trainingcentermanagement.service.impl.ParticipantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/participants")

public class ParticipantController {

    @Autowired
    ParticipantServiceImpl participantService;

    @PostMapping
    public ParticipantDto saveParticipant(@RequestBody ParticipantDto participant){
        return participantService.saveParticipant(participant);

    }

    @GetMapping
    public List<ParticipantDto> listParticipants(){

        return participantService.listParticipants();
    }

    @DeleteMapping("/{id}")
    public void  deleteParticipant(@PathVariable Long id){
        participantService.deleteParticipant(id);
    }
=======
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParticipantController {
>>>>>>> a4269e8 (commant 2 cree service)
}
