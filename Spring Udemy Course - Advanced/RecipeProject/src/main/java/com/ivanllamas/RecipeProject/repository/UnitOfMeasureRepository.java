package com.ivanllamas.RecipeProject.repository;

import com.ivanllamas.RecipeProject.model.UnitOfMeasure;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author beandog
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{
    //custom query method looks for variable 'description' in our UnitOfMeasure entity
    Optional<UnitOfMeasure> findByDescription(String description);
}
