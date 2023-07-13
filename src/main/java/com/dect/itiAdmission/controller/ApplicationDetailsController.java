package com.dect.itiAdmission.controller;

import com.dect.itiAdmission.domain.ApplicationDetails;
import com.dect.itiAdmission.domain.Gender;
import com.dect.itiAdmission.dtos.ApplicationDetailsDTO;
import com.dect.itiAdmission.repository.ApplicationDetailsRepository;
import com.dect.itiAdmission.repository.GenderRepository;
import com.dect.itiAdmission.service.ApplicationDetailsService;
import com.dect.itiAdmission.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
public class ApplicationDetailsController {

    @Autowired
    private ApplicationDetailsRepository applicationDetailsRepository;

    @Autowired
    private ApplicationDetailsService applicationDetailsService;

    @Autowired
    private CenterService centerService;

    @Autowired
    private GenderRepository genderRepository;

    @GetMapping("/secure/application_no")
    public ApplicationDetails getDetailsByApplicationNo(String id, Model model){
        System.out.println(id);
        ApplicationDetails applicationDetails = applicationDetailsService.applicationDetails(id);
        System.out.println(applicationDetails);
        model.addAttribute("applicationDetails", applicationDetails);
        return applicationDetails;
    }

    @GetMapping("/secure/getApplicationByCenterIdAndTradeId/{centerId}/{tradeId}")
    public List<ApplicationDetails> getApplicationByCenterIdAndTradeId(@PathVariable Integer centerId, @PathVariable Integer tradeId){
//        ApplicationDetails applicationDetails = applicationnumber.applicationDetails(id);
//        System.out.println(applicationDetails);
//        model.addAttribute("applicationDetails", applicationDetails);
        return applicationDetailsService.getApplicationByCenterIdAndTradeId(centerId, tradeId);
    }

//    @PutMapping("/editApplicationDetails")
//    public String editApplicationDetails(@RequestBody ApplicationDetailsDTO applicationDetailsDTO){
//        return applicationDetailsService.editApplicationDetails(applicationDetailsDTO);
//    }

    @PutMapping("/editApplicationDetails")
    public ApplicationDetailsDTO edit(@RequestBody ApplicationDetailsDTO applicationDetailsDTO) {
        ApplicationDetails applicationDetails = applicationDetailsRepository.findById(applicationDetailsDTO.getApplicationnumber()).orElseThrow();
        Gender gender = genderRepository.findById(applicationDetailsDTO.getGender()).orElseThrow();
        applicationDetails.setApplicationnumber(applicationDetailsDTO.getApplicationnumber());
        applicationDetails.setApplicantname(applicationDetailsDTO.getApplicantname());
        applicationDetails.setFathername(applicationDetailsDTO.getFathername());
        applicationDetails.setMothername(applicationDetailsDTO.getMothername());
        applicationDetails.setGender(gender);
        applicationDetails.setDob(applicationDetailsDTO.getDob());
        applicationDetailsRepository.save(applicationDetails);
        return applicationDetailsDTO;
    }
}
