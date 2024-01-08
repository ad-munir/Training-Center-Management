package com.master.trainingcentermanagement.service.impl;

import com.master.trainingcentermanagement.repository.CompanyRepo;
import com.master.trainingcentermanagement.dto.CompanyDto;
import com.master.trainingcentermanagement.entity.Company;
import com.master.trainingcentermanagement.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepo companyRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CompanyDto saveCompany(CompanyDto company) {

        Company comp = modelMapper.map(company, Company.class);
        comp = companyRepo.save(comp);


        return modelMapper.map(comp, CompanyDto.class);
    }

    public List<CompanyDto> listCompanies() {

        List<CompanyDto> dtoList = new ArrayList<>();

        for (Company entity: companyRepo.findAll()) {
            dtoList.add(modelMapper.map(entity, CompanyDto.class));
        }

        return dtoList;
    }

    public void deleteCompany(Long id) {
        companyRepo.deleteById(id);
    }
}
