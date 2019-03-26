
package com.ivanllamas.RecipeProject.service;

import com.ivanllamas.RecipeProject.CommandObjects.IngredientCommand;
import com.ivanllamas.RecipeProject.Converters.IngredientToIngredientCommand;
import com.ivanllamas.RecipeProject.model.Recipe;
import com.ivanllamas.RecipeProject.repository.RecipeRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService{

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    @Autowired
    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }
    
    
    
    
    @Override
    public IngredientCommand findByRecipeIdAndId(Long recipeId, Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        
        if(!recipeOptional.isPresent()){
            throw new RuntimeException("Recipe not found");
        }
        
        Recipe recipe = recipeOptional.get();
        
        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(id))
                .map( ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();
        
                if(!ingredientCommandOptional.isPresent()){
            //todo impl error handling
            throw new RuntimeException("Ingredient not found");
        }

         return ingredientCommandOptional.get();
    }

}
