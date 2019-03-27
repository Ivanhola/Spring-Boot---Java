
package com.ivanllamas.RecipeProject.controller;

import com.ivanllamas.RecipeProject.service.ImageService;
import com.ivanllamas.RecipeProject.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

    private final RecipeService recipeService;
    private final ImageService imageService;

    @Autowired
    public ImageController(RecipeService recipeService, ImageService imageService) {
        this.recipeService = recipeService;
        this.imageService = imageService;
    }
    
    /*GET MAPPING TRIGGERED BY THE CHANGE IMAGE BUTTON IN recipe/show.html */
    @RequestMapping("/recipe/image/{id}")
    public String showUplodForm(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(new Long(id)));
        
        return "recipe/imageuploadForm";
    }
    
    /*POST MAPPING TRIGGERED BY THE SUBMIT BUTTON IN recipe/imageuploadForm.html*/
    @PostMapping("/recipe/image/{id}")
    public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file){
        imageService.saveImageFile(new Long(id), file);
        
        //redirecting to the recipe controller show
        return "redirect:/recipe/show/"+id;
    }
    
}
