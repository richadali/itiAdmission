package com.dect.itiAdmission.states;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatesService {

    private StatesRepository statesRepository;

    public StatesService(StatesRepository statesRepository) {

        this.statesRepository = statesRepository;
    }

    public List<States> getState() {

        return statesRepository.findAll();
    }
}
