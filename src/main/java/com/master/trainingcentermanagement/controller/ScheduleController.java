package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.dto.ScheduleDTO;
import com.master.trainingcentermanagement.entity.Schedule;
import com.master.trainingcentermanagement.service.impl.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedule")

public class ScheduleController {


    @Autowired
    ScheduleServiceImpl scheduleService;
    @PostMapping
    public ScheduleDTO saveSchedule(@RequestBody ScheduleDTO schedule){
        return scheduleService.saveSchedule(schedule);

    }

    @GetMapping
    public List<ScheduleDTO> listSchedules(){

        return scheduleService.listSchedules();
    }

    @DeleteMapping("/{id}")
    public void  deleteSchedule(@PathVariable Long id){
        scheduleService.deleteSchedule(id);
    }

}
