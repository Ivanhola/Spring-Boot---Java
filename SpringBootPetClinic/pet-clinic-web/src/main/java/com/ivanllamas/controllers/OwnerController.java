
package com.ivanllamas.controllers;

import com.ivanllamas.services.OwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    //OwnerService to interact with our Service
    private final OwnerService ownerService;

    //dependency injection, injects an OwnerService bean
    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    

    @RequestMapping({"","/","/index","/index.html"})
    public String ownersMain(Model model){
        //returns a set that we can iterate in our thymeleaf template
        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }
    
    @RequestMapping("/find")
    public String findOwners(){
        return "error";
    }
    
    /*GET MAPPING TO DISPLAY AN INDIVIDUAL OWNER, RETURNS OWNERDETAILS.HTML*/
    @RequestMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId){
        //the return html view
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        
        //returns the object type/object to work with in the thymeleaf model
        mav.addObject(this.ownerService.findById(ownerId));
        
        return mav;
    }
}

