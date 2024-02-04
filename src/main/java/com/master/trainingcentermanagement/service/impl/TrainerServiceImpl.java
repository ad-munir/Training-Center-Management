package com.master.trainingcentermanagement.service.impl;

import com.master.trainingcentermanagement.dto.CourseDto;
import com.master.trainingcentermanagement.dto.TrainerDto;
import com.master.trainingcentermanagement.entity.Course;
import com.master.trainingcentermanagement.exception.errors.AppException;
import com.master.trainingcentermanagement.service.TrainerService;
import com.master.trainingcentermanagement.user.Role;
import com.master.trainingcentermanagement.user.User;
import com.master.trainingcentermanagement.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public TrainerDto getTrainerById(Long id) {
        User trainer = userRepo.findById(id).orElseThrow( () -> new AppException("Invalid trainer ID", HttpStatus.NO_CONTENT));
        return modelMapper.map(trainer, TrainerDto.class);
    }

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
                        entity.getId(),
                        entity.getFirstname(),
                        entity.getLastname(),
                        entity.getEmail(),
                        entity.getPhone(),
                        entity.getPassword(),
                        entity.getKeywords(),
                        entity.isActive(),
                        entity.getImage(),
                        entity.getRole(),
                        entity.getCourses())
                );
        }

        return dtoList;
    }

    @Override
    public void deleteTrainer(Long id) {
        userRepo.deleteById(id);
    }
}
