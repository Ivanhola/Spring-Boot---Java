
package com.ivanllamas.SpringBootCRUD.service;

import com.ivanllamas.SpringBootCRUD.DAO.EmployeeRepository;
import com.ivanllamas.SpringBootCRUD.entity.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*Create a service class that will use @Transactional annotation*/
@Component
public class EmployeeServiceImplement{

    private EmployeeRepository employeeRepo;
    
    //set up constructor injection
    @Autowired
    public EmployeeServiceImplement(EmployeeRepository employeeRepository){
        this.employeeRepo = employeeRepository;
    }
    
    /*We will delegate the calls to the DAO*/
    
    public List<Employee> findsAll() {
    return employeeRepo.findAll();
    }

  
    public Employee findById(long id) {
         Optional<Employee> result = employeeRepo.findById(id);
         
         Employee theEmployee =null;
         //checks if the Optional isn't null
         if(result.isPresent()){
            theEmployee = result.get();
         }
         else{
             //we couldnt find an employee by the id
             throw new RuntimeException("Did not find employee id - " + id);
         }
         
         return theEmployee;
        }

   
    public void save(Employee employee) {
       employeeRepo.save(employee);
    }

    
    public void deleteById(long id) {
        employeeRepo.deleteById(id);
         }

}
