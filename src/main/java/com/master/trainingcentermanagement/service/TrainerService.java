package com.master.trainingcentermanagement.service;

import com.master.trainingcentermanagement.dto.CourseDto;
import com.master.trainingcentermanagement.dto.TrainerDto;

import java.util.List;

public interface TrainerService {

    TrainerDto getTrainerById(Long id);

    Long saveTrainer(TrainerDto trainer);

    List<TrainerDto> listTrainers();

    void deleteTrainer(Long id);
}
