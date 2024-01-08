package com.master.trainingcentermanagement.services;

import com.master.trainingcentermanagement.Repositories.CompanyRepo;
import com.master.trainingcentermanagement.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyService {
    @Autowired
    CompanyRepo companyRepo;

    public Company saveCompany(Company company) {
        return companyRepo.save(company);
    }

    public List<Company> listCompany() {
        return companyRepo.findAll();
    }

    public void deleteCompany(Long id) {
        companyRepo.deleteById(id);
    }
}
