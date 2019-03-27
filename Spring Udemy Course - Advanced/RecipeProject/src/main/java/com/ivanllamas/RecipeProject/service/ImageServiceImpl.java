
package com.ivanllamas.RecipeProject.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService{

    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {
        System.out.println("com.ivanllamas.RecipeProject.service.ImageServiceImpl.saveImageFile()");
    }

}
