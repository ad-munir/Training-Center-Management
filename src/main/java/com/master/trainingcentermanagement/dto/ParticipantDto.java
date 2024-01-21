package com.master.trainingcentermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto {

    private String firstname;
    private String lastname;
    private String birthday;
    private String phone;
    private String city;
    private String email;
    private Long courseId;
}
