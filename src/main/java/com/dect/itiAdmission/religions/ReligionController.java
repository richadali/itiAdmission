package com.dect.itiAdmission.religions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReligionController {

    private ReligionService religionService;

    public ReligionController(ReligionService religionService) {
        this.religionService = religionService;
    }

    @GetMapping("api/getReligions")
    public ResponseEntity<?> getReligions(){
        return new ResponseEntity<>(religionService.getReligions(), HttpStatus.OK);
    }
}
