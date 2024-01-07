package com.master.trainingcentermanagement.service;


import com.master.trainingcentermanagement.dto.CourseDTO;


import java.util.List;

public interface CourseService {


    CourseDTO saveCourse(CourseDTO course);

    List<CourseDTO> listCourses() ;

    void deleteCourse(Long id) ;
}
