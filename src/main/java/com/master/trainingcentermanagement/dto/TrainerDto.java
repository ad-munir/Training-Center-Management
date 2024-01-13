package com.master.trainingcentermanagement.dto;

import com.master.trainingcentermanagement.user.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerDto {

    String firstname;
    String lastname;
    String email;
    String phone;
    String keywords;
    Object image;
    Role role;



}
