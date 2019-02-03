
package com.ivanllamas.SpringMVCDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DittoController {

   
   /*copy the mapping from HelloWorldController.java*/ 
    @RequestMapping("/showForm")
    public String displayTheForm(){
        return "ditto";
    }
}
