
package com.ivanllamas.ThymeleafDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*Demo controller class for Thymleaf demonstration*/

@Controller
public class DemoController {
@GetMapping("/hello")
public String sayHello(Model model){
    
    //adding a model with the name 'theDate'
    model.addAttribute("theDate", new java.util.Date());
    
    //it will look for helloworld.html file in resources/templates
    
    
    return "helloworld";
}

}
