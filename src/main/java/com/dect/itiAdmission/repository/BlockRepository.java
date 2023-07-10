package com.dect.itiAdmission.repository;

import com.dect.itiAdmission.domain.Blocks;
import com.dect.itiAdmission.domain.Districts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepository extends JpaRepository<Blocks,Long> {
    List<Blocks> findAllByDistricts(Districts districts);
}
