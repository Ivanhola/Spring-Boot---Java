
package com.ivanllamas.RecipeProject.service;

import com.ivanllamas.RecipeProject.CommandObjects.IngredientCommand;
import com.ivanllamas.RecipeProject.Converters.IngredientCommandToIngredient;
import com.ivanllamas.RecipeProject.Converters.IngredientToIngredientCommand;
import com.ivanllamas.RecipeProject.model.Ingredient;
import com.ivanllamas.RecipeProject.model.Recipe;
import com.ivanllamas.RecipeProject.repository.RecipeRepository;
import com.ivanllamas.RecipeProject.repository.UnitOfMeasureRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IngredientServiceImpl implements IngredientService{

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository,IngredientCommandToIngredient ingredientCommandToIngredient,UnitOfMeasureRepository unitOfMeasureRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }
    
    
    
    //returns a single ingredient object
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

    //TODO break this down
    @Override
    @Transactional
    public IngredientCommand saveIngredientCommand(IngredientCommand command) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(command.getRecipeId());

         if(!recipeOptional.isPresent()){

             //todo toss error if not found!
             System.err.println("Recipe not found");
            return new IngredientCommand();
        } else {
            Recipe recipe = recipeOptional.get();

             Optional<Ingredient> ingredientOptional = recipe
                    .getIngredients()
                    .stream()
                    .filter(ingredient -> ingredient.getId().equals(command.getId()))
                    .findFirst();

             if(ingredientOptional.isPresent()){
                Ingredient ingredientFound = ingredientOptional.get();
                ingredientFound.setDescription(command.getDescription());
                ingredientFound.setAmount(command.getAmount());
                ingredientFound.setUom(unitOfMeasureRepository
                        .findById(command.getUnitOfMeasureCommand().getId())
                        .orElseThrow(() -> new RuntimeException("UOM NOT FOUND"))); //todo address this
            } else {
                //add new Ingredient
                Ingredient ingredient = ingredientCommandToIngredient.convert(command);
                ingredient.setRecipe(recipe);
                recipe.addIngredient(ingredientCommandToIngredient.convert(command));
            }

             Recipe savedRecipe = recipeRepository.save(recipe);

            Optional<Ingredient> savedIngredientOptional = savedRecipe.getIngredients().stream()
            .filter(recipeIngredients -> recipeIngredients.getId().equals(command.getId())).findFirst();
  
                if(!savedIngredientOptional.isPresent()){
                //not totally safe... But best guess
                savedIngredientOptional = savedRecipe.getIngredients().stream()
                        .filter(recipeIngredients -> recipeIngredients.getDescription().equals(command.getDescription()))
                        .filter(recipeIngredients -> recipeIngredients.getAmount().equals(command.getAmount()))
                        .filter(recipeIngredients -> recipeIngredients.getUom().getId().equals(command.getUnitOfMeasureCommand().getId()))
                        .findFirst();
            }

             //to do check for fail
            return ingredientToIngredientCommand.convert(savedIngredientOptional.get());
            
    
        }

     }

}
