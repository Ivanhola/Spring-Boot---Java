# This is a cheat sheet for the various different annotations and usage for the Spring Framework.

- __Beans__: These are _Objects_ created in our Spring Container (pretty much just Java objects)

- __BeanScope__: _Singleton_ & _Prototype_, _Singleton_(default scope) creates an instance of a bean and is
saved to memory, all other instances of the bean called are the __SAME BEAN__ (Think boolean test = (Bean==Bean) ) would equal true _Prototype_: Creates an instance of a bean, and is saved to memory, however instances of the same bean __ARE DIFFERENT__ (boolean test = (Bean==Bean) ) would equal false.

- __Bean lifecycle__: When _creating_ a bean, we can add custom code to be performed as well as code being
run when the bean is _destroyed_ __NOTE:__ _Prototype_ beans will not perform a method when being destroyed.

- __@Component("beanId")__: This annotation allows us to create _Spring Beans_ use __@Component__ on a class and it will tell spring to create a bean from that class (Create an object with the name ("beanId"), if no argument is used with __@Component__ it will default to naming the bean the name of the _class__ with a lowercase first letter. Ex: public class StudentName, the bean would be _studentName_)

- __@Autowired__: This annotation is used to _inject dependencies_ to our bean. When using _@AutoWired_ spring will scan for _@Components_ that implement a given interface/class. For example: when using _@AutoWired_ on an interface variable; _@AutoWired_ InterfaceClass interface;
Behind the scenes spring will inject a _@Component_ bean that matches the 'InterfaceClass' into the interface variable.

- __@Qualifier("beanNameThatImplementsIntefaceYouWant")__: If there are multiple _@Components_ that implement a given interface/class that matches when using _@AutoWired_, you can use __@Qualifier__ to manually choose the bean that implements the interface you want exactly.

- __@Value("${foo.name}")__: This annotation allows us to read values from a properties file, and bind these values to a variable in our object. __NOTE:__ If you are  using an xml to store beans, use
<context:property-placeholder location="classpath:sport.properties"/>
if you have a java configuration class, use:
__@PropertySource("classpath:filename.properties")__

- __@Scope("protoype")__: This annotation allows us to add a scope to our bean. _@Scope_ with no arguments defaults to a singleton beanscope.

- __@PostConstruct & @PreDestroy__: These annotations allow us to tell spring to perform custom method code for when the bean is being constructed _@PostConstruct_ or when the bean is being destroyed _@PreDestroy_
(we can name our methods anything we want)

- __@Configuration__: This tells spring that this is a Java Configuration file, and to follow the rules
of a configuration file (aka you will be able to store beans here)

- __@ComponentScan__:  the __@ComponentScan__ Annotation Gives the package that you want spring to start scannning (This is where all our _@Components_ are at in this specific project), it will scan this package, and find all the classes that have _@Component_ and register them in the spring container, instead of using an XML file, we're using a Java class instead.

- __@Bean__: _@Bean_ allows us to manually add beans to our _config class_, instead of scanning with _@Component_ Annotation. Why would we manually input beans instead of automatically scanning for them? Sometimes automatic configuration is not an option. When? Let's imagine that you want to wire components from 3rd-party libraries (you don't have the source code so you can't annotate its classes with _@Component_), so automatic configuration is not possible.

# Spring MVC

- __@RequestMapping("/") || @RequestMapping("/name")__: this annotation allows us to map a _controller_ or a _controller method_ that basically tells spring: when you get to this URL 'www.website.com __/name__ ' do the following; perform whatever method is in the controller method for that mapping (data binding, data reading etc etc)

- __@RequestParam("studentName") String studentName__: this example and annotation will take the parameter "studenName" from an HTML form, and bind it to the String studentName. (We won't really use this much, we'll use model data binding more often)

- __Model__: This is an object that will store data from our _front-end_ and pass it to our _back end controllers_ to view data from a model on another HTML page. We call the model in our controller method in the arguments (Model model). for example: we will need an Object class that will store data
Student student = new Student()
 we will add that class to the model using .addAttribute ( _model.addAttribute("nameOfAttribute", student)_ )
 And in our front end we will be able to bind data to this model by using _"nameOfAttribute"_

 We can then retrieve the data by calling the __@ModelAttribute("nameOfAttribute") Student theStudent__: this calls the attribute we created, and binds it to a _Student_ object. (which we can then use to read data/use getter methods to see what was saved to the objects variables.)

 - __@SpringBootApplication__: does a number of things to facilitate our lives:
_@Configuration_ tags the class as a source of bean definitions for the application context.
_@EnableAutoConfiguration_ tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
Normally you would add _@EnableWebMvc_ for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath.
This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.
_@ComponentScan_ tells Spring to look for other components, configurations, and services in the hello package, allowing it to find the controllers.

# ThymeLeaf

- th:action="@{processForm}" = this is where our form will redirect when the form is submitted

- th:object="${studentObj}" = this is the object for the 'model attribute' we create in our controller, and we can store/read
data by referencing the name of this attribute.

- th:field="****{Country}" this is the path to our variable in our object.

- th:value="Brazil" = this is our value for our variable (our th:field value)

- th:text="Brazil" = this is what we see (aka the label) for our value

- th:each="countries : ${studentObj.countryOptions}" = foreach (countries in Student.countryOptions) we MUST reference the student object when we want to check the map value 'studentObj.countryOptions' refers to the map in our
'studentObj' attribute from our model
