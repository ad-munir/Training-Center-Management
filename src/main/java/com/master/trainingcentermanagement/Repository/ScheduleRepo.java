package com.master.trainingcentermanagement.Repository;

import com.master.trainingcentermanagement.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepo extends JpaRepository<Schedule,Long> {
}
