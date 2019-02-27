package com.ivanllamas.SpringBootCRUD.DAO;

import com.ivanllamas.SpringBootCRUD.entity.Employee;
import java.util.List;

/*DAO For our employee Entity*/
public interface EmployeeDAO {
    /*Gets a list of employee Objects*/
    public List<Employee> findall();
    
    /*Get an employee by ID*/
    public Employee findById(long id);
    
    /*Create an employee object and add it to our database*/
    public void save(Employee employee);
    
    /*Delete an Employee by their id*/
    public void deleteById(long id);
    
}
