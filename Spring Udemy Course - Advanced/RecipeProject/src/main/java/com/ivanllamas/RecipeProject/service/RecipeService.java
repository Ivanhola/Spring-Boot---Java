package com.ivanllamas.RecipeProject.service;

import com.ivanllamas.RecipeProject.model.Recipe;
import java.util.Set;

/**
 *
 * @author beandog
 */
public interface RecipeService {
  
    Set<Recipe> getRecipes();
    
    Recipe findById(Long l);
    
}
