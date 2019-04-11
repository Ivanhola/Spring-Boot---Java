package com.ivanllamas.MovieList.Service;

import com.ivanllamas.MovieList.Entities.Movie;
import java.util.List;


public interface MovieService {
    List<Movie> getMovies();
    Movie findById(Long id);
    void deleteById(Long id);
    void deleteAll();
    void save(Movie movie);
}
