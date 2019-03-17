package com.ivanllamas.repository;

import com.ivanllamas.entity.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author beandog
 */
public interface PetRepository extends CrudRepository<Pet, Long>{
    
}
