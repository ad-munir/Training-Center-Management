package com.master.trainingcentermanagement.service.impl;

import com.master.trainingcentermanagement.dto.TrainerDto;
import com.master.trainingcentermanagement.service.TrainerService;
import com.master.trainingcentermanagement.user.Role;
import com.master.trainingcentermanagement.user.User;
import com.master.trainingcentermanagement.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainerServiceImpl implements TrainerService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;


    @Override
    public List<TrainerDto> listTrainers() {

        List<TrainerDto> dtoList = new ArrayList<>();
        System.out.println("a");
        for (User entity: userRepo.findAll()) {
//            if (entity.getRole() == Role.TRAINER)
                dtoList.add(modelMapper.map(entity, TrainerDto.class));
        }
        System.out.println("b");

        return dtoList;
    }

    @Override
    public void deleteTrainer(Long id) {
        userRepo.deleteById(id);
    }
}
