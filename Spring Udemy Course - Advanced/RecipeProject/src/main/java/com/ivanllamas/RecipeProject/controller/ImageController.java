
package com.ivanllamas.RecipeProject.controller;

import com.ivanllamas.RecipeProject.CommandObjects.RecipeCommand;
import com.ivanllamas.RecipeProject.service.ImageService;
import com.ivanllamas.RecipeProject.service.RecipeService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
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
    
    /*POST MAPPING TO SHOW THE IMAGE FROM THE DATABASE TO THE VIEW*/
    /*for future reference, we can just upload an image to an image hoster, and include the url instead of all this byte*/
    @RequestMapping("/recipe/recipeimage/{id}")
    public void rengerImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException{
        RecipeCommand recipeCommand = recipeService.findCommandById(new Long(id));
        
        if (recipeCommand.getImage() != null) {
        byte[] byteArray = new byte[recipeCommand.getImage().length];
        int i=0;
        
        for(Byte wrappedByte : recipeCommand.getImage()){
            byteArray[i++] = wrappedByte;
        }
        
        response.setContentType("image/jpeg");
        InputStream is = new ByteArrayInputStream(byteArray);
        //copy from the input stream to the response
        IOUtils.copy(is, response.getOutputStream());
        }
    }
}
