package com.dect.itiAdmission.repository;

import com.dect.itiAdmission.domain.ApplicationDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationDetailsRepository extends JpaRepository<ApplicationDetails, String> {

    List<ApplicationDetails> findByCentersCenterIdAndTrades1TradeCodeOrTrades2TradeCodeOrTrades3TradeCode(Integer centerId, Integer tradeId, Integer tradeId1, Integer tradeId2);

    List<ApplicationDetails> findByCentersCenterIdAndTrades1TradeCodeOrCentersCenterIdAndTrades2TradeCodeOrCentersCenterIdAndTrades3TradeCode(Integer centerId, Integer tradeId, Integer centerId1, Integer tradeId1, Integer centerId2, Integer tradeId2);

    boolean existsByApplicationnumber(String applicationNumber);
}
