package com.dect.itiAdmission.communities;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunityController {

    private CommunityService communityService;

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping("api/getCommunities")
    public ResponseEntity<?> getCommunities(){
        return new ResponseEntity<>(communityService.getCommunities(), HttpStatus.OK);
    }
}
