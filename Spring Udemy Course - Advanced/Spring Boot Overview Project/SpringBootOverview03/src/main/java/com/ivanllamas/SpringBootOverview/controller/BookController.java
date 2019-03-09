
package com.ivanllamas.SpringBootOverview.controller;

import com.ivanllamas.SpringBootOverview.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//controller class for BOOK object

@Controller
public class BookController {

    private BookRepository bookRepo;
    
    //INJECTING THE BOOKREPO INTO THE CONSTRUCTOR
    @Autowired
    public BookController(BookRepository br){
        this.bookRepo = br;
    }
    
   @RequestMapping("/books")
   public String getBooks(Model model){
       
       //add 'books' attribute of type Iterable to our model. we can access the model in a Thymeleaf template by using 'books'
       model.addAttribute("books", bookRepo.findAll());
       
     return "book-list";  
   }
   
   

}
