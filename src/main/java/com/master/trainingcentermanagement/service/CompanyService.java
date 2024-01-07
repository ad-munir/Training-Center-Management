package com.master.trainingcentermanagement.service;

import com.master.trainingcentermanagement.dto.CompanyDTO;
import com.master.trainingcentermanagement.entity.Company;


import java.util.List;
public interface CompanyService {


    public Company saveCompany(CompanyDTO company) ;

    public List<CompanyDTO> listCompany() ;

    public void deleteCompany(Long id) ;

}
