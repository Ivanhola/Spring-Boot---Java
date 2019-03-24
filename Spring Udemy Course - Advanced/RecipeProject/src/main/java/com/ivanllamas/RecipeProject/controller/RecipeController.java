
package com.ivanllamas.RecipeProject.controller;

import com.ivanllamas.RecipeProject.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    
    //when a variable is passed in the URL, it will return a view with the Recipe object
    //with that id from our database.
    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model){
        
        model.addAttribute("recipe", recipeService.findById(new Long(id)));
        
        return "recipe/show";
        
    }
    
}
