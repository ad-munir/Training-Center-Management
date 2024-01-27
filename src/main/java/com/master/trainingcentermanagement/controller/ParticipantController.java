package com.master.trainingcentermanagement.controller;


import com.master.trainingcentermanagement.dto.ParticipantDto;
import com.master.trainingcentermanagement.entity.Participant;
import com.master.trainingcentermanagement.service.impl.ParticipantServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/v1/participants")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantServiceImpl participantService;

    @PostMapping("assign/{id}")
    public ResponseEntity<String> assignToCourse(@PathVariable Long id){

        participantService.assignToCourse(id);
        return ResponseEntity.ok("Participant[id: "+ id +"] assigned to the course");
    }

    @PostMapping
    public ParticipantDto saveParticipant(@RequestBody ParticipantDto participant){
        return participantService.saveParticipant(participant);
    }

    @GetMapping
    public List<ParticipantDto> listParticipants(){

        return participantService.listParticipants();
    }

    @GetMapping("/{id}")
    public ParticipantDto getParticipantById(@PathVariable Long id){
        System.out.println("the is is :"+id);
        return participantService.getParticipantById(id);
    }

    @DeleteMapping("/{id}")
    public void  deleteParticipant(@PathVariable Long id){
        participantService.deleteParticipant(id);
    }
}
