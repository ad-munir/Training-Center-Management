package com.master.trainingcentermanagement.Repository;

import com.master.trainingcentermanagement.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepo extends JpaRepository<Feedback,Long> {
}
