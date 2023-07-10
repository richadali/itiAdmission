package com.dect.itiAdmission.service;

import com.dect.itiAdmission.domain.Trades;
import com.dect.itiAdmission.repository.TradesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradesService {

    private TradesRepository tradesRepository;

    public TradesService(TradesRepository tradesRepository) {
        this.tradesRepository = tradesRepository;
    }

    public List<Trades> getTrades() {
        return tradesRepository.findAll();
    }

    public Long tradeCount(){
        return tradesRepository.count();
    }
}
