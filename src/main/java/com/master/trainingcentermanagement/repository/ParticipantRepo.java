package com.master.trainingcentermanagement.repository;

import com.master.trainingcentermanagement.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepo extends JpaRepository<Participant,Long> {
}
