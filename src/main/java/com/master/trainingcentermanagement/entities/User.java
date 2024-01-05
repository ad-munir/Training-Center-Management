package com.master.trainingcentermanagement.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
@Table(name = "users")
public class User {
    @Id
    Long id ;
    String fname ;
    String lname ;
    String email ;
    String password ;
    String role ;
    List<String> keywords ;
    boolean active ;

    @OneToMany(mappedBy = "trainer")
    private List<Course> coursesTaught;


}
