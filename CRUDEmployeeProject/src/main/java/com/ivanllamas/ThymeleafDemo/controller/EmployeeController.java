
package com.ivanllamas.ThymeleafDemo.controller;


import com.ivanllamas.ThymeleafDemo.Service.EmployeeServiceImplement;
import com.ivanllamas.ThymeleafDemo.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    
  private EmployeeServiceImplement employeeService;  
  
  //injecting our EmployeeServiceImplement class into the constructor
  @Autowired
  public EmployeeController(EmployeeServiceImplement theEmployeeService){
      this.employeeService = theEmployeeService;
  }
  
    //add mapping for /list , will pull data from our Database using the EmployeeServiceImplement 
    @GetMapping("/list")
    public String employeeList(Model model){
        
        List<Employee> theEmployees = employeeService.findsAll();
        
        //we take that data and add to the spring model, so thymeleaf can read this data
        model.addAttribute("employees", theEmployees);
        
        
        //will look under the folder employees in our templates folder then look for employee-list.html
        return "employees/employee-list";
    }
    
    //GET Mapping for our Form to add an employee
    @GetMapping("/addEmployeeForm")
    public String addEmployeeForm(Model model){
        
        //create the model attribute to bind form data
        Employee employee = new Employee();
        //binding the employee object to the spring model attribute 'employee'
        model.addAttribute("employee", employee);
        
        return "employees/addEmployeeForm";
    }
    
    
    //Mapping for a POST method, when the form is submitted, we will process the form by getting the 
    //data from the model attribute 'employees' and binding it to an Employee object
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
       
        //save the employee to our database by calling the save() method in the employee service
        employeeService.save(employee);
        
        //use a redirect to prevent users from dublicating submissions
        return "redirect:/employees/list";
    }
    
    
    /*mapping for updating an employee from our list, calls a parameter 'employeeId' from 
    our thymeleaf form, and binds the value to 'id' 
    */
    @GetMapping("/updateEmployeeForm")
    public String showFormForUpdate(@RequestParam("employeeId") long id, Model model){
        
        //get the employee by id from our database
        Employee theEmployee = employeeService.findById(id);
        
        //set the employee passed in as a model attribute to pre-populate the form
        model.addAttribute("employee", theEmployee);
        
        return "employees/addEmployeeForm";
    }
    
    
    /*Add mapping for Delete*/
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") long id){
        
        //delete from our database
        employeeService.deleteById(id);
        
        return "redirect:/employees/list";
        
    }
    
    
}
