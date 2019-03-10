package com.ivanllamas.services;

import com.ivanllamas.entity.Owner;
import java.util.Set;

//this will be the service we use for our Owner entity to perform CRUD operations
public interface OwnerService {
   
    
   Owner findByLastName(String lastName); 
   Owner findById(Long id);
   Owner save(Owner owner);
   Set<Owner> findAll();
   
   
   
}
