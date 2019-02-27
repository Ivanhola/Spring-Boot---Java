
package com.ivanllamas.SpringBootCRUD.REST;

import com.ivanllamas.SpringBootCRUD.entity.Employee;
import com.ivanllamas.SpringBootCRUD.service.EmployeeServiceImplement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*RestController*/



@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

    private EmployeeServiceImplement employeeService;
    //private EmployeeDAO employeeDAO; this code was refactored and removed to inject the above variable instead
    
    //inject EmployeeService into the controller
    @Autowired
    public EmployeeRESTController(EmployeeServiceImplement employeeService){
        this.employeeService = employeeService;
    }
    //create /employees mapping to return a list of employees
    
    @GetMapping("/employees")
    public List<Employee> returnAllEmployees(){
        return employeeService.findsAll();
    }
    
    
    //add Mapping for GET /employees/{employeeId}
    //localhost:8080/api/employees/1
    
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable long employeeId){
        Employee employee = employeeService.findById(employeeId);
        
        if(employee == null){
            throw new RuntimeException("Employee Id not found" + employeeId);
        }
        return employee;
    }
    
    /*These methods can be tested in software like postman to send POST, PUT, DELETE request to our api*/
    
    
    //add mapping for POST /employees - add new employee
    //Post mapping to add an employee using POST request
    //if a user sends in a JSON Data POST request, it will add an employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        //incase they send an id, set it to 0 so it creates a new object instead of updating it
        employee.setId(0);
        
        employeeService.save(employee);
        
        return employee;
    }
    
    //Add a mapping for PUT /employees - updates an existing employee   
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        //this handles the Update for a given employee (it doesnt set the id == 0
        employeeService.save(employee);
        
        return employee;
    }
    
    
    //add a mapping for DELETE /employees/{employeeId} - deletes an existing Employee 
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable long employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);
        
        if(tempEmployee == null){
            throw new RuntimeException("Employee Id not found - " + employeeId);
        }
        
        employeeService.deleteById(employeeId);
        
        return "Deleted employee by id - " + employeeId;
    }
    
}
