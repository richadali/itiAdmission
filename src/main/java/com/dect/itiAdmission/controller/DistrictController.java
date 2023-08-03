package com.dect.itiAdmission.controller;

import com.dect.itiAdmission.domain.Districts;
import com.dect.itiAdmission.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistrictController {

    @Autowired
    private DistrictRepository districtRepository;

    @GetMapping("secure/getDistricts")
    public ResponseEntity<?> getDistricts() {
        List<Districts> districts = districtRepository.findAll();
        return new ResponseEntity<>(districts, HttpStatus.OK);
    }
}
