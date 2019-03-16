package com.ivanllamas.RecipeProject.repository;

import com.ivanllamas.RecipeProject.model.Category;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author beandog
 */
public interface CategoryRepository extends CrudRepository<Category, Long>{
    //custom query method, looks for variables 'description' in our Category entity
    Optional<Category> findByDescription(String description);
}
