package com.dect.itiAdmission.controller;

import com.dect.itiAdmission.service.ApplicationDetailsService;
import com.dect.itiAdmission.service.CenterService;
import com.dect.itiAdmission.service.CenterTradeService;
import com.dect.itiAdmission.service.TradesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
@Slf4j
public class ITIViewController {

    @Autowired
    private ApplicationDetailsService applicationDetailsService;

    @Autowired
    private CenterService centerService;

    @Autowired
    private TradesService tradesService;

    @Autowired
    private CenterTradeService centerTradeService;

    @GetMapping("secure/dashboard")
    public String getDashboard(Model model) {
        model.addAttribute("registeredApplicants", applicationDetailsService.applicationsCount());
        model.addAttribute("itis", centerService.centerCount());
        model.addAttribute("trades", tradesService.tradeCount());
        return "secure/dashboard";
    }

    @GetMapping("secure/registration_list")
    public String getRegisteredApplicants(Model model) {
        model.addAttribute("getCenters", centerService.getCenters());
        System.out.println(centerService.getCenters());
        model.addAttribute("getTrades", tradesService.getTrades());


        return "secure/registration_list";
    }

    @GetMapping("secure/check_list")
    public String getMeritlist(Model model) {
        model.addAttribute("getCenters", centerService.getCenters());
        model.addAttribute("getTrades", tradesService.getTrades());
        return "secure/check_list";
    }

    @GetMapping("secure/add_merit_list")
    public String addToMeritlist(Model model) {
        model.addAttribute("getCenters", centerService.getCenters());
        model.addAttribute("getTrades", tradesService.getTrades());
        return "secure/add_merit_list";
    }

    @GetMapping("secure/view_merit_list")
    public String viewMeritlist(Model model) {
        model.addAttribute("getCenters", centerService.getCenters());
        model.addAttribute("getTrades", tradesService.getTrades());
        return "secure/view_merit_list";
    }

    @GetMapping("secure/view_waiting_list")
    public String viewWaitinglist(Model model) {
        model.addAttribute("getCenters", centerService.getCenters());
        model.addAttribute("getTrades", tradesService.getTrades());
        return "secure/view_waiting_list";
    }

    @GetMapping("secure/remove_from_merit_list")
    public String removeWaitinglist(Model model) {
        model.addAttribute("getCenters", centerService.getCenters());
        model.addAttribute("getTrades", tradesService.getTrades());
        return "secure/remove_from_merit_list";
    }
}
