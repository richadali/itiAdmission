package com.dect.itiAdmission.states;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatesController {

    private StatesService statesService;

    public StatesController(StatesService statesService) {
        this.statesService = statesService;
    }

    @GetMapping("api/getStates")
    public ResponseEntity<?> getStates(){
        return new ResponseEntity<>(statesService.getState(), HttpStatus.OK);
    }
}
