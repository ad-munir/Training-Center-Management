package com.master.trainingcentermanagement.Repositories;

import com.master.trainingcentermanagement.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;

public interface ScheduleRepo extends JpaRepository<Schedule,Long> {
}
