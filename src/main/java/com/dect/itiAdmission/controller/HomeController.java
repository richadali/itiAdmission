package com.dect.itiAdmission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getIndex(){
        return "redirect:/login";
    }
    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }
    @GetMapping("/members")
    public String getMember(){
        return "members";
    }
    @GetMapping("/services")
    public String getService(){
        return "services";
    }

}
