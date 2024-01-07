package com.master.trainingcentermanagement.Repository;

import com.master.trainingcentermanagement.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepo extends JpaRepository<Participant,Long> {
}
