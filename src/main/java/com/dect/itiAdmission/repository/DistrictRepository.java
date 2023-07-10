package com.dect.itiAdmission.repository;

import com.dect.itiAdmission.domain.Districts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<Districts,Long> {


}
