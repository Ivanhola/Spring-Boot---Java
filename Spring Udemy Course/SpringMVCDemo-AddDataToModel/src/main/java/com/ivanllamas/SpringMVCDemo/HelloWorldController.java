
package com.ivanllamas.SpringMVCDemo;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    
    /*Add a new controller method to read form data and add the data to the model*/
    @RequestMapping("/processFormVersionTwo")
    public String readFormData(HttpServletRequest request, Model model){
       
        //read the request parameter from the HTML form
        String studentName = request.getParameter("studentName");
        
        //convert the data to all caps
        studentName = studentName.toUpperCase();

        //create our message
        String result = "HELLO THERE, " + studentName + "!!!";
 
        //add the message to the model
        
        model.addAttribute("message",result);
        
        return "helloworld";
    } 
}

