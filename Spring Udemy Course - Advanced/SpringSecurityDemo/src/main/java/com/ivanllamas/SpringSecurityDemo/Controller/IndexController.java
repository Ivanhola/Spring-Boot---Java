
package com.ivanllamas.SpringSecurityDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"/", "/home"})
    public String home(){
        return "home";
    }
    
    @RequestMapping("/hello")
    public String helloWorld(){
        return "helloworld";
    }
    
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
