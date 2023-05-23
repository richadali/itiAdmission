package com.dect.itiAdmission.maritalStatus;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaritalStatusService {

    private MaritalStatusRepository maritalStatusRepository;

    public MaritalStatusService(MaritalStatusRepository maritalStatusRepository) {
        this.maritalStatusRepository = maritalStatusRepository;
    }

    public List<MaritalStatus> getMaritalStatus() {
        return maritalStatusRepository.findAll();
    }
}
