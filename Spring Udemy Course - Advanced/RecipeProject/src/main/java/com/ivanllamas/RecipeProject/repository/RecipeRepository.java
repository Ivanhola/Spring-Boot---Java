package com.ivanllamas.RecipeProject.repository;

import com.ivanllamas.RecipeProject.model.Recipe;
import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Recipe, Long>{
    
    
}
