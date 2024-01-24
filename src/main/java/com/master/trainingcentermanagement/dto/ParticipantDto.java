package com.master.trainingcentermanagement.dto;

import com.master.trainingcentermanagement.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto {

    private Long id ;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private String phone;
    private String email;
    private String city;
    private boolean assigned;
    private boolean evaluated;
    private Long courseId;
    private Course course;

}
