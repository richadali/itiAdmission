package com.dect.itiAdmission.centers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CenterController {

    private CenterService centerService;

    public CenterController(CenterService centerService) {
        this.centerService = centerService;
    }

    @GetMapping("api/getCenters")
    public ResponseEntity<?> getCenters(){
        return new ResponseEntity<>(centerService.getCenters(), HttpStatus.OK);
    }

    @PostMapping("api/addCenter")
    public ResponseEntity<?> addCenter(@RequestBody Centers centers){
//        return ResponseEntity.ok(centers);
        return new ResponseEntity<>(centerService.addCenter(centers), HttpStatus.OK);
    }

}
