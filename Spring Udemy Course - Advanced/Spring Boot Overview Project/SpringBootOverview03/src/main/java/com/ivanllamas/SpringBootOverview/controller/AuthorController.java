
package com.ivanllamas.SpringBootOverview.controller;

//controller for our Author Objects

import com.ivanllamas.SpringBootOverview.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    //repo to access our Authors in the database
    private AuthorRepository authorRepo;
    
    @Autowired
    public AuthorController(AuthorRepository ar){
        this.authorRepo = ar;
        
    }
    
    //get a list of authors at localhost:8080/authors
    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors",authorRepo.findAll());
        return "author-list";
    }
}
