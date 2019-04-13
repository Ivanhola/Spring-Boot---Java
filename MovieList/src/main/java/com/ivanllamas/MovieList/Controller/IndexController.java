
package com.ivanllamas.MovieList.Controller;

import com.ivanllamas.MovieList.Entities.Movie;
import com.ivanllamas.MovieList.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {


    
    @RequestMapping({"/", "/home", "/index"})
    public String mainMenu(){

        
        return "main-menu";
    }
}
