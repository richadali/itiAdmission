package com.dect.itiAdmission.controller;

import com.dect.itiAdmission.domain.ApplicationDetails;
import com.dect.itiAdmission.domain.MeritList;
import com.dect.itiAdmission.dtos.MeritListDTO;
import com.dect.itiAdmission.service.MeritListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secure")
public class MeritListController {
    @Autowired
    private MeritListService meritListService;
    @PostMapping("/addMeritList")
    public String addMeritList(@RequestBody List<MeritListDTO> meritListDTO){
        return meritListService.addMeritList(meritListDTO);
    }

    @GetMapping("/getMeritListByCenterIdAndTradeId/{centerId}/{tradeId}")
    public List<MeritList> getMeritListByCenterIdAndTradeId(@PathVariable Integer centerId, @PathVariable Integer tradeId){
        return meritListService.getMeritListByCenterIdAndTradeId(centerId, tradeId);
    }
}

