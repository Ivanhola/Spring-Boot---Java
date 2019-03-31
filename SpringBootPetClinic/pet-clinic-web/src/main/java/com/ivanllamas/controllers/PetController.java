
package com.ivanllamas.controllers;

import com.ivanllamas.entity.Owner;
import com.ivanllamas.entity.Pet;
import com.ivanllamas.entity.PetType;
import com.ivanllamas.services.OwnerService;
import com.ivanllamas.services.PetService;
import com.ivanllamas.services.PetTypeService;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService,PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }
    
    
    /*Whenever we hit controller methods, it will get populated to that model*/
    //whenever we work with the PetController we are always gonna want a pettype and an owner   
    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes(){
        return petTypeService.findAll();
    }
    
    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable String ownerId){
        return ownerService.findById(new Long(ownerId));
    }
    
    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }
    
    
    /*GET MAPPING TO CREATE A NEW PET*/
       @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, Model model) {
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner); 
        model.addAttribute("pet", pet);
        return "/pets/createOrUpdatePetForm";
    }

    /*POST MAPPING HANDLE THE REQUEST FROM ABOVE*/
    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, Model model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.getPets().add(pet); 
        pet.setOwner(owner); //adds the pet to the owner
        
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return "/pets/createOrUpdatePetForm";
        } else {
            petService.save(pet);
            return "redirect:/owners/"+ owner.getId();
        }
    }
    
    /*GET MAPPING TO UPDATE AN EXISTING PET*/
     @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable("petId") Long petId, Model model) {
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);
        return "/pets/createOrUpdatePetForm";
    }

    
    //todo fix detached entity
    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@Valid Pet pet, BindingResult result, Owner owner, Model model) {
  
        if (result.hasErrors()) {
            //pet.setOwner(owner);
            
            model.addAttribute("pet", pet);
            return "/pets/createOrUpdatePetForm";
        } else {
            /*
            owner.getPets().add(pet);*/
            pet.setOwner(owner);
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }

}
