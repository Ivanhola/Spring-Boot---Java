
package com.ivanllamas.SpringMVCDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*Class will tell spring that this an MVC Controller*/


@Controller
public class HomeController {
    
    //map a URL request to this method  (for example if we had /hello, when the user goes to www.website.com/hello
    //it would perform the following method, aka show the following web page)
    @RequestMapping("/")
    public String showPage(){
        //this will look into our resource/templates folder, and call up a file named: main-menu.html (using thymeleaf)
    return "main-menu";
    }
}
