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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepo participantRepo;
    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    public ParticipantDto saveParticipant(ParticipantDto participantDto) {

        Course course = courseRepo.findById(participantDto.getCourseId())
                .orElseThrow(()-> new AppException("Course not found", HttpStatus.NO_CONTENT));

        Participant p = Participant.builder()
                .firstname(participantDto.getFirstname())
                .lastname(participantDto.getLastname())
                .birthday(participantDto.getBirthday())
                .email(participantDto.getEmail())
                .phone(participantDto.getPhone())
                .city(participantDto.getCity())
                .course(course)
                .build();

        p = participantRepo.save(p);

        ParticipantDto dto = modelMapper.map(p, ParticipantDto.class);
        dto.setCourseId(participantDto.getId());

        return dto;
    }

    @Override
    public List<ParticipantDto> listParticipants() {
        return participantRepo.findAll()
                .stream()
                .map(e -> {
                    ParticipantDto dto = modelMapper.map(e, ParticipantDto.class);
                    dto.setCourseId(e.getCourse().getId());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public void deleteParticipant(Long id) {
        participantRepo.deleteById(id);
    }

    @Override
    public ResponseEntity<String> assignToCourse(Long id) {
        Participant p = participantRepo.findById(id).orElseThrow(()-> new AppException("", HttpStatus.NO_CONTENT));
        p.setAssigned(true);
        participantRepo.save(p);


        return ResponseEntity.ok("Participant[id: "+ id +"] assigned to the course");
    }

    @Override
    public ParticipantDto getParticipantById(Long id){
        return  modelMapper.map(participantRepo.findById(id).get() , ParticipantDto.class) ;
    }




}
