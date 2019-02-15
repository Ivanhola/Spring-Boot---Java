
package com.ivanllamas.HibernateDemo;

import com.ivanllamas.HibernateDemo.entities.Student;
import com.ivanllamas.HibernateDemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    //allows us to upload student object to a database
    @Autowired
    StudentService service;
    
    
    /*This will create a form, and add a student object so that our form can input data
    and pass that data through our model 'studentObj' */
    @RequestMapping("/studentForm")
    public String createForm(Model model){
        Student student = new Student();
        model.addAttribute("studentObj", student);
        
        //getting a student from our database example
        System.out.println(service.getStudentById(5).toString());
        
        
        return "student-form";
    }
    
    /*This will get the student object from our form, and we will create a new student object
    with the information from our 'studentObj' form data.
    we will then upload that student information to a database. and display the information on the page.
    */
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("studentObj") Student tempStudent){
        Student student = new Student(tempStudent.getFirstName(), tempStudent.getLastName(), tempStudent.getEmail());
        System.out.println("Adding student to our database.." + student.toString());
        //just for this program, we will delete all the students, and only display this one we added
        //service.deleteAll();
        service.add(student);
        
        System.out.println("Uploaded to database!");
        
        return "form-processed";
    }
    
}
