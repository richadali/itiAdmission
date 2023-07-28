package com.dect.itiAdmission.controller;

import com.dect.itiAdmission.domain.Centers;
import com.dect.itiAdmission.service.CenterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("secure")
public class CenterController {

    private CenterService centerService;

    public CenterController(CenterService centerService) {
        this.centerService = centerService;
    }

    @GetMapping("api/getCenters")
    public List<Centers> getCenters() {
        return centerService.getCenters();
    }

    @PostMapping("api/addCenter")
    public ResponseEntity<?> addCenter(@RequestBody Centers centers) {
//        return ResponseEntity.ok(centers);
        return new ResponseEntity<>(centerService.addCenter(centers), HttpStatus.OK);
    }

}
