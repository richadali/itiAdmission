package com.dect.itiAdmission.repository;

import com.dect.itiAdmission.domain.ApplicationDetails;
import com.dect.itiAdmission.dtos.GetApplicationDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicationDetailsRepository extends JpaRepository<ApplicationDetails, String> {

    List<ApplicationDetails> findByCentersCenterIdAndTrades1TradeCodeOrTrades2TradeCodeOrTrades3TradeCode(Integer centerId, Integer tradeId, Integer tradeId1, Integer tradeId2);

    List<ApplicationDetails> findByCentersCenterIdAndTrades1TradeCodeOrCentersCenterIdAndTrades2TradeCodeOrCentersCenterIdAndTrades3TradeCode(Integer centerId, Integer tradeId, Integer centerId1, Integer tradeId1, Integer centerId2, Integer tradeId2);

    boolean existsByApplicationnumber(String applicationNumber);

    @Query("SELECT ap FROM ApplicationDetails ap " +
            "WHERE ap.centers.centerId = :centerId " +
            "AND (ap.trades1.tradeCode = :tradeId OR ap.trades2.tradeCode = :tradeId OR ap.trades3.tradeCode = :tradeId) " +
            "AND ap.applicationnumber NOT IN (SELECT ml.applicationDetails.applicationnumber FROM MeritList ml)")
    List<ApplicationDetails> findAllNotInMeritList(Integer centerId, Integer tradeId);
}
