package com.master.trainingcentermanagement.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
@Table(name = "participants")
public class Participant {
    @Id
    Long id ;
    String fname ;
    String lname ;
    LocalDate birthday ;
    String email ;
    String phone ;
    String city ;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


}
