package com.master.trainingcentermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class CompanyDTO {
    Long id ;
    String name ;
    String address ;
    String email ;
    String phone ;
    String url ;
    private List<Long> courseIds;
}
