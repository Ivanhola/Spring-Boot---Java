
package com.ivanllamas.RecipeProject.service;

import com.ivanllamas.RecipeProject.CommandObjects.RecipeCommand;
import com.ivanllamas.RecipeProject.Converters.RecipeCommandToRecipe;
import com.ivanllamas.RecipeProject.Converters.RecipeToRecipeCommand;
import com.ivanllamas.RecipeProject.Exceptions.NotFoundException;
import com.ivanllamas.RecipeProject.model.Recipe;
import com.ivanllamas.RecipeProject.repository.RecipeRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;
    
    //command objects
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }
    
    
    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long l) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(l);
        
        if(recipeOptional.isPresent()){
            return recipeOptional.get();
        }else{
            //response status exception notFOUND
            throw new NotFoundException("Recipe not found");
        }
        
    }

    //pass in a command object, and turn it into a Recipe object.
    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);
        //save the recipe into the database
        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        //return a recipeCommand POJO(this will be used to view things on webpage)
        return recipeToRecipeCommand.convert(savedRecipe);
    }

    //Used to update recipes, returns a recipe command by converting a recipe entity
    @Override
    @Transactional
    public RecipeCommand findCommandById(Long l) {
       return recipeToRecipeCommand.convert(findById(l));
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    

}
