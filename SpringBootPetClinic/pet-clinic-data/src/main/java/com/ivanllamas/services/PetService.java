package com.ivanllamas.services;


import com.ivanllamas.entity.Pet;
import java.util.Set;

//this will be the service we use for our Pet entity to perform CRUD operations
public interface PetService {
   
   Pet findById(Long id);
   Pet save(Pet pet);
   Set<Pet> findAll();
}
