package com.dect.itiAdmission.controller;

import com.dect.itiAdmission.domain.CenterTrades;
import com.dect.itiAdmission.service.CenterTradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CenterTradeController {

    private CenterTradeService centerTradeService;

    public CenterTradeController(CenterTradeService centerTradeService) {
        this.centerTradeService = centerTradeService;
    }

    @GetMapping("api/getCenterTrades")
    public List<CenterTrades> getCenterTrades(){
        return  centerTradeService.getCenterTrades();
    }

    @GetMapping("api/getCenterTradesByCenterId/{centerId}")
    public List<CenterTrades> getCenterTradesByCenterId(@PathVariable Integer centerId){
        return  centerTradeService.getCenterTradesByCenterId(centerId);
    }
}
