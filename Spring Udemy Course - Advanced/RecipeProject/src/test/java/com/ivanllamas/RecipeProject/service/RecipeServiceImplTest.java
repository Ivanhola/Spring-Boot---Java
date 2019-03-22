package com.ivanllamas.RecipeProject.service;

import com.ivanllamas.RecipeProject.model.Recipe;
import com.ivanllamas.RecipeProject.repository.RecipeRepository;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;


public class RecipeServiceImplTest {
    
   RecipeServiceImpl recipeService;
   
   @Mock
   RecipeRepository recipeRepository;
   
   @Before
   public void setUp() throws Exception{
       //give me a Mock of a RecipeRepository
        MockitoAnnotations.initMocks(this);
        
        //how it would be injected by spring
        recipeService = new RecipeServiceImpl(recipeRepository);
   }

    @Test
    public void testGetRecipes() throws Exception{
        //create a recipe object
        Recipe recipe = new Recipe();
        
        //create a hashset
        HashSet recipesData = new HashSet();
        //add object to hashset
        recipesData.add(recipe);
        
        //when recipeRepository findAll() method is called, return the hashset (1 recipe object)
        //the getRecipes() method calls .findAll() which returns a HASHSET
        when(recipeRepository.findAll()).thenReturn(recipesData);
        
        Set<Recipe> recipes = recipeService.getRecipes();
        
        //          expected        actual
        assertEquals(1, recipes.size());
        
        //make sure the method find all was called only 1 TIMES
        verify(recipeRepository, times(1)).findAll();

    }
    
}
