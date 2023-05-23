package com.dect.itiAdmission.religions;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReligionService {

    private ReligionRepository religionRepository;

    public ReligionService(ReligionRepository religionRepository) {
        this.religionRepository = religionRepository;
    }

    public List<Religions> getReligions() {
        return religionRepository.findAll();
    }
}
