package com.master.trainingcentermanagement.dto;

import com.master.trainingcentermanagement.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleOut {

    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
