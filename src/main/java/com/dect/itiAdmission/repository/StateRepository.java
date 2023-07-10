package com.dect.itiAdmission.repository;
import com.dect.itiAdmission.domain.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<States,Long> {
}
