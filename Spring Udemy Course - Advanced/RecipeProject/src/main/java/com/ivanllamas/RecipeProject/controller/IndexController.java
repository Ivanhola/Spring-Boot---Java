package com.ivanllamas.RecipeProject.controller;

import com.ivanllamas.RecipeProject.model.Category;
import com.ivanllamas.RecipeProject.model.UnitOfMeasure;
import com.ivanllamas.RecipeProject.repository.CategoryRepository;
import com.ivanllamas.RecipeProject.repository.UnitOfMeasureRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    //repos to call methods to get data from our database
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    
    @Autowired
    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }
    
    @RequestMapping({"", "/", "/index"})
    public String mainPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        
        System.out.println("Category ID is: " + categoryOptional.get().getId());
        System.out.println("Unit Of Measure Object ID is: " + unitOfMeasureOptional.get().getId());
        
        return "index";
    }


    
}