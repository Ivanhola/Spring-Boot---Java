package com.ivanllamas.ThymeleafDemo.repository;


import com.ivanllamas.ThymeleafDemo.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    //Custom method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
    
}
