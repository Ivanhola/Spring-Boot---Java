package com.ivanllamas.RecipeProject.controller;

import com.ivanllamas.RecipeProject.model.Category;
import com.ivanllamas.RecipeProject.model.UnitOfMeasure;
import com.ivanllamas.RecipeProject.repository.CategoryRepository;
import com.ivanllamas.RecipeProject.repository.UnitOfMeasureRepository;
import com.ivanllamas.RecipeProject.service.RecipeService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    private final RecipeService recipeService;

    //this will inject our RecipeServiceImpl
    @Autowired
    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    
    
    

    
    @RequestMapping({"", "/", "/index"})
    public String mainPage(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());

        
        return "index";
    }


    
}