package com.ivanllamas.RecipeProject.repository;

import com.ivanllamas.RecipeProject.model.UnitOfMeasure;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


//spring Integration test with Spring runner allows us to pull up the Spring Context, and access things from our main program.
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {
    
    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;
    
    @Before
    public void setUp() throws Exception{
    
    }

    //testing the UnitOfMeasureRepository to find by Description
    @Test
    public void testFindByDescription() throws Exception{
        //look at our Data.sql for UnitOfMeasures found in the database
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        
        assertEquals("Teaspoon", uomOptional.get().getDescription());
    }
    
        @Test
    public void testFindByDescriptionCup() throws Exception{
        //look at our Data.sql for UnitOfMeasures found in the database
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
        
        assertEquals("Cup", uomOptional.get().getDescription());
    }


    
}
