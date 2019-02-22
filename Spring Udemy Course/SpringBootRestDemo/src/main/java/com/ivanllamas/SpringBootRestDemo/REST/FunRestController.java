
package com.ivanllamas.SpringBootRestDemo.REST;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*Turn this class into a REST Controller */
@RestController
public class FunRestController {

    
    @GetMapping("/")
    public String hello(){
        return "hello world! the current time is: " + LocalDateTime.now();
    }
}
