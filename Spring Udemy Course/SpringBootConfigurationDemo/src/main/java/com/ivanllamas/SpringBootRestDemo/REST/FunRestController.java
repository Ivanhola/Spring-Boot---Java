
package com.ivanllamas.SpringBootRestDemo.REST;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*By default, we can read from application.properties, but by adding this, we can read from a custom properties file
  we also have 

person.name=Ivan
person.email=ivan@gmail.com

in our application.properties file that we can use to fill in the variable values.*/
@PropertySource("classpath:person.properties")

/*Turn this class into a REST Controller */
@RestController


public class FunRestController {
    /*Injecting values from a properties file */
    @Value("${first.name}")
    private String name;
    
    @Value("${last.name}")
    private String email;

    
    @GetMapping("/")
    public String hello(){
        return "hello world! the current time is: " + LocalDateTime.now();
    }
    
    //Person info endpoint
    @GetMapping("/person")
    public String person(){
        return "Name: " + name + "<br/> Email: " + email;
    }
    
    //New endpoint for 'workout'
    @GetMapping("/workout")
    public String getWorkout(){
        return "run a hard 5k";
    }
    
    //New endpoint for 'fortune'
    @GetMapping("/fortune")
    public String getFortune(){
        return "Have a good day!";
    }
}
