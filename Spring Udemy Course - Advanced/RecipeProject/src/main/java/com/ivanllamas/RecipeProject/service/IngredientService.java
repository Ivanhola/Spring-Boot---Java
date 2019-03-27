package com.ivanllamas.RecipeProject.service;

import com.ivanllamas.RecipeProject.CommandObjects.IngredientCommand;


public interface IngredientService {
    IngredientCommand findByRecipeIdAndId(Long l, Long id);
    
    IngredientCommand saveIngredientCommand(IngredientCommand command);
    
    void deleteById(Long recipeId, Long ingredientId);
}
