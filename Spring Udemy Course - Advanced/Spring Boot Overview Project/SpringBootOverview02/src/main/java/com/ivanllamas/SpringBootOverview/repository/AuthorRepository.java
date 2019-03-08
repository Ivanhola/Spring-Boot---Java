package com.ivanllamas.SpringBootOverview.repository;

import com.ivanllamas.SpringBootOverview.entity.Author;
import org.springframework.data.repository.CrudRepository;



/*Repository to provide CRUD methods for an Author Object*/
public interface AuthorRepository extends CrudRepository<Author,Long> {
    
}
