package com.dect.itiAdmission.centerTrades;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CenterTradeController {

    private CenterTradeService centerTradeService;

    public CenterTradeController(CenterTradeService centerTradeService) {
        this.centerTradeService = centerTradeService;
    }

    @GetMapping("api/getCenterTrades")
    public ResponseEntity<?> getCenterTrades(){
        return new ResponseEntity<>(centerTradeService.getCenterTrades(), HttpStatus.OK);
    }
}
