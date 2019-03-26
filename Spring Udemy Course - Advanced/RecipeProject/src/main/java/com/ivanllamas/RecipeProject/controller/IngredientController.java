
package com.ivanllamas.RecipeProject.controller;

import com.ivanllamas.RecipeProject.service.IngredientService;
import com.ivanllamas.RecipeProject.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }
    
    @RequestMapping("/recipe/ingredients/{recipeId}")
    public String listIngredients(@PathVariable String recipeId, Model model){
        
        //returns a RecipeCommand object
        model.addAttribute("recipe", recipeService.findCommandById(new Long(recipeId)));
        
        return "recipe/ingredients/list";
    }
    
    @RequestMapping("/recipe/{recipeId}/ingredients/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId, @PathVariable String id, Model model){
        //returns an ingredient command
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndId(new Long(recipeId), new Long(id)));
        return "recipe/ingredients/show";
    }
    
    
}
