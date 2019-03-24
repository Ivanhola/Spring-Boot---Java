package com.ivanllamas.controllers;



import com.ivanllamas.entity.Owner;
import com.ivanllamas.services.OwnerService;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * LCTURE 193 NOT FINISHED, GET METHOD WONT WORK
 */

@ExtendWith(MockitoExtension.class)
public class OwnerControllerTest {
    @Mock
    OwnerService ownerService;
    
    //injects service like auto wired
    @InjectMocks
    OwnerController controller;
    
    Set<Owner> owners;
    
    MockMvc mockMvc;
    
    @BeforeEach
    public void setUp() {
        owners = new HashSet<>();
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owners.add(owner1);
        
        Owner owner2 = new Owner();
        owner2.setId(2L);
        owners.add(owner2);
        
        //sets up controllers for testing MVC controllers
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testOwnersMain() {
        //when findAll() is called, return our set
        
        /*
        Mockito.when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get()).andExpect(status().is(200));
        
        GET METHOD NOT WORKING!!*/
        
        
    }
    
    @Test
    public void testFindOwners(){
        
    }
    
}
