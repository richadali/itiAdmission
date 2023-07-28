package com.dect.itiAdmission.controller;

import com.dect.itiAdmission.domain.Trades;
import com.dect.itiAdmission.service.TradesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("secure")
public class TradesController {

    private TradesService tradesService;

    public TradesController(TradesService tradesService) {
        this.tradesService = tradesService;
    }

    @GetMapping("api/getTrades")
    public List<Trades> getTrades() {
        return tradesService.getTrades();
    }
}
