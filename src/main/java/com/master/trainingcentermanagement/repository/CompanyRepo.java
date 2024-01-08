package com.master.trainingcentermanagement.repository;

import com.master.trainingcentermanagement.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Long> {
}
