package com.dect.itiAdmission.controller;

import com.dect.itiAdmission.domain.Blocks;
import com.dect.itiAdmission.domain.Districts;
import com.dect.itiAdmission.domain.Villages;
import com.dect.itiAdmission.service.LGDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LGDController {

    @Autowired
    LGDService lgdService;

    @GetMapping("districts")
    public List<Districts> getDistricts() {
        return lgdService.getDistricts();
    }

    @GetMapping("blocks/{districtId}")
    public List<Blocks> getBlocks(@PathVariable("districtId") Long districtId) {
        return lgdService.getBlocks(districtId);
    }

    @GetMapping("villages/{blockId}")
    public List<Villages> getVillages(@PathVariable("blockId") Long blockId) {
        return lgdService.getVillages(blockId);
    }
}
