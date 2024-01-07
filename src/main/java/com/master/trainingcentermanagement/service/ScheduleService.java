package com.master.trainingcentermanagement.service;


import com.master.trainingcentermanagement.entity.Schedule;

import java.util.List;



public interface ScheduleService {



    public Schedule saveParticipant(Schedule schedule) ;

    public List<Schedule> listschedule() ;

    public void deleteschedule(Long id) ;
}
