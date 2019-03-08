
package com.ivanllamas.SpringBootOverview.bootstrap;

import com.ivanllamas.SpringBootOverview.entity.Author;
import com.ivanllamas.SpringBootOverview.entity.Book;
import com.ivanllamas.SpringBootOverview.repository.AuthorRepository;
import com.ivanllamas.SpringBootOverview.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/*This class will be used to initialize data into our in memory H2 database, this way we have some data into our database
to work with*/

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{

    
    private AuthorRepository AuthorService;
    private BookRepository BookService;

    //Dependency injection into the constructor.
    @Autowired
    public DevBootStrap(AuthorRepository AuthorService, BookRepository BookService) {
        this.AuthorService = AuthorService;
        this.BookService = BookService;
    }
    
    
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        //call our method to initialize data
       initData();
    }

    private void initData(){
        
        
        //First author
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        //adding to our set. This adds books to Eric and assigns a book object to the set (ddd)
        eric.getBooks().add(ddd);
        //adding to our set. This adds Authors to the book and assigns an author (eric)
        ddd.getAuthors().add(eric);
        
        //save the Author and Book into our database
        AuthorService.save(eric);
        BookService.save(ddd);
        
        /***************************************************************************************/
        
        //Second author
        Author rod = new Author("Rod", "Jhonson");
        Book noJE8 = new Book("J2EE Development without J2EE", "23152", "Worx");
        rod.getBooks().add(noJE8);
        
        AuthorService.save(rod);
        BookService.save(noJE8);
        
    }
}
