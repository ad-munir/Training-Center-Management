package com.master.trainingcentermanagement.service;

import com.master.trainingcentermanagement.dto.CompanyDTO;
import com.master.trainingcentermanagement.entity.Company;


import java.util.List;
public interface CompanyService {


    CompanyDTO saveCompany(CompanyDTO company) ;

    List<CompanyDTO> listCompany() ;

    void deleteCompany(Long id) ;

}
