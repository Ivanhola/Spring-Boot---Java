package com.ivanllamas.services.springdatajpa;

import com.ivanllamas.entity.Owner;
import com.ivanllamas.repository.OwnerRepository;
import com.ivanllamas.repository.PetRepository;
import com.ivanllamas.repository.PetTypeRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
public class OwnerSDJpaServiceTest {
    
     @Mock
     OwnerRepository ownerRepository;
     
     @Mock
     PetRepository petRepository;
     
     @Mock
     PetTypeRepository petTypeRepository;

     
     //works like autowired to inject the repos into the service
     @InjectMocks
     OwnerSDJpaService service;
    
     Owner returnOwner;

    @BeforeEach
    public void setUp() {
        //before each test, create an object with id of 1 and lastname Smith
        returnOwner = new Owner();
        returnOwner.setId(1L);
        returnOwner.setLastName("Smith");
    }

    @Test
    public void FindByLastName() {
        
        
        //when findByLastName is called, return the owner object
        Mockito.when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        
        Owner smith = service.findByLastName("Smith");
        
        Assertions.assertEquals("Smith", smith.getLastName());
        
        verify(ownerRepository).findByLastName(any());        
    }

    @Test
    public void FindAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        
        Owner owner1 = new Owner();
        owner1.setId(1L);
        Owner owner2 = new Owner();
        owner2.setId(2L);
        
        returnOwnersSet.add(owner1);
        returnOwnersSet.add(owner2);
        
        //returns a set when findAll() is called
        Mockito.when(ownerRepository.findAll()).thenReturn(returnOwnersSet);
        
        //sets 2 owner objects into the set ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        Set<Owner> owners = service.findAll();
        
        Assertions.assertNotNull(owners);
        Assertions.assertEquals(2, owners.size());
        
        
        
    }
    

    @Test
    public void FindById() {
        //when the findById is called, return an optional value of returnOwner object we creted
        Mockito.when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        
        Owner owner = service.findById(1L);
        
        Assertions.assertNotNull(owner);
        
    }
    
    @Test
    public void FindByIdNotFound() {
        
        
        Mockito.when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        
        Owner owner = service.findById(1L);
        
        Assertions.assertNull(owner);
        
    }

    @Test
    public void Save() {

        Owner ownerToSave = new Owner();
        ownerToSave.setId(1L);
        
        Mockito.when(ownerRepository.save(any())).thenReturn(ownerToSave);
        
        Owner savedOwner = service.save(ownerToSave);
        
        Assertions.assertNotNull(savedOwner);
        
        //verify that the ownerRepository.save() method was called
        verify(ownerRepository).save(any());
    }

    @Test
    public void Delete() {

        service.delete(returnOwner);
        
        //verify that the ownerRepository.delete() method is called 1 times
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    public void DeleteById() {
        
        service.deleteById(1L);
        
        verify(ownerRepository).deleteById(anyLong());

    }
    
}
