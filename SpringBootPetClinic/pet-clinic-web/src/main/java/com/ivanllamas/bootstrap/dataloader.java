package com.ivanllamas.bootstrap;

import com.ivanllamas.entity.Owner;
import com.ivanllamas.entity.Vet;
import com.ivanllamas.services.OwnerService;
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


    //Depenceny injection to inject our services
    @Autowired
    public dataloader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }



    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        //owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        //owner2.setId(2L);
        owner2.setFirstName("Fiora");
        owner2.setLastName("France");

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