package com.master.trainingcentermanagement.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
@Table(name = "feedbacks")
public class Feedback {
    @Id
    Long id ;
    float score ;
    List<String> comments ;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;






}
