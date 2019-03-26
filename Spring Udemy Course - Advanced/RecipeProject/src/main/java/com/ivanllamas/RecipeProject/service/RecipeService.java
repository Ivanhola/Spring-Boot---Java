package com.ivanllamas.RecipeProject.service;

import com.ivanllamas.RecipeProject.CommandObjects.RecipeCommand;
import com.ivanllamas.RecipeProject.model.Recipe;
import java.util.Set;

/**
 *
 * @author beandog
 */
public interface RecipeService {
  
    Set<Recipe> getRecipes();
    
    Recipe findById(Long l);
    
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    
    RecipeCommand findCommandById(Long l);
    
    void deleteById(Long id);
}
