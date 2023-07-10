package com.dect.itiAdmission.repository;

import com.dect.itiAdmission.domain.PhCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhCategoryRepository extends JpaRepository<PhCategories, Integer> {
}
