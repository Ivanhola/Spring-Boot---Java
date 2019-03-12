
package com.ivanllamas.services.map;


import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import com.ivanllamas.entity.BaseEntity;

//map service we are sayng T must be of type BaseEntity or extends BaseEntity, as well as our ID must be a Long type
public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

    protected Map<Long,T> map = new HashMap<>();
    
    Set<T> findAll(){
    return new HashSet<>(map.values());
    }
    
    T findById(ID id){
        return map.get(id);
                
    }
    
    T save(T object){
        //if the object is not null
        if (object != null) {

            //we are going to get the current id
            if (object.getId() == null) {
                //and set the ID equal to the next ID for example; 3 -> 4
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else{
            throw new RuntimeException("Object cannot be null");
        }

        
        return object;
    }
    
    void deleteById(ID id){
        map.remove(id);
    }
    
    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    //manage our LONG ID values
    private Long getNextId(){
        Long nextId = null;

        //if our Id is 0 it will throw NoSuchElementException which will make the ID == 1L, and the next
        //this program is run, it will go from 1L and increment
        try{
             nextId = Collections.max(map.keySet()) +  1;
        }catch(NoSuchElementException e){
            nextId = 1L;

        }
       

        return nextId;
        
    }
}
