package com.master.trainingcentermanagement.dto;

import com.master.trainingcentermanagement.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long courseId;

    private Course course;

}
