# CRUD Spring Boot project with Database Integration


### This project will make use of Spring Boot, Spring Data JPA, and Thymeleaf.

This program is a simple demo, that allows us to create Employee Objects, and store them in our database performing CRUD functionality.
We display the list of employees using __HTML__ + __Thymeleaf__ in our front-end, and process __CRUD__ functions in the backend using Spring Data JPA.

#

### MySQL Script
```SQL
CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

```

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

__Here__ `findsAll()`
Is the name of the method that we will call when we use this __service class__.

__Whereas here__ ` employeeRepo.findAll();`
 
 Is the name of the method from the __JpaRepository__ interface we got.
 
 The other methods are the same concept, and are methods retrieved from __JpaRepository__ to peform different [CRUD Methods](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html)
 
 #
 
 ### Entity Package
[Employee.java](src/main/java/com/ivanllamas/ThymeleafDemo/entity/Employee.java)

In this class, we specify that the objects are an __Entity__, meaning that using __Hibernate ORM__, we can specify that The object will be mapped to a __Table__, and the Objects variables will be mapped to the __Columns__ in that table.

In this class we have an __Employee__ entity, that will be mapped to our `employee` table in our database

```
//structure of the entity class

Java Object  -----> Database
===================================

Employee     -----> employee (database table name)
-------------------------------
id (@Id)     -----> id (primary key)
firstName    -----> first_name
lastName     -----> last_name
email        -----> email


```

Note: We have the annotation ` @GeneratedValue(strategy=GenerationType.IDENTITY) ` which tells spring that the database will be an ID primary key of AUTO-INCREMENT.

We simply map our Object to the database by using Spring Annotation

```Java
@Entity
@Table(name="employee")
public class Employee {

    
    //variables mapped to --> database
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="email")
    private String email;
```
*We MUST create a __default Constructor__ to be able to create objects, and save them to the database in the controller*
```Java
 public Employee(){
        
    }
```

*We create a constructor that doesn't take in an Id, because the id will be auto incremented. (__although i believe this method is never really used since in the controller/thymeleaf, it adds values to an object's variables like firstName, lastName by using getters/setters not by constructor, this is incase we want to manually add an object to our database__)*
```Java
  public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
 ```
 
 #
 
 ### Controller Package
 [EmployeeController.java](src/main/java/com/ivanllamas/ThymeleafDemo/controller/EmployeeController.java)
 
In this class, we implement all of our Previous classes/Employee related classes, to create, read, update, delete objects to our database, this is our __Controller__ for our __Employeee__ objects. In this class we will display our backend Employee data, to our front end using __Mappings__ and __Thymeleaf__ to read, and display the object data from our database into a web-browser.  

*We start off by specifying and mapping the __controller__ URL to __/employees__, so to access this controller in a URL, you would have to enter something like localhost:8080 __/employees__*
```Java
@Controller
@RequestMapping("/employees")
public class EmployeeController {

 // your code here. . . .
 
    }
```

*We then create an variable of type* __EmployeeServiceImplement__ *and inject the [__bean we created__](src/main/java/com/ivanllamas/ThymeleafDemo/Service/EmployeeServiceImplement.java) *into the constructor of the controller, so we have access to the methods from our service class*

```Java
 private EmployeeServiceImplement employeeService;  
  
  //injecting our EmployeeServiceImplement class into the constructor
  @Autowired
  public EmployeeController(EmployeeServiceImplement theEmployeeService){
      this.employeeService = theEmployeeService;
  }
```

### GET Mapping for "/list"

```Java
 @GetMapping("/list")
    public String employeeList(Model model){
    
        //create a list of Employee objects, and populate the list with the list returned in employeeService.findsAll()
        List<Employee> theEmployees = employeeService.findsAll();
        
        //we take that data and add to the spring model, so thymeleaf can read this data
        model.addAttribute("employees", theEmployees);
        
        
        //will look under the folder employees in our templates folder then look for employee-list.html
        return "employees/employee-list";
    }
```
When we go to localhost:8080 __/employees/list__ it will call this *GET* Controller, which adds an __'employees'__ attribute to our model (which is of type :a list of EmployeeObjects) which is then passed on to our __Thymeleaf Template__ *[employee-list.html](src/main/resources/templates/employees/employee-list.html)*

The model is used in this segment of code in our HTML Page

```HTML
<tr th:each="tempEmployee : ${employees}">
                    <td th:text="${tempEmployee.firstName}"/>
                    <td th:text="${tempEmployee.lastName}"/>
                    <td th:text="${tempEmployee.email}"/>
</tr>
```

We can see that there is a _foreach_ loop, where we read from the attribute `${employees}` (our model attribute that we passed in)
and we assign the values from the (model attribute) __list__ to a temporary Employee Object `tempEmployee`. We then can access the _variables_ from the Employee object, and output the values from 'firstName','lastName','email'.

### GET Mapping for "/addEmployerForm"

```Java
   @GetMapping("/addEmployeeForm")
    public String addEmployeeForm(Model model){
        
        //create an Employee object that the model attribute can use to bind form data
        Employee employee = new Employee();
        
        //adding an attribute to our model called 'employee' of type Employee (object)
        model.addAttribute("employee", employee);
        
        return "employees/addEmployeeForm";
    }
```

When the user is sent to URL localhost:8080 __/employees/addEmployeeForm__, this controller will be called, which adds a _model attribute_ with the name __'employee'__ of type _Employee_. This controller then displays the [addEmployeeForm.html](src/main/resources/templates/employees/addEmployeeForm.html) page.


In our HTML Page we have a form
```HTML

<form action="#" th:action="@{/employees/save}"
                  th:object="${employee}" method="POST">
                
                <input type="text" th:field="*{firstName}" class="form-control mb-4 col-4" placeholder="First name">
                <input type="text" th:field="*{lastName}" class="form-control mb-4 col-4" placeholder="Last name">
                <input type="text" th:field="*{email}" class="form-control mb-4 col-4" placeholder="Email">

                <button type="submit" class="btn btn-info col-2">Save</button>

            </form>
```

__Let's break it down__
```HTML
<form action="#" th:action="@{/employees/save}"
                  th:object="${employee}" method="POST">
```
- _We have a Thymeleaf Form that performs the action `@{/employees/save}`, this is basically the path that the form will go to when the submit button is pressed, it will go to the URL with a __POST__ method to localhost:8080_ __/employees/save__

- the `th:object=${employee}` referes to the __Model__ attribute 'employee' that we passed in from our __addEmployeeForm()__ controller method.

#

```HTML
                <input type="text" th:field="*{firstName}" class="form-control mb-4 col-4" placeholder="First name">
                <input type="text" th:field="*{lastName}" class="form-control mb-4 col-4" placeholder="Last name">
                <input type="text" th:field="*{email}" class="form-control mb-4 col-4" placeholder="Email">
```

This part of the code, is a textfield input, allowing the user to enter a value in the text field, and that value will be saved to the field `th:field=*{firstName}` which in this case, is the variable from the __employee__ attribute which is an __Employee__ object.




```HTML
  <button type="submit" class="btn btn-info col-2">Save</button>
```


Thymeleaf makes use of __Getters and Setters__ so when the form is submitted, it will call the __Setter method__ for each `th:field`, setting the value of each variable equal to the value that the _user put in the textfield_. __This essentially creates values from the 'employee' object. Behind the scenes, it would look something like__

```Java
Employee employee = new Employee();
employee.setFirstName("Ivan");
employee.setLastName("Llamas");
employee.setEmail("ivan@gmail.com");

```

The form calls the __Setter__ method when submitted, as well as `th:action="@{/employees/save}"`

# 

### POST Mapping for "/save"
this mapping is accessed by hitting the submit button, which expands on our last point in our __addEmployeeForm.html__

```Java
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employees") Employee employee){
       
        //save the employee to our database by calling the save() method in the employee service
        employeeService.save(employee);
        
        //use a redirect to prevent users from dublicating submissions
        return "redirect:/employees/list";
    }
 ```
 
 __After the form is submitted__ we will get the _model attribute_ by using the `@ModelAttribute("employee")` and bind the data from the model attribute to `Employee employee`. After that we will simply perform the `.save()` method and save the _object_ data into our database.
 
#

### GET Mapping for "/updateEmployeeForm"

This Controller method is accessed from our list button, notice we create a variable `employeeId` that is set equal to the value from `${tempEmployee.id}`

```HTML
 <a th:href="@{/employees/updateEmployeeForm(employeeId=${tempEmployee.id})}"
                   class="btn btn-info btn-sm">Update</a>
```

Looking at our code:
```Java
 @GetMapping("/updateEmployeeForm")
    public String showFormForUpdate(@RequestParam("employeeId") long id, Model model){
        
        //get the employee by id from our database
        Employee theEmployee = employeeService.findById(id);
        
        //set the employee passed in as a model attribute to pre-populate the form
        model.addAttribute("employee", theEmployee);
        
        return "employees/addEmployeeForm";
    }
```

We simply use __`@RequestParam("employeeId")`__ which gets the value from the variable we created in our HTML page `employeeId` and binds that value to `long id`.

After that, we search for an employee with the id from the value passed in, and create a model from the object we got. Model named `employee`, the `employee` model we passed in has all the values from the __Object__ we got from the database in 

```Java
Employee theEmployee = employeeService.findById(id);
```

By sending the model object to __/addEmployeeForm__

we make use of 

```HTML
<input type="hidden" th:field="*{id}">
```

Which allows us to populate the form fields by id. __Remember, when the form is called, it will call GETTER methods, and when it is submitted it will call SETTER methods. In this case when calling Getter, it will get the values from the model attribute, and populate them onto the fields__

#

### GET Mapping for "/delete"

This Controller method is accessed from our list button, notice we create a variable `employeeId` that is set equal to the value from `${tempEmployee.id}`

```HTML
 <a th:href="@{/employees/delete(employeeId=${tempEmployee.id})}"
                   class="btn btn-info btn-sm">Update</a>
```

Looking at our code:
```Java
 @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") long id){
        
        //delete from our database
        employeeService.deleteById(id);
        
        return "redirect:/employees/list";
        
    }
    
```

As explained before, we request the Param `employeeId` and make a call to the database using `employeeService.deleteById()` method, and using the `id` value passed in from the param we set to each object in the table.

 
 





 
