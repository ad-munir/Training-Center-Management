package com.master.trainingcentermanagement.services;


import com.master.trainingcentermanagement.Repositories.ScheduleRepo;

import com.master.trainingcentermanagement.entities.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScheduleService {

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
