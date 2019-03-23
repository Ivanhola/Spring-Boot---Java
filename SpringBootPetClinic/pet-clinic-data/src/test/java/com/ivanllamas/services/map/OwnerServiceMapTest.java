package com.ivanllamas.services.map;

import com.ivanllamas.entity.Owner;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class OwnerServiceMapTest {
    
    OwnerServiceMap ownerServiceMap;

    //id value
    private final Long  id= 1L;
    
    private String lastName = "Smith";
    
    @BeforeEach
    public void setUp() {
        //this is how our class is setup in the OwnerServiceMap, Not using SpringData because its using a regular HashMap
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
        //create an owner Object
        Owner owner = new Owner();
        owner.setId(id);
        owner.setLastName(lastName);
        //Save the Owner Object
        ownerServiceMap.save(owner);
    }

    @Test
    public void testFindAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        
        Assertions.assertEquals(1, ownerSet.size());
    }

    @Test
    public void testFindById() {
        Owner owner = ownerServiceMap.findById(id);
        
        Assertions.assertEquals(id, owner.getId());
        

    }

    @Test
    public void testSaveExistingID() {
        Long newId = 2L;
        //create new Owner object with id of 2L
        Owner owner2 = new Owner();
        owner2.setId(newId);
        
        
        //return the new Owner with the updated Id value
        Owner savedOwner = ownerServiceMap.save(owner2);
        

        Assertions.assertEquals(newId, savedOwner.getId());
    }
    
    @Test
    public void saveNoId(){
        
        //check the ID of our current object
        Owner owner1 = ownerServiceMap.findById(id);
        System.out.println("Owner id is : " + owner1.getId());
        
        
        
        /*IMPORTANT: The ID initially comes in at 1, but it turns into 2 after running the save Method, due to our
        implementation of AbstractMapService, and how the save method has a getNextId() method, which increases the id value by 1*/
        Owner isEmpty = new Owner();
        Owner savedOwner = ownerServiceMap.save(isEmpty);
        
        //checking if it will save the new Owner object without an id (it will not)
        Assertions.assertNotNull(isEmpty);
        Assertions.assertNotNull(savedOwner.getId());
        
        System.out.println("Owner Id is " +savedOwner.getId());
        System.out.println("Owner Set size is " + ownerServiceMap.findAll().size());
        
        
    }

    @Test
    public void testDelete() {
        //deleting by the object
        ownerServiceMap.delete(ownerServiceMap.findById(id));
        //expected to have no objects in our ServiceMap since we deleted it
        Assertions.assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    public void testDeleteById() {
        ownerServiceMap.deleteById(id);
        Assertions.assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    public void testFindByLastName() {
        Owner smith = ownerServiceMap.findByLastName(lastName);
        
        Assertions.assertNotNull(smith);
        
        Assertions.assertEquals(id,smith.getId());

    }
    
    @Test
    public void testFindByLastNameNotFOUND() {
        //should return null because there is no objects with lastname foo
        Owner smith = ownerServiceMap.findByLastName("foo");
        
        Assertions.assertNull(smith);
        


    }
    
}
