
package com.ivanllamas.controllers;

import com.ivanllamas.entity.Vet;
import com.ivanllamas.services.VetService;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VetController {

    private VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }
    

    @RequestMapping({"/vets","/vets/index","/vets/index.html"})
    public String vetMainPage(Model model){
        //returns a set of vets
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
    
    //returns a JSON format
    @RequestMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetsJson(){
        
        return vetService.findAll();
    }
    
}
