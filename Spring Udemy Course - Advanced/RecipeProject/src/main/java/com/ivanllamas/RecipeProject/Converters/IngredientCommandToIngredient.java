
package com.ivanllamas.RecipeProject.Converters;

import com.ivanllamas.RecipeProject.CommandObjects.IngredientCommand;
import com.ivanllamas.RecipeProject.model.Ingredient;
import com.ivanllamas.RecipeProject.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient>{

    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    /*Ingredient Has a UoM Object, so we need a UoM converter to use the convert method, and return a UoM entity*/
    @Autowired
    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }
    
    
    
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
         if(source == null){
             return null;
         }
         
         final Ingredient ingredient = new Ingredient();
         ingredient.setId(source.getId());
         ingredient.setAmount(source.getAmount());
         if(source.getRecipeId() != null){
            Recipe recipe = new Recipe();
            recipe.setId(source.getRecipeId());
            ingredient.setRecipe(recipe);
            recipe.addIngredient(ingredient);
        }
         ingredient.setDescription(source.getDescription());
         //returns a UnitOfMeasureCommand object, and converts it into a UnitOfMeasure entity with Convert() method
         ingredient.setUom(uomConverter.convert(source.getUnitOfMeasureCommand()));
         
         return ingredient;
         
        }

}
