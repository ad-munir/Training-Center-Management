package com.master.trainingcentermanagement.Repositories;

import com.master.trainingcentermanagement.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepo extends JpaRepository<Participant,Long> {
}
