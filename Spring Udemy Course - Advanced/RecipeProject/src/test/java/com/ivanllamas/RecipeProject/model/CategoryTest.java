package com.ivanllamas.RecipeProject.model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class CategoryTest {
    
   
    Category category;
    
    //Create a new category object before each test is executed
    @Before
    public void setUp(){
        category = new Category();
    }

    
    @Test
    public void GetId() throws Exception{
        //creating a Long value
        Long idValue = 4L;
        
        //setting a Long value
        category.setId(idValue);
        
        //expected value     actual value
        assertEquals(idValue, category.getId());
    }



    @Test
    public void GetDescription() throws Exception{

    }


 
    @Test
    public void GetRecipes() throws Exception {

    }


    
}
