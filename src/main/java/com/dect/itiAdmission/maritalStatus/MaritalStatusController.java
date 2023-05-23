package com.dect.itiAdmission.maritalStatus;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaritalStatusController {

    private MaritalStatusService maritalStatusService;

    public MaritalStatusController(MaritalStatusService maritalStatusService) {
        this.maritalStatusService = maritalStatusService;
    }

    @GetMapping("api/getMaritalStatus")
    public ResponseEntity<?> getMaritalStatus(){
        return new ResponseEntity<>(maritalStatusService.getMaritalStatus(), HttpStatus.OK);
    }
}
