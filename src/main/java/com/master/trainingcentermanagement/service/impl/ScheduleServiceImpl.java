package com.master.trainingcentermanagement.service.impl;


import com.master.trainingcentermanagement.Repository.ScheduleRepo;

import com.master.trainingcentermanagement.dto.ParticipantDTO;
import com.master.trainingcentermanagement.dto.ScheduleDTO;
import com.master.trainingcentermanagement.entity.Schedule;
import com.master.trainingcentermanagement.service.ScheduleService;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleRepo scheduleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ScheduleDTO saveSchedule(ScheduleDTO schedule) {

        Schedule sch = modelMapper.map(schedule, Schedule.class);
        sch = scheduleRepo.save(sch);


        return modelMapper.map(sch, ScheduleDTO.class);
    }

    @Override
    public List<ScheduleDTO> listSchedules() {
        return scheduleRepo.findAll()
                .stream()
                .map(e -> modelMapper.map(e, ScheduleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSchedule(Long id) {
        scheduleRepo.deleteById(id);
    }
}
