package com.master.trainingcentermanagement.service.impl;

import com.master.trainingcentermanagement.Repository.CompanyRepo;
import com.master.trainingcentermanagement.dto.CompanyDTO;
import com.master.trainingcentermanagement.dto.CourseDTO;
import com.master.trainingcentermanagement.entity.Company;
import com.master.trainingcentermanagement.entity.Course;
import com.master.trainingcentermanagement.service.CompanyService;
import org.hibernate.Hibernate;
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
    public CompanyDTO saveCompany(CompanyDTO company) {

        Company comp = modelMapper.map(company, Company.class);
        comp = companyRepo.save(comp);


        return modelMapper.map(comp, CompanyDTO.class);
    }

    public List<CompanyDTO> listCompany() {

        List<CompanyDTO> dtoList = new ArrayList<>();

        for (Company entity: companyRepo.findAll()) {
            dtoList.add(modelMapper.map(entity, CompanyDTO.class));
        }

        return dtoList;
    }

    public void deleteCompany(Long id) {
        companyRepo.deleteById(id);
    }
}
