package com.master.trainingcentermanagement.services;


import com.master.trainingcentermanagement.dto.CourseDTO;
import com.master.trainingcentermanagement.entities.Course;


import java.util.List;


public interface CourceService {


    public Course saveCourse(CourseDTO course);

    public List<CourseDTO> listCourse() ;

    public void deleteCourse(Long id) ;
}
