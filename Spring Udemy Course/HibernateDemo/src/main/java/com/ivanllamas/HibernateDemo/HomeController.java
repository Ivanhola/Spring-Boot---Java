
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
        //create a Student object, and add it into our database.
        //#TODO, this is an incorrect usage of entering data to a database, We want to create a Student Object
        //add that to a model, and then input data from a form or something using the Model attribute,
        //we will then get that form data and input the Student object information, and use a StudentService to upload
        //that data into our database. this was just used to demonstrate that the database is connected and works.
    Student ivan = new Student("ivan", "l", "ivanl@Gmail.com");
    service.add(ivan);
    
    return "main-menu";
    }
    
    
}
