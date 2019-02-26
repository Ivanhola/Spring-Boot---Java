
package com.ivanllamas.SpringBootCRUD.REST;

import com.ivanllamas.SpringBootCRUD.DAO.EmployeeDAO;
import com.ivanllamas.SpringBootCRUD.entity.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*RestController*/



@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

    private EmployeeDAO employeeDAO;
    
    //inject EmployeeDAO into the controller
    @Autowired
    public EmployeeRESTController(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }
    //create /employees mapping to return a list of employees
    
    @GetMapping("/employees")
    public List<Employee> returnAllEmployees(){
        return employeeDAO.findall();
    }
}
