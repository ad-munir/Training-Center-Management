package com.master.trainingcentermanagement.service;

import com.master.trainingcentermanagement.dto.CompanyDto;


import java.util.List;
public interface CompanyService {


    CompanyDto saveCompany(CompanyDto company) ;

    List<CompanyDto> listCompanies() ;

    void deleteCompany(Long id) ;

}
