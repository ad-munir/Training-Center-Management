package com.master.trainingcentermanagement.service;


import com.master.trainingcentermanagement.dto.CourseDto;


import java.util.List;

public interface CourseService {


    Long saveCourse(CourseDto course);

    List<CourseDto> listCourses() ;

    void deleteCourse(Long id) ;
}
