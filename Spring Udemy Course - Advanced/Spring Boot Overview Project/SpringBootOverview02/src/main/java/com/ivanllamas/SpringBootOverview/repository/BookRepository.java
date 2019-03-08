package com.ivanllamas.SpringBootOverview.repository;

import com.ivanllamas.SpringBootOverview.entity.Book;
import org.springframework.data.repository.CrudRepository;


/*Repository to provide CRUD Operations for Book entity in our Database*/
public interface BookRepository extends CrudRepository<Book, Long> {
    
}
