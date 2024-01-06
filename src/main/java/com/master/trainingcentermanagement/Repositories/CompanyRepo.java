package com.master.trainingcentermanagement.Repositories;

import com.master.trainingcentermanagement.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Long> {
}
