package com.dect.itiAdmission.repository;

import com.dect.itiAdmission.domain.CenterTrades;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CenterTradeRepository extends JpaRepository<CenterTrades, Integer> {
    List<CenterTrades> findByCenterIdCenterIdAndIsActiveOrderByTradeIdAsc(Integer centerId, Character isActive);
}
