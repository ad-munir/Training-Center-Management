package com.master.trainingcentermanagement.service;


import com.master.trainingcentermanagement.dto.ScheduleDto;

import java.util.List;



public interface ScheduleService {

    ScheduleDto saveSchedule(ScheduleDto schedule);

    List<ScheduleDto> listSchedules();

    void deleteSchedule(Long id) ;
}
