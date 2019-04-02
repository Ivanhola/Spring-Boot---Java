
package com.ivanllamas.RecipeProject.controller;

import com.ivanllamas.RecipeProject.CommandObjects.RecipeCommand;
import com.ivanllamas.RecipeProject.Exceptions.NotFoundException;
import com.ivanllamas.RecipeProject.service.RecipeService;
import static java.lang.StrictMath.log;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    /*GET MAPPING TO DISPLAY A SINGLE RECIPE ITEM AND ALL ITS CONTENTS*/
    //when a variable is passed in the URL, it will return a view with the Recipe object
    //with that id from our database.
    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model){
        
        model.addAttribute("recipe", recipeService.findById(new Long(id)));
        
        return "recipe/show";
        
    }
    
    /*GET MAPPING TO DISPLAY THE FORM/CREATE A NEW RECIPE*/
    @RequestMapping("/recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        
        return "recipe/recipeForm";
    }
    
    /*GET MAPPING TO UPDATE AN EXISTING RECIPE, BY PASSING THE ID IN*/
    @RequestMapping("/recipe/update/{id}")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(new Long(id)));
        
        return "recipe/recipeForm";
    }
    
    /*GET MAPPING TO DELETE AN EXISTING RECIPE OBJECT*/
    @RequestMapping("/recipe/delete/{id}")
    public String deleteRecipe(@PathVariable String id){
        recipeService.deleteById(new Long(id));
        
        return "redirect:/";
    }
    
    /*POST MAPPING TO SAVE THE FORM DATA IN OUR UPDATE/CREATE*/
    
    @PostMapping("recipe")
    public String saveOrUpdate(@Valid @ModelAttribute("recipe") RecipeCommand recipeCommand, BindingResult bindingResult){
        
        //if validation doesnt pass, return to the form
        if(bindingResult.hasErrors()){
            
            bindingResult.getAllErrors().forEach(objectError -> {
                System.err.println(objectError.toString());
            });
            return "recipe/recipeForm";
        }
        
        //save the command to the database
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(recipeCommand);
        
        return "redirect:/recipe/show/" + savedCommand.getId();
    }
    
    
    /*EXCEPTION HANDLING*/
    
    //NOT FOUND 404 ERROR
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception){

        System.err.println("Handling Not Found Exception");
        System.err.println(exception.getMessage());


         ModelAndView modelAndView = new ModelAndView();

         modelAndView.setViewName("404Error");
         //adding model attr to 404 error.html
         modelAndView.addObject("exception", exception);

         return modelAndView;
    }
    

}
