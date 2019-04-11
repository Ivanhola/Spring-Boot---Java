
package com.ivanllamas.MovieList.Controller;

import com.ivanllamas.MovieList.Entities.Movie;
import com.ivanllamas.MovieList.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    private final MovieService movieService;

    @Autowired
    public IndexController(MovieService movieService) {
        this.movieService = movieService;
    }
    
    @RequestMapping({"/", "/home", "/index"})
    public String mainMenu(){
        //Making sure we can save data into the database correctly TEMPORARY DELETE
        Movie movie = new Movie("AOT", "Movie based on the anime");
        movieService.save(movie);
        
        return "main-menu";
    }
}
