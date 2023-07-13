package com.dect.itiAdmission.repository;

import com.dect.itiAdmission.domain.MeritList;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface MeritListRepository extends JpaRepository<MeritList, Integer> {
    List<MeritList> findByCentersCenterIdAndTradesTradeCodeAndPhase(Integer centerId, Integer tradeCode, Integer phase);
//    List<MeritList> findByCentersCenterIdAndTrades1TradeCodeOrCentersCenterIdAndTrades2TradeCodeOrCentersCenterIdAndTrades3TradeCode(Integer centerId, Integer tradeId, Integer centerId1, Integer tradeId1, Integer centerId2, Integer tradeId2);
}
