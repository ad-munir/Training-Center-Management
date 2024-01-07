package com.master.trainingcentermanagement.service.impl;


import com.master.trainingcentermanagement.Repository.CourseRepo;
import com.master.trainingcentermanagement.dto.CourseDTO;

import java.util.ArrayList;

import com.master.trainingcentermanagement.entity.Course;
import com.master.trainingcentermanagement.service.CourseService;
import com.master.trainingcentermanagement.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;



    @Override
    public CourseDTO saveCourse(CourseDTO course) {

        Course crs = modelMapper.map(course, Course.class);
        crs = courseRepo.save(crs);

        return modelMapper.map(crs, CourseDTO.class);
    }

    @Override
    public List<CourseDTO> listCourses() {

        List<CourseDTO> dtoList = new ArrayList<>();

        for (Course entity: courseRepo.findAll())
            dtoList.add(modelMapper.map(entity, CourseDTO.class));


        return dtoList;
    }

    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }
}
