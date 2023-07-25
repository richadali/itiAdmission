package com.dect.itiAdmission.service;


import com.dect.itiAdmission.domain.ApplicationDetails;
import com.dect.itiAdmission.domain.Trades;
import com.dect.itiAdmission.dtos.GetApplicationDetailsDTO;
import com.dect.itiAdmission.repository.ApplicationDetailsRepository;
import com.dect.itiAdmission.repository.TradesRepository;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class WaitingListService {
    @Autowired
    private ApplicationDetailsRepository applicationDetailsRepository;
    @Autowired
    private ApplicationDetailsService applicationDetailsService;
    @Autowired
    private TradesRepository tradesRepository;

    public List<GetApplicationDetailsDTO> getWaitingListByCenterIdAndTradeId(Integer centerId, Integer tradeId) {
//        List<ApplicationDetails> applicationDetails = applicationDetailsRepository.findAllNotInMeritList(centerId, tradeId);
//        List<GetApplicationDetailsDTO> getApplicationDetailsDTOS = applicationDetails.stream()
//                .map(applicationDetails1 -> applicationDetailsService.convertToGetApplicationDetailsDTO(applicationDetails1, tradeId))
//                .sorted()
//                .toList();
//        return getApplicationDetailsDTOS;


        Trades trades = tradesRepository.findById(tradeId).orElseThrow(null);
        List<GetApplicationDetailsDTO> getApplicationDetailsDTO = new ArrayList<>();
        if (trades != null) {
            if (trades.getMathSc() == 'Y') {
                return applicationDetailsRepository.findAllNotInMeritList(centerId, tradeId).stream()
                        .map(applicationDetails1 -> applicationDetailsService.convertToGetApplicationDetailsDTO(applicationDetails1, tradeId))
                        .sorted(Comparator.comparing(GetApplicationDetailsDTO::getPercentage).reversed())
                        .toList();
            } else if (trades.getTenthPass() == 'Y') {
                return applicationDetailsRepository.findAllNotInMeritList(centerId, tradeId).stream()
                        .map(applicationDetails1 -> applicationDetailsService.convertToGetApplicationDetailsDTO(applicationDetails1, tradeId))
                        .sorted(Comparator.comparing(GetApplicationDetailsDTO::getPercentagetenth).reversed())
                        .toList();
            } else {
                return applicationDetailsRepository.findAllNotInMeritList(centerId, tradeId).stream()
                        .map(applicationDetails1 -> applicationDetailsService.convertToGetApplicationDetailsDTO(applicationDetails1, tradeId))
                        .sorted(Comparator.comparing(GetApplicationDetailsDTO::getPercentageeight).reversed())
                        .toList();
            }
        }
        return null;


    }


}
