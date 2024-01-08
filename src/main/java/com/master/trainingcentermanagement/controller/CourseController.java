package com.master.trainingcentermanagement.controller;

<<<<<<< HEAD
import com.master.trainingcentermanagement.dto.CourseDto;
import com.master.trainingcentermanagement.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
=======
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
>>>>>>> a4269e8 (commant 2 cree service)
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
