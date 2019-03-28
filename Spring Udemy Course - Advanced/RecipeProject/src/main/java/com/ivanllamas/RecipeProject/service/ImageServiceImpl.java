
package com.ivanllamas.RecipeProject.service;

import com.ivanllamas.RecipeProject.model.Recipe;
import com.ivanllamas.RecipeProject.repository.RecipeRepository;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService{

    private final RecipeRepository recipeRepository;

    @Autowired
    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    
    @Override
    @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) {
        System.out.println("com.ivanllamas.RecipeProject.service.ImageServiceImpl.saveImageFile()");
        
        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();
            
            Byte[] byteObjects = new Byte[file.getBytes().length];
            
            int i = 0;
            
            for(byte b : file.getBytes()){
                byteObjects[i++] = b;
            }
            
            recipe.setImage(byteObjects);
            
            
            recipeRepository.save(recipe);
            
        } catch (IOException e) {
            System.err.println("Error Occurred" + e);
            
            e.printStackTrace();
        }
    }

}
