package com.dect.itiAdmission.service;

import com.dect.itiAdmission.domain.*;
import com.dect.itiAdmission.dtos.ApplicationDetailsDTO;
import com.dect.itiAdmission.dtos.GetApplicationDetailsDTO;
import com.dect.itiAdmission.exception.ApplicantNotPresent;
import com.dect.itiAdmission.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ApplicationDetailsService {
    @Autowired
    private ApplicationDetailsRepository applicationDetailsRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private TradesRepository tradesRepository;

    @Autowired
    private MaritalStatusRepository maritalStatusRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private ReligionRepository religionRepository;

    @Autowired
    private TribesRepository tribesRepository;

    @Autowired
    private DistrictRepository districtRepository;


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
                return getApplicationDetailsDTO.stream().sorted(Comparator.comparing(GetApplicationDetailsDTO::getPercentage).reversed()).collect(Collectors.toList());
            } else if (trades.getTenthPass() == 'Y') {
                List<ApplicationDetails> applicationDetailsList = applicationDetailsRepository.findByCentersCenterIdAndTrades1TradeCodeOrCentersCenterIdAndTrades2TradeCodeOrCentersCenterIdAndTrades3TradeCode(centerId, tradeId, centerId, tradeId, centerId, tradeId);
                if (applicationDetailsList != null) {
                    for (ApplicationDetails applicationDetails : applicationDetailsList) {
                        getApplicationDetailsDTO.add(convertToGetApplicationDetailsDTO(applicationDetails, tradeId));
                    }
                }
                assert false;
                return getApplicationDetailsDTO.stream().sorted(Comparator.comparing(GetApplicationDetailsDTO::getPercentagetenth).reversed()).collect(Collectors.toList());
            } else {
                List<ApplicationDetails> applicationDetailsList = applicationDetailsRepository.findByCentersCenterIdAndTrades1TradeCodeOrCentersCenterIdAndTrades2TradeCodeOrCentersCenterIdAndTrades3TradeCode(centerId, tradeId, centerId, tradeId, centerId, tradeId);
                if (applicationDetailsList != null) {
                    applicationDetailsList.forEach(System.out::println);
                    for (ApplicationDetails applicationDetails : applicationDetailsList) {
                        getApplicationDetailsDTO.add(convertToGetApplicationDetailsDTO(applicationDetails, tradeId));
                    }
                }
                assert false;
                return getApplicationDetailsDTO.stream().sorted(Comparator.comparing(GetApplicationDetailsDTO::getPercentageeight).reversed()).collect(Collectors.toList());
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
                    .districtscorr(applicationDetails.getDistrictscorr() != null ? applicationDetails.getDistrictscorr().getName() : null)
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
                    .districtscorr(applicationDetails.getDistrictscorr() != null ? applicationDetails.getDistrictscorr().getName() : null)
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

    public ApplicationDetailsDTO editApplicationDetails(ApplicationDetailsDTO applicationDetailsDTO) {
        System.out.println(applicationDetailsDTO);
        MaritalStatus maritalStatus = maritalStatusRepository.findById(applicationDetailsDTO.getMaritalStatus()).orElseThrow();
        Categories categories = categoriesRepository.findById(applicationDetailsDTO.getCategories()).orElseThrow();
        Religions religions = religionRepository.findById(applicationDetailsDTO.getReligions()).orElseThrow();
        Tribes tribes = tribesRepository.findById(applicationDetailsDTO.getTribes()).orElseThrow();
        Districts districts = districtRepository.findById(applicationDetailsDTO.getDistricts()).orElseThrow();
        Districts districtscorr = districtRepository.findById(applicationDetailsDTO.getDistrictscorr()).orElseThrow();

        ApplicationDetails applicationDetails = applicationDetailsRepository.findById(applicationDetailsDTO.getApplicationnumber()).orElseThrow();
        Gender gender = genderRepository.findById(applicationDetailsDTO.getGender()).orElseThrow();
        applicationDetails.setApplicationnumber(applicationDetailsDTO.getApplicationnumber());
        applicationDetails.setApplicantname(applicationDetailsDTO.getApplicantname());
        applicationDetails.setFathername(applicationDetailsDTO.getFathername());
        applicationDetails.setMothername(applicationDetailsDTO.getMothername());
        applicationDetails.setGender(gender);
        applicationDetails.setDob(applicationDetailsDTO.getDob());
        applicationDetails.setCategories(categories);
        applicationDetails.setReligions(religions);
        applicationDetails.setTribes(tribes);
        applicationDetails.setMaritalStatus(maritalStatus);
        applicationDetails.setMothertongue(applicationDetailsDTO.getMothertongue());
        applicationDetails.setDistricts(districts);
        applicationDetails.setTownperm(applicationDetailsDTO.getTownperm());
        applicationDetails.setAddressperm(applicationDetailsDTO.getAddressperm());
        applicationDetails.setPincodeperm(applicationDetailsDTO.getPincodeperm());
        applicationDetails.setDistrictscorr(districtscorr);
        applicationDetails.setTowncorr(applicationDetailsDTO.getTowncorr());
        applicationDetails.setAddresscorr(applicationDetailsDTO.getAddresscorr());
        applicationDetails.setPincodecorr(applicationDetailsDTO.getPincodecorr());
        applicationDetails.setAccountnumber(applicationDetailsDTO.getAccountnumber());
        applicationDetails.setIfsccode(applicationDetailsDTO.getIfsccode());
        applicationDetails.setBankname(applicationDetailsDTO.getBankname());
        applicationDetailsRepository.save(applicationDetails);
        return applicationDetailsDTO;
    }

}
