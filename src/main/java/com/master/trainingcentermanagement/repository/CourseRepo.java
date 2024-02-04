package com.master.trainingcentermanagement.repository;

import com.master.trainingcentermanagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CourseRepo extends JpaRepository<Course,Long> {


}
