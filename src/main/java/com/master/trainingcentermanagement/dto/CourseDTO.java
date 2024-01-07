package com.master.trainingcentermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data @AllArgsConstructor @NoArgsConstructor
public class CourseDTO {

    private String title;
    private String hours;
    private float cost;
    private String ville;
    private boolean online;
    private String description;
    private String type;
    private String category;

//    private Long trainerId;
//    private Long companyId;
//    private List<Long> feedbackIds;
//    private List<Long> participantIds;
//    private List<Long> scheduleIds;


}
