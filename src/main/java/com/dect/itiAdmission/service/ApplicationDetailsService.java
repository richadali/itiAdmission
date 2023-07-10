package com.dect.itiAdmission.service;

import com.dect.itiAdmission.domain.ApplicationDetails;
import com.dect.itiAdmission.dtos.ApplicationDetailsDTO;
import com.dect.itiAdmission.repository.ApplicationDetailsRepository;
import com.dect.itiAdmission.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationDetailsService {
    @Autowired
    private ApplicationDetailsRepository applicationDetailsRepository;

    @Autowired
    private GenderRepository genderRepository;

    public Long applicationsCount(){
        return applicationDetailsRepository.count();
    }

    public List<ApplicationDetails> applicantList(){
        return applicationDetailsRepository.findAll();
    }

     public ApplicationDetails applicationDetails(String applicationnumber){
        return applicationDetailsRepository.findById(applicationnumber).orElseThrow();
    }

    public List<ApplicationDetails> getApplicationByCenterIdAndTradeId(Integer centerId, Integer tradeId) {
        return applicationDetailsRepository.findByCentersCenterIdAndTrades1TradeCodeOrCentersCenterIdAndTrades2TradeCodeOrCentersCenterIdAndTrades3TradeCode(centerId, tradeId, centerId, tradeId, centerId, tradeId);
    }

//    public String editApplicationDetails(ApplicationDetailsDTO applicationDetailsDTO) {
//        return applicationDetailsRepository.findById(applicationDetailsDTO.getApplicationnumber()).stream().map(
//                applicationDetails1 -> {
//                    try{
//                        applicationDetails1.setApplicantname(applicationDetailsDTO.getApplicantname());
//                        applicationDetails1.setFathername(applicationDetailsDTO.getFathername());
//                        applicationDetails1.setMothername(applicationDetailsDTO.getMothername());
//                        applicationDetails1.setGender(genderRepository.getReferenceById(applicationDetailsDTO.getGender()));
//                        applicationDetails1.setDob(applicationDetailsDTO.getDob());
//                        applicationDetailsRepository.save(applicationDetails1);
//                        return "updated";
//                    }catch (Exception e){
//                        return e.getMessage();
//                    }
//
//                }
//        ).findFirst().orElseThrow(()->new RuntimeException("Applicant is not present"));
//    }
}
