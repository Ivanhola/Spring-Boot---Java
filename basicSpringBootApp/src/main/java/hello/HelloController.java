
package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


//Class is flagged as a RestController, meaning its ready to handle web requests

@RestController
public class HelloController {
    
        //this maps '/' to the index() method. When invokedm the method returns pure text
    @RequestMapping("/")
    public String index(){
        return "Hello World Spring Boot";
    }
    
}
