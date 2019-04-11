package com.ivanllamas.MovieList.Repository;

import com.ivanllamas.MovieList.Entities.Movie;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author beandog
 */
public interface MovieRepository extends CrudRepository<Movie, Long>{
    
}
