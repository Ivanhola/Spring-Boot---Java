
package com.ivanllamas.ThymeleafDemo.controller;

import com.ivanllamas.ThymeleafDemo.model.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    //load employee data
    
    private List<Employee> employees;
    
    //method to create and load a list of EmployeeObjects
    @PostConstruct
    private void loadData(){
        //create employees
        Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslie@gmail.com");
        Employee emp2 = new Employee(2, "Ivan", "Llamas", "ivan@gmail.com");
        Employee emp3 = new Employee(3, "Adrian", "Long", "Adrian@gmail.com");
        Employee emp4 = new Employee(4, "John", "Doe", "Johndoe@gmail.com");
        //create the list
        
        employees = new ArrayList<>();
        
        //add employees to the list
        
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
    }
    
    //add mapping for /list
    @GetMapping("/list")
    public String employeeList(Model model){
        
        //add to the spring model
        model.addAttribute("employees", employees);
        
        
        
        return "employee-list";
    }
}
