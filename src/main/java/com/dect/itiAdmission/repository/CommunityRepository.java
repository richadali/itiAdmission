package com.dect.itiAdmission.repository;

import com.dect.itiAdmission.domain.Communities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Communities, Integer> {
}
