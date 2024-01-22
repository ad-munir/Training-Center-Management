package com.master.trainingcentermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto {

    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private String phone;
    private String city;
    private String email;
    private Long courseId;
}
