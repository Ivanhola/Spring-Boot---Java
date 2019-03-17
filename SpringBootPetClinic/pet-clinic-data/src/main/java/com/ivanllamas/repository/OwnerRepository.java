package com.ivanllamas.repository;

import com.ivanllamas.entity.Owner;
import org.springframework.data.repository.CrudRepository;


public interface OwnerRepository extends CrudRepository<Owner, Long>{
    
}
