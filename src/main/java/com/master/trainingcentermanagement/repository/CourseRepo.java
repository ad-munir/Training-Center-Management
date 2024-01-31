package com.master.trainingcentermanagement.repository;

import com.master.trainingcentermanagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course,Long> {


}
