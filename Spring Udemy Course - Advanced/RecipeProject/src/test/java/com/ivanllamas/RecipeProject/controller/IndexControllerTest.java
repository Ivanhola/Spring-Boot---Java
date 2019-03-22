package com.ivanllamas.RecipeProject.controller;

import com.ivanllamas.RecipeProject.model.Recipe;
import com.ivanllamas.RecipeProject.service.RecipeService;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.mockito.ArgumentCaptor;

import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;



public class IndexControllerTest {
    
    @Mock
    RecipeService recipeService;
     
    @Mock
    Model model;
    
    IndexController controller;
    
    @Autowired
    private MockMvc mockMvc;
    
    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        
        controller = new IndexController(recipeService);
    }

    
    @Test
    public void MockMVC(){
        
        
        /* this doesnt work for some reason
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

        */
    }
    
    @Test
    public void testMainPage() throws Exception{
        //GIVEN
      Set<Recipe> recipes= new HashSet<>();
      recipes.add(new Recipe());
      
      //create a new object with a different id since we have hashcode in our Recipe class and sets don't allow duplicate
      Recipe recipe = new Recipe();
      recipe.setId(1L);
      
      recipes.add(recipe);
        
        
      Mockito.when(recipeService.getRecipes()).thenReturn(recipes);
      
      ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
       
      //when         
      String viewName = controller.mainPage(model);
      
      
      //make sure it returns "index"
      assertEquals("index",viewName);     
      verify(recipeService, times(1)).getRecipes();
      
      //verify that the .addAttribute has a 'recipes' string name, and has a set (making sure its a Set)
      verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
      
      
      //This assures that the Set<Recipe> is returning a Set of Recipes, and not a Set of Strings/anything else
      Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }
    
}
