
package com.ivanllamas.HibernateDemo;

import com.ivanllamas.HibernateDemo.entities.Student;
import com.ivanllamas.HibernateDemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    /*Student service variable, it will inject a StudentService bean onto this variable (aka allow us to use 
    CRUD database methods and such)
    
    */
    @Autowired
    StudentService service;
    
    @RequestMapping("/")
    public String homePage(Model model){
       
    
    return "main-menu";
    }
    
    
}
