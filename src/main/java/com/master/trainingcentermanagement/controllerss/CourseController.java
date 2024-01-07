package com.master.trainingcentermanagement.controllerss;

import com.master.trainingcentermanagement.entities.Course;
import com.master.trainingcentermanagement.services.CourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourceServiceImpl courceService;
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
