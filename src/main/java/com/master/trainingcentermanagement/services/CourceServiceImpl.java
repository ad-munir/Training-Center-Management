package com.master.trainingcentermanagement.services;


import com.master.trainingcentermanagement.Repositories.CourseRepo;
import com.master.trainingcentermanagement.dto.CourseDTO;
import java.util.Optional;
import com.master.trainingcentermanagement.entities.Course;
import com.master.trainingcentermanagement.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourceServiceImpl {


    @Autowired
    CourseRepo courseRepo;
    @Autowired
    UserRepository userRepository;

    public Course saveCourse(CourseDTO course) {
        Course crs = new Course(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getType(),
                course.getCategory(),
                course.getCost(),
                course.getTrainerId(),
                course.getCompanyId(),
                course.getFeedbackIds(),
                course.getParticipantIds(),
                course.getScheduleIds()
        ) ;

        return courseRepo.save(cmp);
    }

    public List<Course> listCourse() {
        return courseRepo.findAll();
    }

    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }
}
