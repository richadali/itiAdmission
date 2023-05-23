package com.dect.itiAdmission.trades;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradesController {

    private TradesService tradesService;

    public TradesController(TradesService tradesService) {
        this.tradesService = tradesService;
    }

    @GetMapping("api/getTrades")
    public ResponseEntity<?> getTrades(){
        return new ResponseEntity<>(tradesService.getTrades(), HttpStatus.OK);
    }
}
