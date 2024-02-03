package com.master.trainingcentermanagement.service;


import com.master.trainingcentermanagement.dto.ScheduleDto;
import com.master.trainingcentermanagement.dto.ScheduleIn;
import com.master.trainingcentermanagement.dto.ScheduleOut;

import java.util.List;



public interface ScheduleService {

    ScheduleOut saveSchedule(ScheduleIn schedule);

    List<ScheduleOut> listSchedules();

    void deleteSchedule(Long id) ;
}
