
package com.ivanllamas.controllers;

import com.ivanllamas.services.OwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    //OwnerService to interact with our Service
    private final OwnerService ownerService;

    //dependency injection, injects an OwnerService bean
    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    

    @RequestMapping({"/owners","/owners/index","/owners/index.html"})
    public String ownersMain(Model model){
        //returns a set that we can iterate in our thymeleaf template
        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }
}

