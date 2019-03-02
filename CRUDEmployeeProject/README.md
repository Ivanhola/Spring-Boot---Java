# CRUD Spring Boot project with Database Integration


### This project will make use of Spring Boot, Spring Data JPA, and Thymeleaf.

This program is a simple demo, that allows us to create Employee Objects, and store them in our database performing CRUD functionality.
We display the list of employees using __HTML__ + __Thymeleaf__ in our front-end, and process __CRUD__ functions in the backend using Spring Data JPA.

#

#### This project is composed of 4 Packages under src/main/java
- [__Service__](src/main/java/com/ivanllamas/ThymeleafDemo/Service) - This contains the class needed to perform database operations on __Employee__ Objects

- [__Controller__](src/main/java/com/ivanllamas/ThymeleafDemo/controller) - This is our __Employee__ Controller, this takes care of URL Mappings for our __Employee__ Objects

- [__Entity__](src/main/java/com/ivanllamas/ThymeleafDemo/entity) - This package contains __Entitiy__ classes, these are objects that are mapped to our Database Table, and maps the variables to fit the columns in our Database
- [__Repository__](src/main/java/com/ivanllamas/ThymeleafDemo/repository) - This is our Repository, that contains the Spring Data __JpaRepository__ that allows us to perform CRUD Operations to our database

#### Our HTML/Thymeleaf Pages

- [index page](src/main/resources/static/index.html) - Our Index.html page, redirects the user to localhost:8080/__employees/list__

- [Main page, list of employees](src/main/resources/templates/employees/employee-list.html) - This is our 'Main' page, that contains a List of Employees from our Database

- [Add Employee Page](src/main/resources/templates/employees/addEmployeeForm.html) - This is our HTML page that contains a form for __Adding/Updating__ Employee objects to our Database



#
Here you will find some documentation outlining the program, and each line or segment of code works in this given program.

### Repository Package
[EmployeeRepository.java](src/main/java/com/ivanllamas/ThymeleafDemo/repository/EmployeeRepository.java)
*Thanks to Spring Data JPA, we can use an interface * __JpaRepository__ or __CrudRepository__ *to interact and perform CRUD operations to our database. In this simple class, we make use of Spring Data JPA by extending JpaRepository, and passing in an __Employee__ object, and the __id variable type__*

```Java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    //Custom method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
    
}
```
This simple class, gives us access to all CRUD methods in [The Spring Data Jpa](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html)




#

### Service Package






   [EmployeeServiceImplement.java](src/main/java/com/ivanllamas/ThymeleafDemo/Service/EmployeeServiceImplement.java)   

*We must create a variable that takes in our JPA Repository interface, and we will inject that interface and it's methods into this service class by using __Constructor Injection__, By calling the* __AutoWired__ *Annotation, spring will __Inject__ a __Bean__ into the parameters of the Constructor (in this case an existing __EmployeeRepository__ bean), which allows us to make use of the functions and methods from the bean, by setting the* __employeeRepo__ * variable equal to the injected bean*
```Java


   private EmployeeRepository employeeRepo;
    
   
    @Autowired
    public EmployeeServiceImplement(EmployeeRepository employeeRepository){
        this.employeeRepo= employeeRepository;
    }
```

*Thanks to Spring Data JPA, we can make use of* __JpaRepository__ *and this interface contains basic __CRUD__ methods, we are allowed to access the method thanks to the injection we did, and by using* __employeeRepo__ *we can make a call to those methods.*

```Java
  public List<Employee> findsAll() {
    return employeeRepo.findAll();
    }
```

__Here__
```Java
findsAll()
```
Is the name of the method that we will call when we use this __service class__.

__Whereas here__
```Java
employeeRepo.findAll();
 ```
 Is the name of the method from the __JpaRepository__ interface we got.
 
 The other methods are the same concept, and are methods retrieved from __JpaRepository__ to peform different [CRUD Methods](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html)
 
 
 





 
