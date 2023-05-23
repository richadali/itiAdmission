package com.dect.itiAdmission.districts;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistrictsController {

    private DistrictService districtService;

    public DistrictsController(DistrictService distrcitsService){
        this.districtService = distrcitsService;
    }
    @GetMapping("api/getDistricts")
    public ResponseEntity<?> getDistricts(){
        return new ResponseEntity<>(districtService.getDistricts(), HttpStatus.OK);
    }


}
