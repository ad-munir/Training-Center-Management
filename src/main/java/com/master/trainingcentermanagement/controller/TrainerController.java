package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.dto.TrainerDto;
import com.master.trainingcentermanagement.service.impl.TrainerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/trainers")
public class TrainerController {

    @Autowired
    TrainerServiceImpl userService;


    @GetMapping
    public List<TrainerDto> listTrainers(){

        return userService.listTrainers();
    }

    @DeleteMapping("/{id}")
    public void  deleteTrainer(@PathVariable Long id){
        userService.deleteTrainer(id);
    }




}
