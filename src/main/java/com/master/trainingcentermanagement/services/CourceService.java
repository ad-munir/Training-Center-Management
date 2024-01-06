package com.master.trainingcentermanagement.services;


import com.master.trainingcentermanagement.Repositories.CompanyRepo;
import com.master.trainingcentermanagement.Repositories.CourseRepo;
import com.master.trainingcentermanagement.entities.Company;
import com.master.trainingcentermanagement.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourceService {


    @Autowired
    CourseRepo courseRepo;

    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    public List<Course> listCourse() {
        return courseRepo.findAll();
    }

    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }
}
