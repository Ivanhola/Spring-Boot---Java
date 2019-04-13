
package com.ivanllamas.MovieList.Controller;

import com.ivanllamas.MovieList.Entities.Movie;
import com.ivanllamas.MovieList.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    
    
    @RequestMapping("/form")
    public String movieForm(Model model){
    
        Movie movie = new Movie();
        model.addAttribute("movie",movie);
        return "MovieForm";
    }
    
    @PostMapping("/movie")
    public String processMovieForm(@ModelAttribute("movie") Movie movie){
        movieService.save(movie);
        return "redirect:/";
    }
    
    @RequestMapping("/mylist")
    public String showList(Model model){
        model.addAttribute("movielist", movieService.getMovies());
        return "movieList";
    }
}
