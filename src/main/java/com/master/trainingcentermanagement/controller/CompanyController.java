package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.Repositories.CompanyRepo;
import com.master.trainingcentermanagement.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyRepo companyRepo;
    @PostMapping("/addCompany")
    public Company addCompany(@RequestBody Company company){
        return companyRepo.save(company);

     }

    @GetMapping("/findCompany")
    public List<Company> findCompany(@PathVariable String date){

        return companyRepo.findAll();
    }

    @DeleteMapping("deleteCompany/{id}")
    public void  deleteCompany(@PathVariable Long id){
        companyRepo.deleteById(id);
    }




}
