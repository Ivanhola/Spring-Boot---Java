# #ChangeLog from our [Previous Project](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/Spring%20Boot%20Overview%20Project/SpringBootOverview)

### Overview
- Added __equals(), hashCode(), And toString()__ methods on our _Entity_ Classes
- Added a __Repository__ package that contains __CrudRepository__ for both of our entity classes
- Added a __BootStrap__ package that contains an __initData()__ method to populate starting data into our database

# 

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

Added a [Spring Data JPA repository](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/Spring%20Boot%20Overview%20Project/SpringBootOverview02/src/main/java/com/ivanllamas/SpringBootOverview/repository) class that allows us to make use of the JPA __CRUD__ Methods from the __CrudRepository__ interface

```Java

public interface AuthorRepository extends CrudRepository<Author,Long> {
    
}

```


Added a __[BootStrap](https://github.com/Ivanhola/Spring-Framework-Course-Learning/blob/master/Spring%20Udemy%20Course%20-%20Advanced/Spring%20Boot%20Overview%20Project/SpringBootOverview02/src/main/java/com/ivanllamas/SpringBootOverview/bootstrap/DevBootStrap.java)__ class that will allow us to make use of __@Component, @Autowired, ApplicationListener__

```Java
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
```
