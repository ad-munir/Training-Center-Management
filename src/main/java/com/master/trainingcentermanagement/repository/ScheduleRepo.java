package com.master.trainingcentermanagement.repository;

import com.master.trainingcentermanagement.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepo extends JpaRepository<Schedule,Long> {
}
