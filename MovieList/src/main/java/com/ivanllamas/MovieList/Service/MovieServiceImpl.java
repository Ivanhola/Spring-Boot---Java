
package com.ivanllamas.MovieList.Service;

import com.ivanllamas.MovieList.Entities.Movie;
import com.ivanllamas.MovieList.Repository.MovieRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{
    
    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    
    

    @Override
    public List<Movie> getMovies() {
        //returns list of movies from the database
        return (List<Movie>) movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        
        if(movieOptional.isPresent()){
            //returns a Movie object from the optional
            return movieOptional.get();
        }else{
            throw new RuntimeException("Movie not found" + id);
        }
        
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        movieRepository.deleteAll();
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }
    
    

}
