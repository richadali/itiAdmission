package com.dect.itiAdmission.service;

import com.dect.itiAdmission.domain.MeritList;
import com.dect.itiAdmission.dtos.MeritListDTO;
import com.dect.itiAdmission.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String addMeritList(List<MeritListDTO> meritListDTO) {
        try{
            List<MeritList> meritLists= meritListDTO.stream().map(meritListDTO1 -> {
                return MeritList.builder()
                        .applicationDetails(applicationDetailsRepository.getReferenceById(meritListDTO1.getApplicationNumber()))
                        .categories(categoriesRepository.getReferenceById(meritListDTO1.getSelectedReservation()))
                        .ph(meritListDTO1.getSelectedPh())
                        .trades(tradesRepository.getReferenceById(meritListDTO1.getSelectedTrade()))
                        .centers(centerRepository.getReferenceById(meritListDTO1.getSelectedITI()))
                        .build();
            }).toList();

            meritLists.forEach(System.out::println);
//            List<MeritList> meritLists=convertToMeritList(meritListDTO)
            meritListRepository.saveAll(meritLists);
            return "Data Inserted Successfully to MeritList Table";
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<MeritList> getMeritListByCenterIdAndTradeId(Integer centerId, Integer tradeId) {
        return meritListRepository.findByCentersCenterIdAndTradesTradeCode(centerId, tradeId);
    }

//    public List<MeritList> convertToMeritList(List<MeritListDTO> meritListDTO){
//       List<MeritList> meritLists = null;
//       for(MeritListDTO meritListDTO1:meritListDTO){
////           MeritList meritList=new MeritList();\
//
//           MeritList meritList=MeritList.builder()
//                   .applicationDetails(applicationDetailsRepository.getReferenceById(meritListDTO1.getApplicationNumber()))
//                   .categories(categoriesRepository.getReferenceById(meritListDTO1.getSelectedReservation()))
//                   .phase(meritListDTO1.getSelectedPhase())
//                   .ph(meritListDTO1.getSelectedPh())
//                   .trades(tradesRepository.getReferenceById(meritListDTO1.getSelectedTrade()))
//                   .build();
//           meritLists.add(meritList);
//       }
//        return meritLists;
//    }

}
