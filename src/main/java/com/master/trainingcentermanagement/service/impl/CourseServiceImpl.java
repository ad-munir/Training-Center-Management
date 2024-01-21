package com.master.trainingcentermanagement.service.impl;


import com.master.trainingcentermanagement.repository.CourseRepo;
import com.master.trainingcentermanagement.dto.CourseDto;

import java.util.ArrayList;

import com.master.trainingcentermanagement.entity.Course;
import com.master.trainingcentermanagement.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;



    @Override
    public Long saveCourse(CourseDto course) {

        Course crs = modelMapper.map(course, Course.class);
        crs = courseRepo.save(crs);

        return crs.getId() ; //modelMapper.map(crs, CourseDto.class);
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

    @Override
    public CourseDto getCourseById(Long id) {
        Optional<Course> courseOptional = courseRepo.findById(id);

        if (courseOptional.isPresent()) {
            CourseDto courseDto = modelMapper.map(courseOptional.get(), CourseDto.class);
            return courseDto;
        } else {
            return null;
        }
    }

}
