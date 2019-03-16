package com.ivanllamas.RecipeProject.repository;

import com.ivanllamas.RecipeProject.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author beandog
 */
public interface CategoryRepository extends CrudRepository<Category, Long>{
    
}
