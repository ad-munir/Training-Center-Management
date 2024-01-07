package com.master.trainingcentermanagement.service;


import com.master.trainingcentermanagement.Repository.CourseRepo;
import com.master.trainingcentermanagement.dto.CourseDTO;

import java.util.ArrayList;

import com.master.trainingcentermanagement.entity.Course;
import com.master.trainingcentermanagement.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourceServiceImpl {

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper;
    private String title;
    private String hours;
    private float cost;
    private String ville;
    private boolean online;
    private String description;
    private String type;
    private String category;

    public CourseDTO saveCourse(CourseDTO course) {

//        var crs = Course.builder()
//                .title(course.getTitle())
//                .hours(course.getHours())
//                .cost(course.getCost())
//                .ville(course.getVille())
//                .online(course.isOnline())
//                .description(course.getDescription())
//        type
//                .category(course.getCategory())
//                .build();

        Course crs = modelMapper.map(course, Course.class);
        crs = courseRepo.save(crs);


        return modelMapper.map(crs, CourseDTO.class);
    }

    public List<CourseDTO> listCourses() {

        List<CourseDTO> dtoList = new ArrayList<>();

        for (Course entity: courseRepo.findAll()) {
            dtoList.add(modelMapper.map(entity, CourseDTO.class));
        }

        return dtoList;
    }

    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }
}
