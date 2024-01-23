package com.master.trainingcentermanagement.service.impl;

import com.master.trainingcentermanagement.dto.AssistantDto;
import com.master.trainingcentermanagement.exception.errors.AppException;
import com.master.trainingcentermanagement.service.AssistantService;
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
public class AssistantServiceImpl implements AssistantService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;


    @Override
    public AssistantDto getAssistantById(Long id) {
        User assistant = userRepo.findById(id).orElseThrow( () -> new AppException("Invalid assistant ID", HttpStatus.NO_CONTENT));
        return modelMapper.map(assistant, AssistantDto.class);
    }


    @Override
    public List<AssistantDto> listAssistants() {

        List<AssistantDto> dtoList = new ArrayList<>();

        for (User entity: userRepo.findAll()) {
            if (entity.getRole() == Role.ASSISTANT)

                dtoList.add( new AssistantDto(
                                        entity.getId(),
                                        entity.getFirstname(),
                                        entity.getLastname(),
                                        entity.getEmail(),
                                        entity.getPhone(),
                                        entity.getImage(),
                                        entity.getRole())
                );
        }

        return dtoList;
    }

    @Override
    public void deleteAssistant(Long id) {
        userRepo.deleteById(id);
    }
}
