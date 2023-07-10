package com.dect.itiAdmission.repository;

import com.dect.itiAdmission.domain.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, String> {
}