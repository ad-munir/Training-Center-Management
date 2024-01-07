package com.master.trainingcentermanagement.services;

import com.master.trainingcentermanagement.dto.CompanyDTO;
import com.master.trainingcentermanagement.entities.Company;


import java.util.List;
public interface CompanyService {


    public Company saveCompany(CompanyDTO company) ;

    public List<CompanyDTO> listCompany() ;

    public void deleteCompany(Long id) ;

}
