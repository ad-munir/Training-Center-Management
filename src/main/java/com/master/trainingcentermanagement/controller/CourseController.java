package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.dto.CourseDTO;
import com.master.trainingcentermanagement.service.CourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    CourceServiceImpl courceService;

    @PostMapping
    public CourseDTO addCourse(@RequestBody CourseDTO course){
        return courceService.saveCourse(course);

    }

    @GetMapping
    public List<CourseDTO> findAllCourses(){

        return courceService.listCourses();
    }

    @DeleteMapping("/{id}")
    public void  deleteCompany(@PathVariable Long id){
        courceService.deleteCourse(id);
    }

}
