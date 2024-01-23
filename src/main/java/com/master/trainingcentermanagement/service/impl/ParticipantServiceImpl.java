package com.master.trainingcentermanagement.service.impl;

import com.master.trainingcentermanagement.entity.Course;
import com.master.trainingcentermanagement.exception.errors.AppException;
import com.master.trainingcentermanagement.repository.CourseRepo;
import com.master.trainingcentermanagement.repository.ParticipantRepo;
import com.master.trainingcentermanagement.dto.ParticipantDto;
import com.master.trainingcentermanagement.entity.Participant;
import com.master.trainingcentermanagement.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepo participantRepo;
    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    public ParticipantDto saveParticipant(ParticipantDto participant) {

        Course course = courseRepo.findById(participant.getCourseId()).orElseThrow(()-> new AppException("Course not found!", HttpStatus.NOT_FOUND));

        Participant p = modelMapper.map(participant, Participant.class);
        p.setCourse(course);
        p = participantRepo.save(p);


        return modelMapper.map(p, ParticipantDto.class);



//        Course course = courseRepo.findById(participant.getCourseId()).orElseThrow(()-> new AppException("Course not found!", HttpStatus.NOT_FOUND));
//
//
//        Participant p = Participant.builder()
//                .id(null)
//                .firstname(participant.getFirstname())
//                .lastname(participant.getLastname())
//                .birthday(participant.getBirthday())
//                .phone(participant.getPhone())
//                .email(participant.getEmail())
//                .city(participant.getCity())
//                .course(course)
//                .build();
//
//
//        p = participantRepo.save(p);
//
//        System.out.println("============================1");
//        System.out.println(p);
//        System.out.println("============================1");
//
//
//
//        return modelMapper.map(p, ParticipantDto.class);
    }

    @Override
    public List<ParticipantDto> listParticipants() {
        return participantRepo.findAll()
                .stream()
                .map(e -> modelMapper.map(e, ParticipantDto.class))
                .collect(Collectors.toList());
    }

    public void deleteParticipant(Long id) {
        participantRepo.deleteById(id);
    }
}
