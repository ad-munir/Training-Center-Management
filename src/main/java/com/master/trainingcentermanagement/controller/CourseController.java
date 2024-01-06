package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.entities.Company;
import com.master.trainingcentermanagement.entities.Course;
import com.master.trainingcentermanagement.services.CompanyService;
import com.master.trainingcentermanagement.services.CourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourceService courceService;
    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course){
        return courceService.saveCourse(course);

    }

    @GetMapping("/findCourse")
    public List<Course> findCourse(){

        return courceService.listCourse();
    }

    @DeleteMapping("deleteCourse/{id}")
    public void  deleteCompany(@PathVariable Long id){
        courceService.deleteCourse(id);
    }

}
