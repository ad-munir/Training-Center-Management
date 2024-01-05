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
@Table(name = "companies")
public class Company {
    @Id
    Long id ;
    String name ;
    String address ;
    String email ;
    String phone ;
    String url ;

    @OneToMany(mappedBy = "company")
    private List<Course> courses;

}
