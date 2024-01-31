package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.dto.ScheduleDto;
import com.master.trainingcentermanagement.dto.ScheduleIn;
import com.master.trainingcentermanagement.dto.ScheduleOut;
import com.master.trainingcentermanagement.service.impl.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedules")
@CrossOrigin("http://localhost:4200")
public class ScheduleController {


    @Autowired
    ScheduleServiceImpl scheduleService;
    @PostMapping
    public ScheduleOut saveSchedule(@RequestBody ScheduleIn schedule){
        return scheduleService.saveSchedule2(schedule);

    }

    @GetMapping
    public List<ScheduleOut> listSchedules(){

        return scheduleService.listSchedules2();
    }

    @DeleteMapping("/{id}")
    public void  deleteSchedule(@PathVariable Long id){
        scheduleService.deleteSchedule(id);
    }

}
