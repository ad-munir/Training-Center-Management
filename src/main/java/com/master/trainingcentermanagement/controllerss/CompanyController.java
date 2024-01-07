package com.master.trainingcentermanagement.controllerss;

import com.master.trainingcentermanagement.dto.CompanyDTO;
import com.master.trainingcentermanagement.entities.Company;
import com.master.trainingcentermanagement.services.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyServiceImpl companyService;
    @PostMapping("/addCompany")
    public Company addCompany(@RequestBody CompanyDTO company){
        return companyService.saveCompany(company);

     }

    @GetMapping("/findCompany")
    public List<CompanyDTO> findCompany(){

        return companyService.listCompany();
    }

    @DeleteMapping("deleteCompany/{id}")
    public void  deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
    }




}
