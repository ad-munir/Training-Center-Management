package com.master.trainingcentermanagement.service.impl;


import com.master.trainingcentermanagement.repository.ScheduleRepo;

import com.master.trainingcentermanagement.dto.ScheduleDto;
import com.master.trainingcentermanagement.entity.Schedule;
import com.master.trainingcentermanagement.service.ScheduleService;
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
    public ScheduleDto saveSchedule(ScheduleDto schedule) {

        Schedule sch = modelMapper.map(schedule, Schedule.class);
        sch = scheduleRepo.save(sch);


        return modelMapper.map(sch, ScheduleDto.class);
    }

    @Override
    public List<ScheduleDto> listSchedules() {
        return scheduleRepo.findAll()
                .stream()
                .map(e -> modelMapper.map(e, ScheduleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSchedule(Long id) {
        scheduleRepo.deleteById(id);
    }
}
