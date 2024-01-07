package com.master.trainingcentermanagement.service;


import com.master.trainingcentermanagement.Repository.ScheduleRepo;

import com.master.trainingcentermanagement.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScheduleServiceImpl {

    @Autowired
    ScheduleRepo scheduleRepo;

    public Schedule saveParticipant(Schedule schedule) {

        return scheduleRepo.save(schedule);
    }

    public List<Schedule> listschedule() {
        return scheduleRepo.findAll();
    }

    public void deleteschedule(Long id) {
        scheduleRepo.deleteById(id);
    }
}
