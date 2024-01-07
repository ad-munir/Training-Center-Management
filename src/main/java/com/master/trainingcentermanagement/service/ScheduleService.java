package com.master.trainingcentermanagement.service;


import com.master.trainingcentermanagement.dto.ScheduleDTO;
import com.master.trainingcentermanagement.entity.Schedule;

import java.util.List;



public interface ScheduleService {

    ScheduleDTO saveSchedule(ScheduleDTO schedule);

    List<ScheduleDTO> listSchedules();

    void deleteSchedule(Long id) ;
}
