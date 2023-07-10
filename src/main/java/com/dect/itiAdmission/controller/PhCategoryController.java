package com.dect.itiAdmission.controller;

import com.dect.itiAdmission.service.PhCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhCategoryController {

    private PhCategoryService phCategoryService;

    public PhCategoryController(PhCategoryService phCategoryService) {
        this.phCategoryService = phCategoryService;
    }

    @GetMapping("api/getPhCategories")
    public ResponseEntity<?> getPhCategories(){
        return new ResponseEntity<>(phCategoryService.getPhCategories(), HttpStatus.OK);
    }
}
