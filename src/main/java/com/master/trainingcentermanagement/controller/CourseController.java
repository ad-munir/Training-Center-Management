package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.dto.CourseDto;
import com.master.trainingcentermanagement.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    CourseServiceImpl courceService;

    @PostMapping
    public CourseDto addCourse(@RequestBody CourseDto course){
        return courceService.saveCourse(course);

    }

    @GetMapping
    public List<CourseDto> findAllCourses(){

        return courceService.listCourses();
    }

    @DeleteMapping("/{id}")
    public void  deleteCompany(@PathVariable Long id){
        courceService.deleteCourse(id);
    }

}
