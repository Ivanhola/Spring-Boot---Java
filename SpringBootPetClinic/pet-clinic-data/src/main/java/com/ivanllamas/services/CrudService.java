
package com.ivanllamas.services;

import java.util.Set;
//creating a Java Generics class
//common methods for our services, takes in a type and an ID

//taking common methods from the CRUD Repository
public interface CrudService<T,ID> {

    Set<T> findAll();
    
    T findById(ID id);
    
    T save(T object);
    
    void delete(T object);
    
    void deleteById(ID id);
    
}
