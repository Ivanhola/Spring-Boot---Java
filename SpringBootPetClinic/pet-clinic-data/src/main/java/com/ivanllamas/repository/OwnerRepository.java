package com.ivanllamas.repository;

import com.ivanllamas.entity.Owner;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface OwnerRepository extends CrudRepository<Owner, Long>{
    Owner findByLastName(String lastName);
    
    List<Owner> findAllByLastNameLike(String lastName);
}
