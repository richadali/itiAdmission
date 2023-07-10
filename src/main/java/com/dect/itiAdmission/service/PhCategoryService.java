package com.dect.itiAdmission.service;

import com.dect.itiAdmission.domain.PhCategories;
import com.dect.itiAdmission.repository.PhCategoryRepository;
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
