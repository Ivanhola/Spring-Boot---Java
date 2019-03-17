package com.ivanllamas.repository;

import com.ivanllamas.entity.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author beandog
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long>{
    
}
