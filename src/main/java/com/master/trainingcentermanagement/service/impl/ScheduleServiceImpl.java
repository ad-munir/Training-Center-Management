package com.master.trainingcentermanagement.service.impl;


import com.master.trainingcentermanagement.dto.ScheduleIn;
import com.master.trainingcentermanagement.dto.ScheduleOut;
import com.master.trainingcentermanagement.entity.Course;
import com.master.trainingcentermanagement.exception.errors.AppException;
import com.master.trainingcentermanagement.repository.CourseRepo;
import com.master.trainingcentermanagement.repository.ScheduleRepo;

import com.master.trainingcentermanagement.dto.ScheduleDto;
import com.master.trainingcentermanagement.entity.Schedule;
import com.master.trainingcentermanagement.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepo scheduleRepo;
    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    @Override
    public ScheduleDto saveSchedule(ScheduleDto schedule) {

        System.out.println("---------------");
        System.out.println("---------------");
        Course course = courseRepo.findById(schedule.getCourseId())
                .orElseThrow(()-> new AppException("Course not found !", HttpStatus.NO_CONTENT));


        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println(schedule.getCourseId());
        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("---------------");
        Schedule sc = Schedule.builder()
                .startDate(schedule.getStartDate())
                .endDate(schedule.getEndDate())
                .course(course)
                .build();

        sc = scheduleRepo.save(sc);
        return modelMapper.map(sc, ScheduleDto.class);
    }

    @Override
    public List<ScheduleDto> listSchedules() {
        return null;
    }


    public ScheduleOut saveSchedule2(ScheduleIn schedule) {


        Course crs = courseRepo.findById(schedule.getCourseId())
                .orElseThrow(()-> new AppException("Course not found !", HttpStatus.NO_CONTENT));


        Schedule sc = Schedule.builder()
                .startDate(schedule.getStartDate())
                .endDate(schedule.getEndDate())
                .course(crs)
                .build();

        sc = scheduleRepo.save(sc);
        return modelMapper.map(sc, ScheduleOut.class);
    }

    public List<ScheduleOut> listSchedules2() {

        List<Schedule> all = scheduleRepo.findAll();
        List<ScheduleOut> out = new ArrayList<>();

        all.forEach(sch -> {

            ScheduleOut so = ScheduleOut.builder()
                    .startDate(sch.getStartDate())
                    .endDate(sch.getEndDate())
                    .title(sch.getCourse().getTitle())
                    .build();

            out.add(so);
        });
        return out;

    }

    @Override
    public void deleteSchedule(Long id) {
        scheduleRepo.deleteById(id);
    }
}
