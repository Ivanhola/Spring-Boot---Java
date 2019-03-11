package com.ivanllamas.services;

import com.ivanllamas.entity.Owner;


//this will be the service we use for our Owner entity to perform CRUD operations
public interface OwnerService extends CrudService<Owner,Long> {
   
    
   Owner findByLastName(String lastName); 
   
   /*We don't need these anymore because they are implemented in our CrudService*/
   
   //Owner findById(Long id);
   //Owner save(Owner owner);
   //Set<Owner> findAll();
   
   
   
}
