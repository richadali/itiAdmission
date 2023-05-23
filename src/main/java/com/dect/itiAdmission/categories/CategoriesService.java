package com.dect.itiAdmission.categories;

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
