package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.dto.CompanyDto;
import com.master.trainingcentermanagement.service.impl.CompanyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyServiceImpl companyService;




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
    }




}
