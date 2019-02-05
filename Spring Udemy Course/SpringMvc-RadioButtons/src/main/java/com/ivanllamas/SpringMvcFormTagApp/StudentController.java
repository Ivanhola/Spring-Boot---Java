
package com.ivanllamas.SpringMvcFormTagApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


/*Controller for our student. Will handle our student form from the URL /student/------
*/


@Controller
@RequestMapping("/student")
public class StudentController {

    
    /*Our controller method for /showForm will create an attribute and add it to our model with a student object*/
    
    
  @RequestMapping("/showForm")
  public String showForm(Model theModel){
      
    //create a new student object
    Student student = new Student();
    
    //add the student object as a model attribute with the name = "studentObj" and the value = student object
    theModel.addAttribute("studentObj", student);
    
    
    return "studentForm";
  }
  
  
  
  /*Our controller method /processForm to take data from our studentObj attribute, and bind it to 
  'theStudent' variable. (binding it to a Student object ) */
  @RequestMapping("/processForm")
  public String processForm(@ModelAttribute("studentObj") Student theStudent){
  
      System.out.println("The student first name: " + theStudent.getFirstName());
      System.out.println("The student last name: " + theStudent.getLastName());

      System.out.println("The students favorite language is: " + theStudent.getFavoriteLanguage());
  return "studentConfirmation";
  }
  
  
}
