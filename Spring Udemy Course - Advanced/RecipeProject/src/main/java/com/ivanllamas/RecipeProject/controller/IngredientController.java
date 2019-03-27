
package com.ivanllamas.RecipeProject.controller;

import com.ivanllamas.RecipeProject.CommandObjects.IngredientCommand;
import com.ivanllamas.RecipeProject.CommandObjects.RecipeCommand;
import com.ivanllamas.RecipeProject.CommandObjects.UnitOfMeasureCommand;
import com.ivanllamas.RecipeProject.service.IngredientService;
import com.ivanllamas.RecipeProject.service.RecipeService;
import com.ivanllamas.RecipeProject.service.UnitOfMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    @Autowired
    public IngredientController(RecipeService recipeService, IngredientService ingredientService,UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }
    
    /*GET MAPPING TO SHOW THE LIST OF INGREDIENTS IN A RECIPE*/
    @RequestMapping("/recipe/ingredients/{recipeId}")
    public String listIngredients(@PathVariable String recipeId, Model model){
        
        //returns a RecipeCommand object
        model.addAttribute("recipe", recipeService.findCommandById(new Long(recipeId)));
        
        return "recipe/ingredients/list";
    }
    
    /*GET MAPPING TO CREATE A NEW INGREDIENT/RECIPE*/
    @RequestMapping("/recipe/ingredients/new/{recipeId}")
    public String newRecipe(@PathVariable String recipeId, Model model){
        //recipe command by id
        RecipeCommand recipeCommand = recipeService.findCommandById(new Long(recipeId));
        
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setRecipeId(new Long(recipeId));
        model.addAttribute("ingredient", ingredientCommand);
        
        ingredientCommand.setUnitOfMeasureCommand(new UnitOfMeasureCommand());
        
        model.addAttribute("unitOfMeasureCommandList", unitOfMeasureService.listAllUoms());
        
        return "recipe/ingredients/ingredientForm";
    }
    
    /*GET MAPPING TO SHOW THE INDIVIDUAL INGREDIENT ITEM */
    //when this mapping is requested, it will display an individual ingredient based on the ID of the recipe/ingredient
    @RequestMapping("/recipe/{recipeId}/ingredients/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId, @PathVariable String id, Model model){
        //returns an ingredient command
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndId(new Long(recipeId), new Long(id)));
        return "recipe/ingredients/show";
    }
    
    /*GET MAPPING TO UPDATE AN INDIVIDUAL UNIT OF MEASURE IN OUR INGREDIENT RETURNS FORM*/
    @RequestMapping("/recipe/{recipeId}/ingredients/{id}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId,@PathVariable String id, Model model){
        //returns an ingredient command
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndId(new Long(recipeId), new Long(id)));
        
        model.addAttribute("unitOfMeasureCommandList", unitOfMeasureService.listAllUoms());
        
        return "recipe/ingredients/ingredientForm";
        
    }
    
    /*POST MAPPING TO ACCEPT OUR FORM DATA*/
    @PostMapping("/recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand commandPassedIn){
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(commandPassedIn);
        //redirects to /recipe/{recipeId}/ingredients/{ingredientId}/show which is the individual ingredient item
        return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredients/" + savedCommand.getId() + "/show/";
    }
    
    
}
