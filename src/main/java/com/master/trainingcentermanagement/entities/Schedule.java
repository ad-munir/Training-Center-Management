package com.master.trainingcentermanagement.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    Long id ;
    Date date ;
    int hours ;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;






}
