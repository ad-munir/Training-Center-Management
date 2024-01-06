package com.master.trainingcentermanagement.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
@Table(name = "courses")
public class Course {
    @Id
    Long id ;
    String title ;
    String description ;
    String type ;
    String category ;
    float cost ;
//
//    @ManyToOne
//    @JoinColumn(name = "trainer_id")
//    private User trainer;

    @OneToMany(mappedBy = "course")
    private List<Feedback> feedbacks;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(mappedBy = "courses")
    private List<Participant> participants;

    @OneToMany(mappedBy = "course")
    private List<Schedule> schedules;



}
