package com.dect.itiAdmission.phCategories;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhCategoryService {

    private PhCategoryRepository phCategoryRepository;

    public PhCategoryService(PhCategoryRepository phCategoryRepository) {
        this.phCategoryRepository = phCategoryRepository;
    }

    public List<PhCategories> getPhCategories() {
        return phCategoryRepository.findAll();
    }
}
