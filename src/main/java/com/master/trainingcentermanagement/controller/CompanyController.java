package com.master.trainingcentermanagement.controller;

<<<<<<< HEAD
import com.master.trainingcentermanagement.dto.CompanyDto;
import com.master.trainingcentermanagement.service.impl.CompanyServiceImpl;
=======
import com.master.trainingcentermanagement.Repositories.CompanyRepo;
import com.master.trainingcentermanagement.entities.Company;
>>>>>>> a4269e8 (commant 2 cree service)
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping("/api/v1/companies")
public class CompanyController {

    @Autowired
    CompanyServiceImpl companyService;
    @PostMapping
    public CompanyDto addCompany(@RequestBody CompanyDto company){
        return companyService.saveCompany(company);

     }

    @GetMapping
    public List<CompanyDto> listCompanies(){

        return companyService.listCompanies();
    }

    @DeleteMapping("/{id}")
    public void  deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
=======
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
>>>>>>> a4269e8 (commant 2 cree service)
    }




}
