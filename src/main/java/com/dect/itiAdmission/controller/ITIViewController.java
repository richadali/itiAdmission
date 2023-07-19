package com.dect.itiAdmission.controller;
//import com.dect.itiAdmission.repository.DistrictRepository;
//import com.dect.itiAdmission.repository.IVCSRepository;
//import com.dect.itiAdmission.service.IVCSService;
import com.dect.itiAdmission.service.ApplicationDetailsService;
import com.dect.itiAdmission.service.CenterService;
import com.dect.itiAdmission.service.CenterTradeService;
import com.dect.itiAdmission.service.TradesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.Calendar;
//
@Controller()
@Slf4j
public class ITIViewController {
//    @Autowired
//    private IVCSRepository iVCSRepository;
//
//    @Autowired
//    IVCSService ivcsService;
//    @Autowired
//    private DistrictRepository districtRepository;

    @Autowired
    private ApplicationDetailsService applicationDetailsService;

    @Autowired
    private CenterService centerService;

    @Autowired
    private TradesService tradesService;

    @Autowired
    private CenterTradeService centerTradeService;

    @GetMapping("/secure/dashboard")
    public String getDashboard(Model model) {
        model.addAttribute("registeredApplicants",applicationDetailsService.applicationsCount());
        model.addAttribute("itis",centerService.centerCount());
        model.addAttribute("trades",tradesService.tradeCount());

//        model.addAttribute("districtWiseCountIVCS",ivcsService.getDistrictWiseCountIVCS());
//        model.addAttribute("blockWiseCountIVCS",ivcsService.getBLockWiseCountIVCS());
        return "secure/dashboard";
    }
//
//
//    @GetMapping("/secure/registration")
//    public String getIvcsForm(Model model){
//        Calendar calendar  = Calendar.getInstance();
//        calendar.add(Calendar.YEAR, -18);
//
////        IVCSDTO ivcsdto =  new IVCSDTO();
////
////        model.addAttribute("ivcsDTO",ivcsdto);
//
//        model.addAttribute("maxdate",calendar.getTime());
//        return "secure/ivcs_registration";
//    }
    @GetMapping("/secure/registration_list")
    public String getRegisteredApplicants(Model model){

//      model.addAttribute("applicant_list",applicationDetailsService.applicantList());
        model.addAttribute("getCenters", centerService.getCenters());
        System.out.println( centerService.getCenters());
        model.addAttribute("getTrades", tradesService.getTrades());


        return "secure/registration_list";
    }

    @GetMapping("/secure/check_list")
    public String getMeritlist(Model model){
        model.addAttribute("getCenters", centerService.getCenters());
        System.out.println( centerService.getCenters());
        model.addAttribute("getTrades", tradesService.getTrades());
        return "secure/check_list";
    }

    @GetMapping("/secure/add_merit_list")
    public String viewMeritlist(Model model){
        model.addAttribute("getCenters", centerService.getCenters());
        System.out.println( centerService.getCenters());
        model.addAttribute("getTrades", tradesService.getTrades());
        return "secure/add_merit_list";
    }
//
////    @PostMapping("/secure/registration")
////
////    public String saveIVCS(IVCSDTO ivcsdto){
////        log.info("ivcs Dto{}",ivcsdto);
////        System.out.println(ivcsdto.getName());
////        String s = ivcsService.saveIVCS(ivcsdto);
////
////        return "redirect:/secure/ivcs_view";
////    }
//
//
//    @GetMapping("/secure/ivcs-data-entry")
//    public String getIVCSDataEntry(Model model){
////        IVCSDataEntryDTO ivcsDataEntryDTO = new IVCSDataEntryDTO();
////        model.addAttribute("ivcsDataEntryDTO",ivcsDataEntryDTO);
////        model.addAttribute("ivcsList",ivcsService.getAllIVCS());
//
//        return "secure/ivcs-data-entry";
//    }
//
//    @GetMapping("/secure/ivcs-profile")
//    public String getIVCSProfile(){
//
//        return "secure/ivcs-profile";
//    }
//
////    @PostMapping("/secure/ivcs-data-entry")
////    public String saveIvcsDataEntry(IVCSDataEntryDTO ivcsDataEntryDTO){
////        ivcsService.saveIvcsDataEntry(ivcsDataEntryDTO);
////
////        return "redirect:/secure/ivcs-data-reported";
////    }
//
//    @GetMapping("/secure/getIvcs{serialNumber}")
//    public String getByIVCSByName(@PathVariable("serialNumber") String serialNumber,Model model){
////        IVCS ivcs =  ivcsService.getByIVCSSerialNumber(serialNumber);
//
////        model.addAttribute("ivcs",ivcs);
//
////        IVCSDataEntryDTO ivcsDataEntryDTO = new IVCSDataEntryDTO();
////        model.addAttribute("ivcsDataEntryDTO",ivcsDataEntryDTO);
//
//        return "/redirect/ivcs-data-entry";
//    }
//
//    @GetMapping("/secure/ivcs-data-view/{id}")
//    public String viewIvcsDataEntry(@PathVariable("id") Long id,Model model){
////        MasterDataEntryRecord masterDataEntryRecord = ivcsService.finById(id);
////        model.addAttribute("data",masterDataEntryRecord);
////        model.addAttribute("name",
////                villageOperatedInRepository.getIvcsNameFromVillageId(masterDataEntryRecord.getVillages().getId()));
////        System.out.println(ivcsService.finById(id));
//        return "secure/ivcs-data-view";
//    }
//
//    @GetMapping("/secure/ivcs-data-reported")
//    public String getIvcsDataEntry(Model model){
////        model.addAttribute("reports",ivcsService.getIVCSDataEntry());
//        return "secure/ivcs-data-reported";
//    }
}
