package com.master.trainingcentermanagement.service;

import com.master.trainingcentermanagement.dto.TrainerDto;

import java.util.List;

public interface TrainerService {


    List<TrainerDto> listTrainers();

    void deleteTrainer(Long id);
}
