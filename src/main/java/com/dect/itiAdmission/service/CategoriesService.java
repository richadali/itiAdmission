package com.dect.itiAdmission.service;

import com.dect.itiAdmission.domain.Categories;
import com.dect.itiAdmission.repository.CategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    private CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }
    public List<Categories> getCategories() {
        return categoriesRepository.findAll();
    }
}