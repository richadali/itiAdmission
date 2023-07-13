package com.dect.itiAdmission.repository;

import com.dect.itiAdmission.domain.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, String> {
}