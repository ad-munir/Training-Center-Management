package com.master.trainingcentermanagement.Repository;

import com.master.trainingcentermanagement.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Long> {
}
