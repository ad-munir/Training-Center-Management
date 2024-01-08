package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.dto.ScheduleDto;
import com.master.trainingcentermanagement.service.impl.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedules")

public class ScheduleController {


    @Autowired
    ScheduleServiceImpl scheduleService;
    @PostMapping
    public ScheduleDto saveSchedule(@RequestBody ScheduleDto schedule){
        return scheduleService.saveSchedule(schedule);

    }

    @GetMapping
    public List<ScheduleDto> listSchedules(){

        return scheduleService.listSchedules();
    }

    @DeleteMapping("/{id}")
    public void  deleteSchedule(@PathVariable Long id){
        scheduleService.deleteSchedule(id);
    }

}
