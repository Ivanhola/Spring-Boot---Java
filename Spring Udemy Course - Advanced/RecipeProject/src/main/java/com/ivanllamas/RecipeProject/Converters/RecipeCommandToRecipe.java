
package com.ivanllamas.RecipeProject.Converters;

import com.ivanllamas.RecipeProject.CommandObjects.RecipeCommand;
import com.ivanllamas.RecipeProject.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe>{

    private final CategoryCommandToCategory categoryConverter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommandToNotes notesConverter;

    @Autowired
    public RecipeCommandToRecipe(CategoryCommandToCategory categoryConverter, IngredientCommandToIngredient ingredientConverter, NotesCommandToNotes notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }
    
    
    
    
    
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
       if(source == null){
           return null;
    }
       final Recipe recipe = new Recipe();
       recipe.setId(source.getId());
       recipe.setCookTime(source.getCookTime());
       recipe.setPrepTime(source.getPrepTime());
       recipe.setDescription(source.getDescription());
       recipe.setDifficulty(source.getDifficulty());
       recipe.setDirections(source.getDirections());
       recipe.setServings(source.getServings());
       recipe.setSource(source.getSource());
       recipe.setUrl(source.getUrl());
       recipe.setNotes(notesConverter.convert(source.getNotes()));
      
       //if the set of categories isnt null, iterate through, and add a category object for each object in the set.
       if(source.getCategories() != null && source.getCategories().size() > 0){
           source.getCategories().forEach( category -> recipe.getCategories().add(categoryConverter.convert(category)));
       }
       
       if(source.getIngredients() != null && source.getIngredients().size() > 0){
           source.getIngredients().forEach(ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
           
           
       }
       
       return recipe;
       
    }
    
    
}
