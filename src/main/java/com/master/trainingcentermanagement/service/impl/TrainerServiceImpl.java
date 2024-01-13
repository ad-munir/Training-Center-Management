package com.master.trainingcentermanagement.service.impl;

import com.master.trainingcentermanagement.dto.CourseDto;
import com.master.trainingcentermanagement.dto.TrainerDto;
import com.master.trainingcentermanagement.entity.Course;
import com.master.trainingcentermanagement.service.TrainerService;
import com.master.trainingcentermanagement.user.Role;
import com.master.trainingcentermanagement.user.User;
import com.master.trainingcentermanagement.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;


    @Override
    public Long saveTrainer(TrainerDto trainer) {

        User user = modelMapper.map(trainer, User.class);
        user = userRepo.save(user);

        return user.getId() ; //modelMapper.map(crs, CourseDto.class);
    }
    @Override
    public List<TrainerDto> listTrainers() {


        List<TrainerDto> dtoList = new ArrayList<>();
        for (User entity: userRepo.findAll()) {
            if (entity.getRole() == Role.TRAINER)
                dtoList.add( new TrainerDto(
                        entity.getFirstname(),
                        entity.getLastname(),
                        entity.getEmail(),
                        entity.getPhone(),
                        entity.getKeywords(),
                        entity.getImage(),
                        entity.getRole())
                );}      //modelMapper.map(trainer, TrainerDto.class)

        return dtoList;
    }

    @Override
    public void deleteTrainer(Long id) {
        userRepo.deleteById(id);
    }
}
