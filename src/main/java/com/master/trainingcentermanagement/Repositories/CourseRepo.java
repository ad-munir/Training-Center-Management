package com.master.trainingcentermanagement.Repositories;

import com.master.trainingcentermanagement.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {
}
