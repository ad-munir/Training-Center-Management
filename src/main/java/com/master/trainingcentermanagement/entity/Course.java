package com.master.trainingcentermanagement.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.master.trainingcentermanagement.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String hours;
    private float cost;
    private String description;
    private String type;
    private String category;
    private String image ;

    @ManyToOne
    private User trainer;

    @OneToMany(mappedBy = "course")
    private List<Feedback> feedbacks;



    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(
            name = "company_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private List<Company> companies;


    @OneToMany(mappedBy = "course")
    private List<Participant> participants;

    @OneToMany(mappedBy = "course")
    private List<Schedule> schedules;




}
