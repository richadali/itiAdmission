package com.dect.itiAdmission.trades;

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
}
