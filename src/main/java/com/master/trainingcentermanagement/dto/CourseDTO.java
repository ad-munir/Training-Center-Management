package com.master.trainingcentermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data @AllArgsConstructor @NoArgsConstructor
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private String type;
    private String category;
    private float cost;
    private Long trainerId;
    private Long companyId;
    private List<Long> feedbackIds;
    private List<Long> participantIds;
    private List<Long> scheduleIds;

}
