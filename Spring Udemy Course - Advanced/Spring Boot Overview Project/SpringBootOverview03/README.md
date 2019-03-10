# Project Overview

#### Technologies: 
- H2 Database
- Spring Framework
- Spring Data JPA
- Hibernate
- Thymeleaf
- Restful Webservice

## Packages

- __[entity](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/Spring%20Boot%20Overview%20Project/SpringBootOverview03/src/main/java/com/ivanllamas/SpringBootOverview/entity)__
- __[repository](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/Spring%20Boot%20Overview%20Project/SpringBootOverview03/src/main/java/com/ivanllamas/SpringBootOverview/repository)__
- __[controller](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/Spring%20Boot%20Overview%20Project/SpringBootOverview03/src/main/java/com/ivanllamas/SpringBootOverview/controller)__
- __[bootstrap](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/Spring%20Boot%20Overview%20Project/SpringBootOverview03/src/main/java/com/ivanllamas/SpringBootOverview/bootstrap)__



## Entity Package

This packages houses our Entity classes. These are Java objects that are _mapped_ to our database by using __Object Relational Mapping (ORM)__, each Entity is mapped to a _table_ in our database, and the variables from the entity classes are then mapped to the _columns_ in the table.

Heres an example of an Entity that can be found in this project. Since this project is using H2 database, we don't necessarily have to specify the `@Columns` for each variable to map them with the columns in a database since this entity will create the table __and__ the columns for us by using `@Entity` and adding a primary key with `Id`

```Java
@Entity
public class Book {
    
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

   
    
private String title;
private String isbn;

// This annotation adds a relationship to the Book Table, where Publisher ID is matched to the Book (Check database)
@OneToOne
private Publisher publisher;

@ManyToMany
@JoinTable(name="author_books", joinColumns = @JoinColumn(name="book_id"), inverseJoinColumns= @JoinColumn(name="author_id"))
private Set<Author> authors = new HashSet<>();


public Book(){
    
}

    public Book(String title, String isbn, Publisher publisher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }
    
    public Book(String title, String isbn, Publisher publisher, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
    }
```
__The class also contains getters and setters for our variables__


It is good practice in hibernate to make sure that our Objects don't replicate with each other, to do so we create a hashCode to make sure that
if the IDs equal, they are the same object, and if they aren't well. . .they aren't the same object.
```Java

 @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Author other = (Author) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", books=" + books + '}';
    }

```
#


## Repository Package
[Spring Data JPA repository](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/Spring%20Boot%20Overview%20Project/SpringBootOverview02/src/main/java/com/ivanllamas/SpringBootOverview/repository) class that allows us to make use of the JPA __CRUD__ Methods from the __CrudRepository__ interface


```Java

public interface AuthorRepository extends CrudRepository<Author,Long> {
    
}

```
This repository class is crucial to accessing CRUD methods, and saving Objects of __<ObjectType,PrimaryKeyType>__

# 


## BootStrap Package

This package is used to initialize data into our database. We make use of `implements ApplicationListener<ContextRefreshedEvent>` to call everything in this class whenever the program is run.




__[BootStrap](https://github.com/Ivanhola/Spring-Framework-Course-Learning/blob/master/Spring%20Udemy%20Course%20-%20Advanced/Spring%20Boot%20Overview%20Project/SpringBootOverview02/src/main/java/com/ivanllamas/SpringBootOverview/bootstrap/DevBootStrap.java)__  We simply make use of our Repository interface classes to access our database with CRUD methods and inject them via Constructor Dependency. And create Entity objects, and store them into our database.
```Java
@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{

    
    private AuthorRepository AuthorService;
    private BookRepository BookService;
    private PublisherRepository PublisherService;

    //Dependency injection into the constructor.
    @Autowired
    public DevBootStrap(AuthorRepository AuthorService, BookRepository BookService, PublisherRepository PublisherService) {
        this.AuthorService = AuthorService;
        this.BookService = BookService;
        this.PublisherService = PublisherService;
    }
    
     private void initData(){
        
        

        Publisher publisher2 = new Publisher();
        publisher2.setName("Worx");
        
        PublisherService.save(publisher2);
        
        Author rod = new Author("Rod", "Jhonson");
        Book noJE8 = new Book("J2EE Development without J2EE", "23152", publisher2);
        rod.getBooks().add(noJE8);
        
        AuthorService.save(rod);
        BookService.save(noJE8);
        
    }
    
```
# 

## Controller Package

Lets take a look at one of our controllers
```Java
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
```
This simple class gets a list of __Author__ objects (_entity_) and sends the list to the attribute `authors` in our model, where we can then read the data in thymeleaf
```html
            <tr th:each="author : ${authors}">
                <td th:text="${author.id}">Spring IN Action</td>
                <td th:text="${author.firstName}">123</td>
                <td th:text="${author.lastName}">Spring IN Action</td>
                
            </tr>
```
