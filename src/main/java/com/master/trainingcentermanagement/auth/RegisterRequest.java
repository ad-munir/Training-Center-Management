package com.master.trainingcentermanagement.auth;

import com.master.trainingcentermanagement.user.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "First name is required!") //not null & not empty
    private String firstname;

    @NotBlank(message = "Last name is required!")
    private String lastname;

    @NotBlank(message = "Email is required!")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid email address")
    private String email;

    @NotBlank(message = "Phone is required!")
    private String phone;

    @NotBlank(message = "Password must not be blank!")
    @Size(min = 8, message = "Password must contains at least 8 characters")
    @Size(max = 20, message = "Password must not exceed 20 characters")
    private String password;

    String keywords = null;
    //MultipartFile image = null ;
//    @NotNull(message = "Role is required")
    private Role role = Role.TRAINER; //if role is not provided, the new user takes the role of TRAINER
}