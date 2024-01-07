package com.master.trainingcentermanagement.Repository;

import com.master.trainingcentermanagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {
}
