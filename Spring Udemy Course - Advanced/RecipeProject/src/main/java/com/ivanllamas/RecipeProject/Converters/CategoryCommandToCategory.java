
package com.ivanllamas.RecipeProject.Converters;

import com.ivanllamas.RecipeProject.CommandObjects.CategoryCommand;
import com.ivanllamas.RecipeProject.model.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category>{

    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
       if(source == null){
           return null;
       }
       
       //creating Category object entity and getting values from Command
       final Category category = new Category();
       category.setId(source.getId());
       category.setDescription(source.getDescription());
       return category;
    }

    
}
