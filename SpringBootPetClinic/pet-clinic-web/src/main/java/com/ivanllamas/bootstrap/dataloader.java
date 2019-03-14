package com.ivanllamas.bootstrap;

import java.time.LocalDate;

import com.ivanllamas.entity.Owner;
import com.ivanllamas.entity.Pet;
import com.ivanllamas.entity.PetType;
import com.ivanllamas.entity.Vet;
import com.ivanllamas.services.OwnerService;
import com.ivanllamas.services.PetTypeService;
import com.ivanllamas.services.VetService;
import com.ivanllamas.services.map.OwnerServiceMap;
import com.ivanllamas.services.map.VetServiceMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//used to initialize data

@Component 
public class dataloader implements CommandLineRunner {

    //get some services
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    //Depenceny injection to inject our services
    @Autowired
    public dataloader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }



    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Benidorm Cir");
        owner1.setCity("Corona");
        owner1.setTelephone("9515123122");
        //adding dogs to our owner
        Pet mikesPet = new Pet();
        //setting the pet to a dog
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setName("Spike");
        mikesPet.setBirthDate(LocalDate.now());
      
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
 
        owner2.setFirstName("Fiora");
        owner2.setLastName("France");
        owner2.setAddress("Meridian Dr 123");
        owner2.setCity("Hemet");
        owner2.setTelephone("9512321222");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner2);
        fionasPet.setName("Whiskers");
        fionasPet.setBirthDate(LocalDate.now());

        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        System.out.println("loaded owners . . .");

        Vet vet1 = new Vet();
        //vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("IAM");

        vetService.save(vet1);


        Vet vet2 = new Vet();
        //vet2.setId(2L);
        vet2.setFirstName("Angela");
        vet2.setLastName("Yu");

        vetService.save(vet2);

        System.out.println("Saving vets . . .");



        
    }

    

    
}