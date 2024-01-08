package com.master.trainingcentermanagement.service.impl;


import com.master.trainingcentermanagement.repository.CourseRepo;
import com.master.trainingcentermanagement.dto.CourseDto;

import java.util.ArrayList;

import com.master.trainingcentermanagement.entity.Course;
import com.master.trainingcentermanagement.service.CourseService;
import com.master.trainingcentermanagement.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;



    @Override
    public CourseDto saveCourse(CourseDto course) {

        Course crs = modelMapper.map(course, Course.class);
        crs = courseRepo.save(crs);

        return modelMapper.map(crs, CourseDto.class);
    }

    @Override
    public List<CourseDto> listCourses() {

        List<CourseDto> dtoList = new ArrayList<>();

        for (Course entity: courseRepo.findAll())
            dtoList.add(modelMapper.map(entity, CourseDto.class));


        return dtoList;
    }

    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }
}
