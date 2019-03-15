
package com.ivanllamas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {

    
    @RequestMapping({"/","","index","index.html"})
    public String index(){
        
        return "index";
    }

    @RequestMapping("/oups")
    public String errorPage() {
        return "error";
    }
    
    
}
