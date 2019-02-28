package com.ivanllamas.SpringBootCRUD.DAO;

import com.ivanllamas.SpringBootCRUD.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
