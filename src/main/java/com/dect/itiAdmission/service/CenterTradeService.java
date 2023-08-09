package com.dect.itiAdmission.service;

import com.dect.itiAdmission.domain.CenterTrades;
import com.dect.itiAdmission.repository.CenterTradeRepository;
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

    public List<CenterTrades> findByCenterIdCenterIdAndIsActive(Integer centerId, char y) {
        return centerTradeRepository.findByCenterIdCenterIdAndIsActiveOrderByTradeIdAsc(centerId, 'Y');
    }
}
