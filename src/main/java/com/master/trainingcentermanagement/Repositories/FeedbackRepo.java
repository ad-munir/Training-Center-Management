package com.master.trainingcentermanagement.Repositories;

import com.master.trainingcentermanagement.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepo extends JpaRepository<Feedback,Long> {
}
