package com.ivanllamas.SpringBootCRUD.service;

import com.ivanllamas.SpringBootCRUD.entity.Employee;
import java.util.List;


public interface EmployeeService {
  public List<Employee> finaAll();

  public Employee findById(long id);
  
  public void save(Employee employee);
  
  public void deleteById(long id);
}
