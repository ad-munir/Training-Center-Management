package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.Repositories.CompanyRepo;
import com.master.trainingcentermanagement.entities.Company;
import com.master.trainingcentermanagement.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;
    @PostMapping("/addCompany")
    public Company addCompany(@RequestBody Company company){
        return companyService.saveCompany(company);

     }

    @GetMapping("/findCompany")
    public List<Company> findCompany(){

        return companyService.listCompany();
    }

    @DeleteMapping("deleteCompany/{id}")
    public void  deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
    }




}
