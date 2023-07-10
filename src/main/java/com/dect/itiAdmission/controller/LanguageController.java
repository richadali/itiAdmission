package com.dect.itiAdmission.controller;

import com.dect.itiAdmission.service.LanguageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {


    private LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }
    @GetMapping("api/getLanguages")
    public ResponseEntity<?> getLanguages(){
        return new ResponseEntity<>(languageService.getLanguages(), HttpStatus.OK);
    }
}
