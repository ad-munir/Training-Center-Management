package com.master.trainingcentermanagement.controllerss;


import com.master.trainingcentermanagement.entities.Participant;
import com.master.trainingcentermanagement.services.ParticipantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParticipantController {
    @Autowired
    ParticipantServiceImpl participantService;
    @PostMapping("/addParticipant")
    public Participant addFeedback(@RequestBody Participant participant){
        return participantService.saveParticipant(participant);

    }

    @GetMapping("/findParticipant")
    public List<Participant> findFeedback(){

        return participantService.listParticipant();
    }

    @DeleteMapping("deleteParticipant/{id}")
    public void  deleteParticipant(@PathVariable Long id){
        participantService.deleteParticipant(id);
    }
}
