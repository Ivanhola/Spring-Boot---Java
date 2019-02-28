package com.ivanllamas.SpringBootCRUD.DAO;

import com.ivanllamas.SpringBootCRUD.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/*Change our path for Spring Data Rest*/
@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
