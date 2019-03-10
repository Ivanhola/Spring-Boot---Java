# Spring Boot Joke application

This program is a simple demonstration of how you can use Maven dependencies to add JAR files to your project, and use Classes that the JAR files provide.

This project mainly focuses on the use of __Dependency Injection__ in order to inject a service from an interface, and use the service to output a joke.

[JokeService.java](https://github.com/Ivanhola/Spring-Framework-Course-Learning/blob/master/Spring%20Udemy%20Course%20-%20Advanced/Joke%20application/src/main/java/com/ivanllamas/Joke/application/service/JokeService.java) this is the interface class that our Service will implement
it is a simple interface with a method that returns a String.
```Java
public interface JokeService  {
    String getJoke();
}
```

[__JokeServiceImpl.java__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/blob/master/Spring%20Udemy%20Course%20-%20Advanced/Joke%20application/src/main/java/com/ivanllamas/Joke/application/service/JokeServiceImpl.java) this is our Service class that implements the JokeService interface.
We create an instance from the Maven Dependency JAR File `ChuckNorrisQuotes` and initialize it in the constructor. We then return a String value from the `ChuckNorrisQuotes` object, and return it.

NOTE that the __`@Service`__ annotation is very important, because this marks the class as a spring bean, allowing Spring to scan and register this implementation into the __Spring Context__ this becomes important in our Controller class.

```Java
@Service
public class JokeServiceImpl implements JokeService {

    private final ChuckNorrisQuotes cnj;
    
    //initializes the ChuckNorrisQuotes when the constructor is called. 
    public JokeServiceImpl(){
        this.cnj = new ChuckNorrisQuotes();
    }
    
    @Override
    public String getJoke() {
            return cnj.getRandomQuote();   
    }

}
```

## Controller Class

```Java
@Controller
public class JokeController {
    private JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }
    
    @RequestMapping({"/", ""})
    public String showJoke(Model model){
        model.addAttribute("joke", jokeService.getJoke());
        return "chucknorris";
    }
    
}
```

The important part to note here is the `private JokeService jokeService` variable, is being injected by Spring into the constructor
```Java
    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }
```

notice that we didnt call for a `JokeServiceImpl` because spring will inject that _bean_ stored into our __Spring Context__ due to the `@Service` annotation.
So we still make use of the Implementation class without having to explicitly create and instantiate a variable for it by using __dependency injection__


We then display the joke in our HTML template by using the `joke` attribute passed in by our `Model`
```HTML
    <body>
        <p th:text="${joke}"></p>
    </body>
```
