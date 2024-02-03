package com.master.trainingcentermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleIn {

    private Long courseId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
//    private Long companyId = null;

}
