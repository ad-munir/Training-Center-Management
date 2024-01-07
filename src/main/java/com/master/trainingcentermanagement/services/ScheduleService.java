package com.master.trainingcentermanagement.services;


import com.master.trainingcentermanagement.Repositories.ScheduleRepo;
import com.master.trainingcentermanagement.entities.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



public interface ScheduleService {



    public Schedule saveParticipant(Schedule schedule) ;

    public List<Schedule> listschedule() ;

    public void deleteschedule(Long id) ;
}
