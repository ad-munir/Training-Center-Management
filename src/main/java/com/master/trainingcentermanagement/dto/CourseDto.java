package com.master.trainingcentermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private String title;
    private String hours;
    private float cost;
    private String description;
    private String type;
    private String category;
    Object image ;
    private Long trainerId;




}
