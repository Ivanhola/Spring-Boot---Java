
package com.ivanllamas.controllers;

import com.ivanllamas.entity.Owner;
import com.ivanllamas.services.OwnerService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
    
    /*HTTP variables come in, and Spring binds it to an object, used for handling Form POSTS
    We don't want to allow webForms to address, and modify id properties of objects, cant modify id
    in theory, someone can create an HTTP form post, and send a request using the id value to change something*/
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    
    /*GET MAPPING FOR OUR INDEX PAGE
    @RequestMapping({"","/","/index","/index.html"})
    public String ownersMain(Model model){
        //returns a set that we can iterate in our thymeleaf template
        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }
    */
    
    /*GET MAPPING TO FIND AN OWNER BY LAST NAME, sends form to /owners method below*/
    @RequestMapping("/find")
    public String findOwners(Model model){
        Owner owner = new Owner();
        model.addAttribute("owner", owner);
        return "owners/findOwners";
    }
    
    /*When the form is submitted it sends to defaulted /owners and calls this controller*/
    @RequestMapping
    public String processFindForm(Owner owner, BindingResult result,Model model){
        
        if(owner.getLastName() == null){
            owner.setLastName(""); //empty string signifies a possible search
        }
        
        //find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike(owner.getLastName());
        if(results.isEmpty()){
            // no owners with last name found
            result.rejectValue("lastName", "NotFound","NotFound");
            return "/owners/findOwners";
        }else if(results.size() == 1){
            //1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        }else{
            //multiple owners found
            model.addAttribute("selections", results);
            return "/owners/ownerList";
        }
        
       
    }
    
    
    
    /*GET MAPPING TO DISPLAY AN INDIVIDUAL OWNER, returns ownerDetails.html*/
    @RequestMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId){
        //the return html view
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        
        //returns the object type/object to work with in the thymeleaf model
        mav.addObject(this.ownerService.findById(ownerId));
        
        return mav;
    }
}

