package com.master.trainingcentermanagement.service;

import com.master.trainingcentermanagement.dto.AssistantDto;

import java.util.List;

public interface AssistantService {

    AssistantDto getAssistantById(Long id);


    List<AssistantDto> listAssistants();

    void deleteAssistant(Long id);
}
