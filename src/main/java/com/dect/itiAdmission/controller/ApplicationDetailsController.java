package com.dect.itiAdmission.controller;

import com.dect.itiAdmission.domain.ApplicationDetails;
import com.dect.itiAdmission.domain.Gender;
import com.dect.itiAdmission.domain.MaritalStatus;
import com.dect.itiAdmission.dtos.ApplicationDetailsDTO;
import com.dect.itiAdmission.dtos.GetApplicationDetailsDTO;
import com.dect.itiAdmission.repository.ApplicationDetailsRepository;
import com.dect.itiAdmission.repository.GenderRepository;
import com.dect.itiAdmission.repository.MaritalStatusRepository;
import com.dect.itiAdmission.service.ApplicationDetailsService;
import com.dect.itiAdmission.service.CenterService;
import com.dect.itiAdmission.service.WaitingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("secure")
public class ApplicationDetailsController {

    @Autowired
    private ApplicationDetailsRepository applicationDetailsRepository;

    @Autowired
    private ApplicationDetailsService applicationDetailsService;

    @Autowired
    private CenterService centerService;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private WaitingListService waitingListService;

    @Autowired
    private MaritalStatusRepository maritalStatusRepository;

    @GetMapping("application_no")
    public ApplicationDetails getDetailsByApplicationNo(String id, Model model) {
        ApplicationDetails applicationDetails = applicationDetailsService.applicationDetails(id);
        model.addAttribute("applicationDetails", applicationDetails);
        return applicationDetails;
    }

    ///secure
    @GetMapping("getApplicationByCenterIdAndTradeId/{centerId}/{tradeId}")
    public List<?> getApplicationByCenterIdAndTradeId(@PathVariable Integer centerId, @PathVariable Integer tradeId) {
//        ApplicationDetails applicationDetails = applicationnumber.applicationDetails(id);
//        System.out.println(applicationDetails);
//        model.addAttribute("applicationDetails", applicationDetails);
        System.out.println("-----------------------------------------------");
        List<GetApplicationDetailsDTO> getApplicationDetailsDTO = applicationDetailsService.getApplicationByCenterIdAndTradeId(centerId, tradeId);
        getApplicationDetailsDTO.forEach(System.out::println);
        return getApplicationDetailsDTO;
    }


    @PutMapping("editApplicationDetails")
    public ResponseEntity<?> edit(@RequestBody ApplicationDetailsDTO applicationDetailsDTO) {
        return ResponseEntity.ok(applicationDetailsService.editApplicationDetails(applicationDetailsDTO));
    }


    //FOR WAITING LIST
    @GetMapping("getWaitingListByCenterIdAndTradeId/{centerId}/{tradeId}")
    public List<?> getMeritListByCenterIdAndTradeId(@PathVariable Integer centerId, @PathVariable Integer tradeId) {
        System.out.println("-----------------------------------------------");
        List<GetApplicationDetailsDTO> getApplicationDetailsDTO = waitingListService.getWaitingListByCenterIdAndTradeId(centerId, tradeId);
        getApplicationDetailsDTO.forEach(System.out::println);
        return getApplicationDetailsDTO;
    }
}
