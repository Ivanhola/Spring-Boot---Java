
# This is a Spring-Framework Repo used for saving my projects and concepts from Online Courses.

This is intended as a reference to various different concepts, and core features used in Spring. For further documentation on concepts and features, referring to [the official docs](https://docs.spring.io/spring/docs/5.1.4.RELEASE/spring-framework-reference/) is the best way to learn and understand Spring.




# 
Here you will find a list of projects that contain Demos to core concepts, as well as Documentation within the code that explains the functions of each concept and how it operates:

# 

- [Inversion of Control](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/BaseBallCoachApp-IoC-Example):  The Design process of externalizing, the construction and management of your objects. (Aka app outsourcing the creation and management of the objects, found in resources/applicationContext.xml)

- [Dependency Injection - Constructor Injection ](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/CoachApp-DependencyInjection-Example): The process of injecting dependencies to a bean via the class constructor method. (This uses XML Schema based Configuration File, Legacy but still used)

- [Dependency Injection - Setter Injection ](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/CoachApp-SetterInjection-Example): The process of injection dependencies to a bean via the class setter methods. (This uses XML Schema based Configuration File, Legacy but still used)

- [Injecting Literal Values](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/CoachApp-LiteralValueInject-Example): The process of injecting values to class variables by using a file (a properties file in this case) In this project we have variables Email and teamName, and we can manage their values by configuring it in the sport.properties file. (Must configure the beans in the applicationContext.xml file to accept values from outside files, and name the values by using '${name}' syntax ). Code is specifically modifying the __CricketCoach.java__ class.

- [Beanscope & BeanLifeCylcle](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/CoachApp-beanscope-Example) .. In this program you will find the different scopes in beans that Spring offers: _Singleton_ & _Prototype_ examples. beanscope examples can be found in __"beanscope-applicationContext.xml"__ file, and a demo in '__beanScopeDemo.java__'. _(Singletons will create the same instance of a bean. Prototype will create a different instance, when compared as prototype they will result in a different memory location, aka different object)_

    Bean life cycle examples can be found under __"beanLifeCycle-applicationContext.xml"__ & __"beanLifeCycleDemo.java"__ 
     _(This makes use of the TrackCoach.java class. When creating our bean we can add custom code during initialization of our     code & during the destruction of our bean)_ 
     
- [Spring Annotations - @Component("BeanID")](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/SpringDemo-Annotations): This program is to demonstrate the use of @Component("beanID") with our classes. Using this annotation will enable us to create Spring beans, without using an xml file to manually create beans(although we'll still use an xml file to store beans within compile time to the Spring Container.)

- [Spring Annotations - @Component Default ](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/SpringDemo-ComponentDefault): This program is to demonstrate the use of @Component without any following Arguments, where the ID of the bean will default into the name of the class it is used on, with a lowercase first letter (TestClass --> testClass) the default id of the bean would be "testClass"

- [Spring Annotations - @Autowired (Constructor Injection)](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/SD-ComponentConstructorInjection): This program demonstrates the @Autowired Annotation use, and how you can inject dependencies (Similar to Xml dependency injections) by using Spring Annotation in a class constructor vs Manually inputing them through an xml file. Spring will automatically scan for @Components that match the requirement for dependency injection. for example __Class test = new Class(DependencyClass dependencyClass);__ @Autowired will find a bean that implements __DependencyClass__ and inject it into the constructor.

- [Spring Annotations - @Autowired (Setter Injection)](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/SD-ComponentSetterInjection): This program demonstrates the __@Autowired__ annotation use, by injecting dependencies via _setter methods_.

- [Spring Annotations - @Autowired (Field Injection)](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/SD-ComponentFieldInjection): This program demonstrates the __@Autowired__ annotation use, by injecting dependencies via _Field method_.

- [Spring Annotations - @Qualifier](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/SD-AnnotationQualifierExample): This program demonstrates the usage of __@Qualifier__ Annotation, which answers the question of, What happens when __@Autowired__ finds multiple components that can inject a dependency , when Spring scans and attempts to inject a dependency into a bean?

- [Spring Annotations - @Value (Injecting literal values from a file)](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/SD-AnnotationFileValueInjection): This program demonstrates how to read values from a _properties file_, and inject them onto our class variables by using the __@Value__ annotation. (This allows us to change the value of variables from a config value, instead of hard coding it in the program) 

- [Spring Annotations - @Scope (Defining bean scope using Annotations)](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/SD-AnnotationBeanScope): This program demonstrates the __@Scope__ Annotation, which will define a beans scope when used _(By Default singleton)_

- [Spring Annotations - @PostConstruct & @PreDestroy (Bean Lifecycle)](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/SD-AnnotationBeanLifecycle): This program demonstrates the __@PostConstructor__ and __@PreDestroy__ Annotations, and the usage by adding initialize and destroy methods to our beans to perform during its lifecycle.

- [Spring Configuration - @Configuration & @ComponentScan("packageName")(No XML File used to create a Spring Container for storing beans)](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/SD-ConfigurationNoXML): This program demonstrates the __@Configuration__ and __@ComponentScan()__ usage, and how to configure beans in a Spring Container without the use of an external _XML file_.

- [Spring Configuration - @Bean (Manually adding beans to our config java class)](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/SD-ConfigurationBeansWIthJava): This program demonstrates how to manually add beans to our _SportConfig._java class, by using Java code instead of scanning with __@Component__ Annotation. Why would we manually input beans instead of automatically scanning for them? Sometimes automatic configuration is not an option. __When?__ Let's imagine that you want to wire components from 3rd-party libraries (you don't have the source code so you can't annotate its classes with @Component), so automatic configuration is not possible.

- [Spring Configuration - @PropertySource("classpath:file.name") (Injecting values from a file using Annotation and Java code, no XML file.)](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/SD-ConfiguratioInjectingValuesFile): This program demonstrates how to inject values into variables using the __@PropertySource__ & __@Value__ annotation, added a Change log to further facilitate the changes made for each program from here on out.

- [Spring MVC - Simple Spring app running an HTML using @RequestMapping](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/SpringMVCDemo): This program demonstrates a very basic example of how to use __@RequesMapping__ and map a web page to a method in a @Controller Class (When it hits that controller, it will call the method/redirect to a webpage)

- [Spring MVC - Simple form data page with Thymeleaf](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/SpringMVCDemo-FormData): This program demonstrates a very basic program that will map 2 URLS __/showForm__ & __processForm__ and pass form data from /showForm to /processForm & display it using Thymeleaf parameters.

- [Spring MVC - Adding data to our Model using a controller method](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course/SpringMVCDemo-AddDataToModel): This program demonstrates and example on how to _add_ data from an HTML form to our __Model__,_read & modify_ the data, and display it on our __View__ (read data from our controller and display it to our HTML page).

_These are just demos and concepts, further explanation into these concepts and demonstrations are further documented in google docs Notes that I have organized and taken._
