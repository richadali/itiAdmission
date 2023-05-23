package com.dect.itiAdmission.categories;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriesController {

    private CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("api/getCategories")
    public ResponseEntity<?> getCategories(){
        return new ResponseEntity<>(categoriesService.getCategories(), HttpStatus.OK);
    }
}
