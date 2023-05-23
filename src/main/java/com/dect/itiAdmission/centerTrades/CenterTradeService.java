package com.dect.itiAdmission.centerTrades;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterTradeService {

    private CenterTradeRepository centerTradeRepository;

    public CenterTradeService(CenterTradeRepository centerTradeRepository) {
        this.centerTradeRepository = centerTradeRepository;
    }

    public List<CenterTrades> getCenterTrades() {
        return centerTradeRepository.findAll();
    }
}
