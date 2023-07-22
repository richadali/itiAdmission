package com.dect.itiAdmission.service;

import com.dect.itiAdmission.domain.*;
import com.dect.itiAdmission.dtos.ApplicationDetailsDTO;
import com.dect.itiAdmission.dtos.GetApplicationDetailsDTO;
import com.dect.itiAdmission.exception.ApplicantNotPresent;
import com.dect.itiAdmission.repository.ApplicationDetailsRepository;
import com.dect.itiAdmission.repository.GenderRepository;
import com.dect.itiAdmission.repository.TradesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class ApplicationDetailsService {
    @Autowired
    private ApplicationDetailsRepository applicationDetailsRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private TradesRepository tradesRepository;

    public Long applicationsCount() {
        return applicationDetailsRepository.count();
    }

    public List<ApplicationDetails> applicantList() {
        return applicationDetailsRepository.findAll();
    }

    public ApplicationDetails applicationDetails(String applicationnumber) {
        return applicationDetailsRepository.findById(applicationnumber)
                .orElseThrow(() -> new ApplicantNotPresent("Application No with " + applicationnumber + " is not present."));
    }

    public List<GetApplicationDetailsDTO> getApplicationByCenterIdAndTradeId(Integer centerId, Integer tradeId) {
        Trades trades = tradesRepository.findById(tradeId).orElseThrow(null);
        List<GetApplicationDetailsDTO> getApplicationDetailsDTO = new ArrayList<>();
        if (trades != null) {
            if (trades.getMathSc() == 'Y') {
                List<ApplicationDetails> applicationDetailsList = applicationDetailsRepository.findByCentersCenterIdAndTrades1TradeCodeOrCentersCenterIdAndTrades2TradeCodeOrCentersCenterIdAndTrades3TradeCode(centerId, tradeId, centerId, tradeId, centerId, tradeId);
                applicationDetailsList.forEach(System.out::println);
                for (ApplicationDetails applicationDetails : applicationDetailsList) {
                    getApplicationDetailsDTO.add(convertToGetApplicationDetailsDTO(applicationDetails, tradeId));
                }
                assert false;
                return getApplicationDetailsDTO.stream().sorted(Comparator.comparing(GetApplicationDetailsDTO::getPercentage).reversed()).toList();
            } else if (trades.getTenthPass() == 'Y') {
                List<ApplicationDetails> applicationDetailsList = applicationDetailsRepository.findByCentersCenterIdAndTrades1TradeCodeOrCentersCenterIdAndTrades2TradeCodeOrCentersCenterIdAndTrades3TradeCode(centerId, tradeId, centerId, tradeId, centerId, tradeId);
                if (applicationDetailsList != null) {
                    for (ApplicationDetails applicationDetails : applicationDetailsList) {
                        getApplicationDetailsDTO.add(convertToGetApplicationDetailsDTO(applicationDetails, tradeId));
                    }
                }
                assert false;
                return getApplicationDetailsDTO.stream().sorted(Comparator.comparing(GetApplicationDetailsDTO::getPercentagetenth).reversed()).toList();
            } else {
                List<ApplicationDetails> applicationDetailsList = applicationDetailsRepository.findByCentersCenterIdAndTrades1TradeCodeOrCentersCenterIdAndTrades2TradeCodeOrCentersCenterIdAndTrades3TradeCode(centerId, tradeId, centerId, tradeId, centerId, tradeId);
                if (applicationDetailsList != null) {
                    applicationDetailsList.forEach(System.out::println);
                    for (ApplicationDetails applicationDetails : applicationDetailsList) {
                        getApplicationDetailsDTO.add(convertToGetApplicationDetailsDTO(applicationDetails, tradeId));
                    }
                }
                assert false;
                return getApplicationDetailsDTO.stream().sorted(Comparator.comparing(GetApplicationDetailsDTO::getPercentageeight).reversed()).toList();
            }
        }
        return null;
    }

    public GetApplicationDetailsDTO convertToGetApplicationDetailsDTO(ApplicationDetails applicationDetails, Integer tradeId) {
        Trades trades = tradesRepository.findById(tradeId).orElseThrow(null);
        if (applicationDetails.getMarksmaths() == null || applicationDetails.getMarksscience() == null) {
            return GetApplicationDetailsDTO.builder()
                    .applicationnumber(applicationDetails.getApplicationnumber())
                    .centers(applicationDetails.getCenters().getCenterName())
                    .applicantname(applicationDetails.getApplicantname())
                    .fathername(applicationDetails.getFathername())
                    .mothername(applicationDetails.getMothername())
                    .gender(applicationDetails.getGender())
                    .dob(applicationDetails.getDob())
                    .categories(applicationDetails.getCategories().getCategoryName())
                    .religions(applicationDetails.getReligions())
                    .tribes(applicationDetails.getTribes())
                    .maritalStatus(applicationDetails.getMaritalStatus().getMaritalStatus())
                    .mothertongue(applicationDetails.getMothertongue())
                    .mobilenumber(applicationDetails.getMobilenumber())
                    .email(applicationDetails.getEmail())
                    .states(applicationDetails.getStates().getName())
                    .districts(applicationDetails.getDistricts().getName())
                    .townperm(applicationDetails.getTownperm())
                    .addressperm(applicationDetails.getAddressperm())
                    .pincodeperm(applicationDetails.getPincodeperm())
                    .statescorr(applicationDetails.getStatescorr().getName())
                    .districtscorr(applicationDetails.getDistrictscorr().getName())
                    .towncorr(applicationDetails.getTowncorr())
                    .addresscorr(applicationDetails.getAddresscorr())
                    .pincodecorr(applicationDetails.getPincodecorr())
                    .accountnumber(applicationDetails.getAccountnumber())
                    .ifsccode(applicationDetails.getIfsccode())
                    .bankname(applicationDetails.getBankname())
                    .institutetenth(applicationDetails.getInstitutetenth())
                    .boardtenth(applicationDetails.getBoardtenth())
                    .yearpassingtenth(applicationDetails.getYearpassingtenth())
                    .percentagetenth(applicationDetails.getPercentagetenth())
                    .divisiontenth(applicationDetails.getDivisiontenth())
                    .subjectstenth(applicationDetails.getSubjectstenth())
                    .haveyoupassedboth(applicationDetails.getHaveyoupassedboth())
                    .marksmaths(applicationDetails.getMarksmaths())
                    .marksscience(applicationDetails.getMarksscience())
                    .instituteeight(applicationDetails.getInstituteeight())
                    .boardeight(applicationDetails.getBoardeight())
                    .yearpassingeight(applicationDetails.getYearpassingeight())
                    .percentageeight(applicationDetails.getPercentageeight())
                    .divisioneight(applicationDetails.getDivisioneight())
                    .subjectseight(applicationDetails.getSubjectseight())
                    .trades1(applicationDetails.getTrades1() != null ? applicationDetails.getTrades1().getTradeName() : null)
                    .trades2(applicationDetails.getTrades2() != null ? applicationDetails.getTrades2().getTradeName() : null)
                    .trades3(applicationDetails.getTrades3() != null ? applicationDetails.getTrades3().getTradeName() : null)
                    .submissiondate(applicationDetails.getSubmissiondate())
                    .ph(applicationDetails.getPh())
                    .percentage(null)
                    .mathsScience(trades.getMathSc())
                    .tenthPass(trades.getTenthPass())
                    .build();
        } else {
            double s = Double.parseDouble(applicationDetails.getMarksmaths()) + Double.parseDouble(applicationDetails.getMarksscience());
            s = s / 200 * 100;
            return GetApplicationDetailsDTO.builder()
                    .applicationnumber(applicationDetails.getApplicationnumber())
                    .centers(applicationDetails.getCenters().getCenterName())
                    .applicantname(applicationDetails.getApplicantname())
                    .fathername(applicationDetails.getFathername())
                    .mothername(applicationDetails.getMothername())
                    .gender(applicationDetails.getGender())
                    .dob(applicationDetails.getDob())
                    .categories(applicationDetails.getCategories().getCategoryName())
                    .religions(applicationDetails.getReligions())
                    .tribes(applicationDetails.getTribes())
                    .maritalStatus(applicationDetails.getMaritalStatus().getMaritalStatus())
                    .mothertongue(applicationDetails.getMothertongue())
                    .mobilenumber(applicationDetails.getMobilenumber())
                    .email(applicationDetails.getEmail())
                    .states(applicationDetails.getStates().getName())
                    .districts(applicationDetails.getDistricts().getName())
                    .townperm(applicationDetails.getTownperm())
                    .addressperm(applicationDetails.getAddressperm())
                    .pincodeperm(applicationDetails.getPincodeperm())
                    .statescorr(applicationDetails.getStatescorr().getName())
                    .districtscorr(applicationDetails.getDistrictscorr().getName())
                    .towncorr(applicationDetails.getTowncorr())
                    .addresscorr(applicationDetails.getAddresscorr())
                    .pincodecorr(applicationDetails.getPincodecorr())
                    .accountnumber(applicationDetails.getAccountnumber())
                    .ifsccode(applicationDetails.getIfsccode())
                    .bankname(applicationDetails.getBankname())
                    .institutetenth(applicationDetails.getInstitutetenth())
                    .boardtenth(applicationDetails.getBoardtenth())
                    .yearpassingtenth(applicationDetails.getYearpassingtenth())
                    .percentagetenth(applicationDetails.getPercentagetenth())
                    .divisiontenth(applicationDetails.getDivisiontenth())
                    .subjectstenth(applicationDetails.getSubjectstenth())
                    .haveyoupassedboth(applicationDetails.getHaveyoupassedboth())
                    .marksmaths(applicationDetails.getMarksmaths())
                    .marksscience(applicationDetails.getMarksscience())
                    .instituteeight(applicationDetails.getInstituteeight())
                    .boardeight(applicationDetails.getBoardeight())
                    .yearpassingeight(applicationDetails.getYearpassingeight())
                    .percentageeight(applicationDetails.getPercentageeight())
                    .divisioneight(applicationDetails.getDivisioneight())
                    .subjectseight(applicationDetails.getSubjectseight())
                    .trades1(applicationDetails.getTrades1() != null ? applicationDetails.getTrades1().getTradeName() : null)
                    .trades2(applicationDetails.getTrades2() != null ? applicationDetails.getTrades2().getTradeName() : null)
                    .trades3(applicationDetails.getTrades3() != null ? applicationDetails.getTrades3().getTradeName() : null)
                    .submissiondate(applicationDetails.getSubmissiondate())
                    .ph(applicationDetails.getPh())
                    .percentage(Double.valueOf(new DecimalFormat("#.##").format(s)))
                    .mathsScience(trades.getMathSc())
                    .tenthPass(trades.getTenthPass())
                    .build();
        }
    }

//           }

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
//                }
//        ).findFirst().orElseThrow(()->new RuntimeException("Applicant is not present"));
//    }
}
