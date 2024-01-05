package com.master.trainingcentermanagement.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "participant_formation",
            joinColumns = @JoinColumn(name = "participant_id"),
            inverseJoinColumns = @JoinColumn(name = "formation_id")
    )
    private List<Course> courses;


}
