package com.dect.itiAdmission.repository;
import com.dect.itiAdmission.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles,Long> {
}
