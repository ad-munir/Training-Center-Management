package com.master.trainingcentermanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
        private String to;
        private String subject;
        private String body;
        private Long courseId ;

}


