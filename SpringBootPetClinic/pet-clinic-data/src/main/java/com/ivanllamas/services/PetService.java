package com.ivanllamas.services;


import com.ivanllamas.entity.Pet;


//this will be the service we use for our Pet entity to perform CRUD operations
public interface PetService extends CrudService<Pet,Long> {
   
    /*We don't need these anymore, they are implemented in our CrudService*/
   
    //Pet findById(Long id);
    //Pet save(Pet pet);
    //Set<Pet> findAll();
}
