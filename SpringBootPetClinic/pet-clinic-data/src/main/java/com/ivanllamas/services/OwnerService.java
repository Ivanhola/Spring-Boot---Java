package com.ivanllamas.services;

import com.ivanllamas.entity.Owner;
import java.util.List;


//this will be the service we use for our Owner entity to perform CRUD operations
public interface OwnerService extends CrudService<Owner,Long> {
   
    
   Owner findByLastName(String lastName); 
   
   List<Owner> findAllByLastNameLike(String lastName);
   
   
   
}
