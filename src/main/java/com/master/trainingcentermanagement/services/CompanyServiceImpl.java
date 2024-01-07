package com.master.trainingcentermanagement.services;

import com.master.trainingcentermanagement.Repositories.CompanyRepo;
import com.master.trainingcentermanagement.dto.CompanyDTO;
import com.master.trainingcentermanagement.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CompanyServiceImpl {
    @Autowired
    CompanyRepo companyRepo;

    public Company saveCompany(CompanyDTO company) {

        Company cmp = new Company(
                company.getId(),
                company.getName(),
                company.getAddress(),
                company.getEmail(),
                company.getPhone(),
                company.getUrl(),
                company.getCourseIds()) ;

        return companyRepo.save(cmp);
    }

    public List<CompanyDTO> listCompany() {

        List<Company> companies = companyRepo.findAll();
        List<CompanyDTO> companiesDto = new ArrayList<>();
        for(Company cmp : companies){
            CompanyDTO employeeDTO = new CompanyDTO(
                    cmp.getId(),
                    cmp.getName(),
                    cmp.getAddress(),
                    cmp.getEmail(),
                    cmp.getPhone(),
                    cmp.getUrl(),
                    cmp.getCourseIds()
            );
            companiesDto.add(employeeDTO);
        }
        return companiesDto;

    }

    public void deleteCompany(Long id) {
        companyRepo.deleteById(id);
    }
}
