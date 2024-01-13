package com.master.trainingcentermanagement.auth;

import com.master.trainingcentermanagement.user.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse {

    String firstname;
    String lastname;
    String email;
    String phone;
    Role role;
    String keywords;
    String image ;
    String token;
}
