package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.dto.CompanyDTO;
import com.master.trainingcentermanagement.entity.Company;
import com.master.trainingcentermanagement.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    @Autowired
    CompanyServiceImpl companyService;
    @PostMapping
    public CompanyDTO addCompany(@RequestBody CompanyDTO company){
        return companyService.saveCompany(company);

     }

    @GetMapping
    public List<CompanyDTO> findCompany(){

        return companyService.listCompany();
    }

    @DeleteMapping("/{id}")
    public void  deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
    }




}
