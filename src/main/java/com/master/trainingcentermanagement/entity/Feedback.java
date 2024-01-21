package com.master.trainingcentermanagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int score;

    @ElementCollection
    @CollectionTable(name = "comments", joinColumns = @JoinColumn(name = "feedback_id"))
    @Column(name = "comments")
    private List<String> comments ;

    @ManyToOne
    private Course course;






}
