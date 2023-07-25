package com.dect.itiAdmission.service;


import com.dect.itiAdmission.domain.ApplicationDetails;
import com.dect.itiAdmission.dtos.GetApplicationDetailsDTO;
import com.dect.itiAdmission.repository.ApplicationDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class WaitingListService {
    @Autowired
    private ApplicationDetailsRepository applicationDetailsRepository;
    @Autowired
    private ApplicationDetailsService applicationDetailsService;

    public List<GetApplicationDetailsDTO> getWaitingListByCenterIdAndTradeId(Integer centerId, Integer tradeId) {
        List<ApplicationDetails> applicationDetails = applicationDetailsRepository.findAllNotInMeritList(centerId, tradeId);
        List<GetApplicationDetailsDTO> getApplicationDetailsDTOS = applicationDetails.stream()
                .map(applicationDetails1 -> applicationDetailsService.convertToGetApplicationDetailsDTO(applicationDetails1, tradeId))
                .toList();
        return getApplicationDetailsDTOS;
    }


}
