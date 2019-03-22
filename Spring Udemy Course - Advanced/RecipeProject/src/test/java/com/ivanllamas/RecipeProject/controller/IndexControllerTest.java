package com.ivanllamas.RecipeProject.controller;

import com.ivanllamas.RecipeProject.service.RecipeService;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

/**
 *
 * @author beandog
 */
public class IndexControllerTest {
    
    @Mock
    RecipeService recipeService;
     
    @Mock
    Model model;
    
    IndexController controller;
    
    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        
        controller = new IndexController(recipeService);
    }

    @Test
    public void testMainPage() throws Exception{
      String viewName = controller.mainPage(model);
      //return value
      assertEquals("index",viewName);
      //verify that the .getRecipes() method is called 1 time
      verify(recipeService, times(1)).getRecipes();
      //verify that the .addAttribute has a 'recipes' string name, and has a set (any type of set)
      verify(model,times(1)).addAttribute(eq("recipes"),anySet());
    }
    
}
