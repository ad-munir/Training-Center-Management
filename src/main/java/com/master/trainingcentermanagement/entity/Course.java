package com.master.trainingcentermanagement.entity;


import com.fasterxml.jackson.annotation.*;
import com.master.trainingcentermanagement.user.Role;
import com.master.trainingcentermanagement.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String hours;
    private float cost;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String type;
    private String category;
    private String image ;

    @ManyToOne
    private User trainer;


    @OneToMany(mappedBy = "course")
    private List<Feedback> feedbacks;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "company_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private Set<Company> companies = new HashSet<>();


    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Participant> participants;

    @OneToMany(mappedBy = "course")
    private List<Schedule> schedules;



    public void addCompany(Company company) {

        if (this.companies == null) {
            this.companies = new HashSet<>();
        }
        this.companies.add(company);
//        company.getCourses().add(this);
        System.out.println("*********");
    }

    public void removeCompany(Company company) {
        if (this.companies != null) {
            this.companies.remove(company);
        }

        if (company.getCourses() != null) {
            company.getCourses().remove(this);
        }
    }



}
