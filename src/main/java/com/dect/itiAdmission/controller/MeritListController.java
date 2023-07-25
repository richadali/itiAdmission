package com.dect.itiAdmission.controller;

import com.dect.itiAdmission.dtos.GetApplicationDetailsDTO;
import com.dect.itiAdmission.dtos.MeritListDTO;
import com.dect.itiAdmission.service.MeritListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("secure")
public class MeritListController {
    @Autowired
    private MeritListService meritListService;

    @PostMapping("/addMeritList")
    public String addMeritList(@RequestBody MeritListDTO meritListDTO) {
        return meritListService.addMeritList(meritListDTO);
    }

    @DeleteMapping("/removeFromMeritList")
    public String removeFromMeritList(String id) {
        return meritListService.removeFromMeritList(id);
    }

    @GetMapping("/getMeritListByCenterIdAndTradeId/{centerId}/{tradeId}")
    public List<?> getMeritListByCenterIdAndTradeId(@PathVariable Integer centerId, @PathVariable Integer tradeId) {
        System.out.println("-----------------------------------------------");
        List<GetApplicationDetailsDTO> getApplicationDetailsDTO = meritListService.getMeritListByCenterIdAndTradeId(centerId, tradeId);
        getApplicationDetailsDTO.forEach(System.out::println);
        return getApplicationDetailsDTO;
    }
}

