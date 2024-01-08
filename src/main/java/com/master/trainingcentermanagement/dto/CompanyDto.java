package com.master.trainingcentermanagement.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyDto {

    String name ;
    String address ;
    String email ;
    String phone ;
    String url ;
    private List<Long> courseId;
}
