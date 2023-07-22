package com.dect.itiAdmission.service;

import com.dect.itiAdmission.domain.MeritList;
import com.dect.itiAdmission.dtos.MeritListDTO;
import com.dect.itiAdmission.exception.ApplicantAlreadyExists;
import com.dect.itiAdmission.exception.DataInsertionException;
import com.dect.itiAdmission.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
        try {
            if (!meritListRepository.existsByApplicationDetails(applicationDetailsRepository.getReferenceById(meritListDTO.getApplicationNumber()))) {
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
                throw new DataIntegrityViolationException("Applicant already present");
            }
        } catch (DataIntegrityViolationException e) {
            throw new ApplicantAlreadyExists("Applicant already present");
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataInsertionException("Could not add to merit list, Please try again!");
        }
    }

    public List<MeritList> getMeritListByCenterIdAndTradeId(Integer centerId, Integer tradeId) {
        return meritListRepository.findByCentersCenterIdAndTradesTradeCode(centerId, tradeId);
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
}
