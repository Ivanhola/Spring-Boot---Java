package com.ivanllamas.services;

import com.ivanllamas.entity.Vet;


//this will be the service we use for our Vet entity to perform CRUD operations
public interface VetService extends CrudService<Vet, Long>{
   
   /*We don't need these anymore, they are implemented in our CrudService*/
   
   //Vet findById(Long id);
   //Vet save(Vet vet);
   //Set<Vet> findAll();
}
