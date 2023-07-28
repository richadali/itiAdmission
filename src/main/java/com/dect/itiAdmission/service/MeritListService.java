package com.dect.itiAdmission.service;

import com.dect.itiAdmission.domain.ApplicationDetails;
import com.dect.itiAdmission.domain.MeritList;
import com.dect.itiAdmission.domain.Trades;
import com.dect.itiAdmission.dtos.GetApplicationDetailsDTO;
import com.dect.itiAdmission.dtos.MeritListDTO;
import com.dect.itiAdmission.exception.ApplicantAlreadyExists;
import com.dect.itiAdmission.exception.DataInsertionException;
import com.dect.itiAdmission.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeritListService {
    @Autowired
    private MeritListRepository meritListRepository;

    @Autowired
    private ApplicationDetailsRepository applicationDetailsRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private TradesRepository tradesRepository;
    @Autowired
    private CenterRepository centerRepository;


    public String addMeritList(MeritListDTO meritListDTO) {
        String tradeName = null;
        try {
            MeritList meritList = meritListRepository.findByApplicationDetailsApplicationnumber(meritListDTO.getApplicationNumber());
            //            !meritListRepository.existsByApplicationDetails(applicationDetailsRepository.getReferenceById(meritListDTO.getApplicationNumber()))
            if (meritList == null) {
                MeritList meritLists = MeritList.builder()
                        .applicationDetails(applicationDetailsRepository.getReferenceById(meritListDTO.getApplicationNumber()))
                        .categories(categoriesRepository.getReferenceById(meritListDTO.getSelectedReservation()))
                        .ph(meritListDTO.getSelectedPh())
                        .trades(tradesRepository.getReferenceById(meritListDTO.getSelectedTrade()))
                        .centers(centerRepository.getReferenceById(meritListDTO.getSelectedITI()))
                        .build();
                meritListRepository.save(meritLists);
                return "Applicant successfully added to MeritList";
            } else {
                tradeName = meritList.getTrades().getTradeName();
                throw new DataIntegrityViolationException("Applicant already present for Trade: " + tradeName);
            }
        } catch (DataIntegrityViolationException e) {
            throw new ApplicantAlreadyExists("Applicant already present for Trade: " + tradeName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataInsertionException("Could not add to merit list, Please try again!");
        }
    }

    public List<GetApplicationDetailsDTO> getMeritListByCenterIdAndTradeId(Integer centerId, Integer tradeId) {
//        return meritListRepository.findByCentersCenterIdAndTradesTradeCode(centerId, tradeId);
        Trades trades = tradesRepository.findById(tradeId).orElseThrow(null);
        List<GetApplicationDetailsDTO> getApplicationDetailsDTO = new ArrayList<>();
        if (trades != null) {
            if (trades.getMathSc() == 'Y') {
                List<MeritList> meritListList = meritListRepository.findByCentersCenterIdAndTradesTradeCode(centerId, tradeId);
                meritListList.forEach(System.out::println);
                for (MeritList meritList : meritListList) {
                    getApplicationDetailsDTO.add(convertToGetApplicationDetailsDTO(meritList, tradeId));
                }
                assert false;
                return getApplicationDetailsDTO.stream().sorted(Comparator.comparing(GetApplicationDetailsDTO::getPercentage).reversed()).collect(Collectors.toList());
            } else if (trades.getTenthPass() == 'Y') {
                List<MeritList> meritListList = meritListRepository.findByCentersCenterIdAndTradesTradeCode(centerId, tradeId);
                meritListList.forEach(System.out::println);
                for (MeritList meritList : meritListList) {
                    getApplicationDetailsDTO.add(convertToGetApplicationDetailsDTO(meritList, tradeId));
                }
                assert false;
                return getApplicationDetailsDTO.stream().sorted(Comparator.comparing(GetApplicationDetailsDTO::getPercentagetenth).reversed()).collect(Collectors.toList());
            } else {
                List<MeritList> meritListList = meritListRepository.findByCentersCenterIdAndTradesTradeCode(centerId, tradeId);
                meritListList.forEach(System.out::println);
                for (MeritList meritList : meritListList) {
                    getApplicationDetailsDTO.add(convertToGetApplicationDetailsDTO(meritList, tradeId));
                }
                assert false;
                return getApplicationDetailsDTO.stream().sorted(Comparator.comparing(GetApplicationDetailsDTO::getPercentageeight).reversed()).collect(Collectors.toList());
            }
        }
        return null;
    }

    public GetApplicationDetailsDTO convertToGetApplicationDetailsDTO(MeritList applicationDetails, Integer tradeId) {
        Trades trades = tradesRepository.findById(tradeId).orElseThrow(null);
        if (applicationDetails.getApplicationDetails().getMarksmaths() == null || applicationDetails.getApplicationDetails().getMarksscience() == null) {
            return GetApplicationDetailsDTO.builder()
                    .applicationnumber(applicationDetails.getApplicationDetails().getApplicationnumber())
                    .centers(applicationDetails.getApplicationDetails().getCenters().getCenterName())
                    .applicantname(applicationDetails.getApplicationDetails().getApplicantname())
                    .fathername(applicationDetails.getApplicationDetails().getFathername())
                    .mothername(applicationDetails.getApplicationDetails().getMothername())
                    .gender(applicationDetails.getApplicationDetails().getGender())
                    .dob(applicationDetails.getApplicationDetails().getDob())
                    .categories(applicationDetails.getCategories().getCategoryName())
                    .religions(applicationDetails.getApplicationDetails().getReligions())
                    .tribes(applicationDetails.getApplicationDetails().getTribes())
                    .maritalStatus(applicationDetails.getApplicationDetails().getMaritalStatus().getMaritalStatus())
                    .mothertongue(applicationDetails.getApplicationDetails().getMothertongue())
                    .mobilenumber(applicationDetails.getApplicationDetails().getMobilenumber())
                    .email(applicationDetails.getApplicationDetails().getEmail())
                    .states(applicationDetails.getApplicationDetails().getStates().getName())
                    .districts(applicationDetails.getApplicationDetails().getDistricts().getName())
                    .townperm(applicationDetails.getApplicationDetails().getTownperm())
                    .addressperm(applicationDetails.getApplicationDetails().getAddressperm())
                    .pincodeperm(applicationDetails.getApplicationDetails().getPincodeperm())
                    .statescorr(applicationDetails.getApplicationDetails().getStatescorr().getName())
                    .districtscorr(applicationDetails.getApplicationDetails().getDistrictscorr().getName())
                    .towncorr(applicationDetails.getApplicationDetails().getTowncorr())
                    .addresscorr(applicationDetails.getApplicationDetails().getAddresscorr())
                    .pincodecorr(applicationDetails.getApplicationDetails().getPincodecorr())
                    .accountnumber(applicationDetails.getApplicationDetails().getAccountnumber())
                    .ifsccode(applicationDetails.getApplicationDetails().getIfsccode())
                    .bankname(applicationDetails.getApplicationDetails().getBankname())
                    .institutetenth(applicationDetails.getApplicationDetails().getInstitutetenth())
                    .boardtenth(applicationDetails.getApplicationDetails().getBoardtenth())
                    .yearpassingtenth(applicationDetails.getApplicationDetails().getYearpassingtenth())
                    .percentagetenth(applicationDetails.getApplicationDetails().getPercentagetenth())
                    .divisiontenth(applicationDetails.getApplicationDetails().getDivisiontenth())
                    .subjectstenth(applicationDetails.getApplicationDetails().getSubjectstenth())
                    .haveyoupassedboth(applicationDetails.getApplicationDetails().getHaveyoupassedboth())
                    .marksmaths(applicationDetails.getApplicationDetails().getMarksmaths())
                    .marksscience(applicationDetails.getApplicationDetails().getMarksscience())
                    .instituteeight(applicationDetails.getApplicationDetails().getInstituteeight())
                    .boardeight(applicationDetails.getApplicationDetails().getBoardeight())
                    .yearpassingeight(applicationDetails.getApplicationDetails().getYearpassingeight())
                    .percentageeight(applicationDetails.getApplicationDetails().getPercentageeight())
                    .divisioneight(applicationDetails.getApplicationDetails().getDivisioneight())
                    .subjectseight(applicationDetails.getApplicationDetails().getSubjectseight())
                    .trades1(applicationDetails.getApplicationDetails().getTrades1() != null ? applicationDetails.getApplicationDetails().getTrades1().getTradeName() : null)
                    .trades2(applicationDetails.getApplicationDetails().getTrades2() != null ? applicationDetails.getApplicationDetails().getTrades2().getTradeName() : null)
                    .trades3(applicationDetails.getApplicationDetails().getTrades3() != null ? applicationDetails.getApplicationDetails().getTrades3().getTradeName() : null)
                    .submissiondate(applicationDetails.getApplicationDetails().getSubmissiondate())
                    .ph(applicationDetails.getPh())
                    .percentage(null)
                    .mathsScience(trades.getMathSc())
                    .tenthPass(trades.getTenthPass())
                    .build();
        } else {
            double s = Double.parseDouble(applicationDetails.getApplicationDetails().getMarksmaths()) + Double.parseDouble(applicationDetails.getApplicationDetails().getMarksscience());
            s = s / 200 * 100;
            return GetApplicationDetailsDTO.builder()
                    .applicationnumber(applicationDetails.getApplicationDetails().getApplicationnumber())
                    .centers(applicationDetails.getApplicationDetails().getCenters().getCenterName())
                    .applicantname(applicationDetails.getApplicationDetails().getApplicantname())
                    .fathername(applicationDetails.getApplicationDetails().getFathername())
                    .mothername(applicationDetails.getApplicationDetails().getMothername())
                    .gender(applicationDetails.getApplicationDetails().getGender())
                    .dob(applicationDetails.getApplicationDetails().getDob())
                    .categories(applicationDetails.getCategories().getCategoryName())
                    .religions(applicationDetails.getApplicationDetails().getReligions())
                    .tribes(applicationDetails.getApplicationDetails().getTribes())
                    .maritalStatus(applicationDetails.getApplicationDetails().getMaritalStatus().getMaritalStatus())
                    .mothertongue(applicationDetails.getApplicationDetails().getMothertongue())
                    .mobilenumber(applicationDetails.getApplicationDetails().getMobilenumber())
                    .email(applicationDetails.getApplicationDetails().getEmail())
                    .states(applicationDetails.getApplicationDetails().getStates().getName())
                    .districts(applicationDetails.getApplicationDetails().getDistricts().getName())
                    .townperm(applicationDetails.getApplicationDetails().getTownperm())
                    .addressperm(applicationDetails.getApplicationDetails().getAddressperm())
                    .pincodeperm(applicationDetails.getApplicationDetails().getPincodeperm())
                    .statescorr(applicationDetails.getApplicationDetails().getStatescorr().getName())
                    .districtscorr(applicationDetails.getApplicationDetails().getDistrictscorr().getName())
                    .towncorr(applicationDetails.getApplicationDetails().getTowncorr())
                    .addresscorr(applicationDetails.getApplicationDetails().getAddresscorr())
                    .pincodecorr(applicationDetails.getApplicationDetails().getPincodecorr())
                    .accountnumber(applicationDetails.getApplicationDetails().getAccountnumber())
                    .ifsccode(applicationDetails.getApplicationDetails().getIfsccode())
                    .bankname(applicationDetails.getApplicationDetails().getBankname())
                    .institutetenth(applicationDetails.getApplicationDetails().getInstitutetenth())
                    .boardtenth(applicationDetails.getApplicationDetails().getBoardtenth())
                    .yearpassingtenth(applicationDetails.getApplicationDetails().getYearpassingtenth())
                    .percentagetenth(applicationDetails.getApplicationDetails().getPercentagetenth())
                    .divisiontenth(applicationDetails.getApplicationDetails().getDivisiontenth())
                    .subjectstenth(applicationDetails.getApplicationDetails().getSubjectstenth())
                    .haveyoupassedboth(applicationDetails.getApplicationDetails().getHaveyoupassedboth())
                    .marksmaths(applicationDetails.getApplicationDetails().getMarksmaths())
                    .marksscience(applicationDetails.getApplicationDetails().getMarksscience())
                    .instituteeight(applicationDetails.getApplicationDetails().getInstituteeight())
                    .boardeight(applicationDetails.getApplicationDetails().getBoardeight())
                    .yearpassingeight(applicationDetails.getApplicationDetails().getYearpassingeight())
                    .percentageeight(applicationDetails.getApplicationDetails().getPercentageeight())
                    .divisioneight(applicationDetails.getApplicationDetails().getDivisioneight())
                    .subjectseight(applicationDetails.getApplicationDetails().getSubjectseight())
                    .trades1(applicationDetails.getApplicationDetails().getTrades1() != null ? applicationDetails.getApplicationDetails().getTrades1().getTradeName() : null)
                    .trades2(applicationDetails.getApplicationDetails().getTrades2() != null ? applicationDetails.getApplicationDetails().getTrades2().getTradeName() : null)
                    .trades3(applicationDetails.getApplicationDetails().getTrades3() != null ? applicationDetails.getApplicationDetails().getTrades3().getTradeName() : null)
                    .submissiondate(applicationDetails.getApplicationDetails().getSubmissiondate())
                    .ph(applicationDetails.getPh())
                    .percentage(Double.valueOf(new DecimalFormat("#.##").format(s)))
                    .mathsScience(trades.getMathSc())
                    .tenthPass(trades.getTenthPass())
                    .build();
        }
    }

    public String removeFromMeritList(String applicationNumber) {
        try {
            meritListRepository.deleteByApplicationDetailsApplicationnumber(applicationNumber);
            return "Successfully deleted";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Something went wrong!!");
        }
    }

    public MeritList getApplicantById(String id) {
        return meritListRepository.findByApplicationDetailsApplicationnumber(id);
    }
}
