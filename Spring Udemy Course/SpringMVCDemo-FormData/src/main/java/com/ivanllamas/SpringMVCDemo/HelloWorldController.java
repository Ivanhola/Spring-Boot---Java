
package com.ivanllamas.SpringMVCDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/*Spring MVC Controller*/

@Controller
public class HelloWorldController {

    /*Controller method to show the initial HTML form*/
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }
    
    /*Controller method to process the HTML form*/
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }
}

