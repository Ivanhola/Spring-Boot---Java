
package com.ivanllamas.MovieList.Controller;

import com.ivanllamas.MovieList.Entities.Movie;
import com.ivanllamas.MovieList.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String movieForm(Model model, Model listModel){
    
        Movie movie = new Movie();
        model.addAttribute("movie",movie);
        listModel.addAttribute("movielist", movieService.getMovies());
        
        return "MovieForm";
    }
    
    @PostMapping("/movie")
    public String processMovieForm(@ModelAttribute("movie") Movie movie){
        movieService.save(movie);
        return "redirect:/movie/form";
    }
    
    @RequestMapping("/update/{id}")
    public String updateMovie(@PathVariable Long id, Model model, Model listModel){
        model.addAttribute("movie", movieService.findById(id));
        listModel.addAttribute("movielist", movieService.getMovies());
        return "MovieForm";
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id){
        movieService.deleteById(id);
        return "redirect:/movie/form";
    }

}
