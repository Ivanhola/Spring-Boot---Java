
package com.ivanllamas.SpringBootCRUD.DAO;

import com.ivanllamas.SpringBootCRUD.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//setup the Repository Annotation
//the DAO Will use these queries to perform the database Check
//This will use the standard JPA methods to run queries to the database

@Repository
public class EmployeeDAOJpaImplementation implements EmployeeDAO {

    private EntityManager entityManager;
    
    @Autowired
     public EmployeeDAOJpaImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
     
     
    @Override
    public List<Employee> findall() {
     //create a query
     Query theQuery = entityManager.createQuery("FROM Employee");
     //execute query and get result list
     List<Employee> employees = theQuery.getResultList();
     
     //return the results
     
     return employees;
    }

   

    @Override
    public Employee findById(long id) {
    //get employee
    Employee employee =  entityManager.find(Employee.class, id);
    //return employee
    return employee;
    }
    
    

    @Override
    public void save(Employee employee) {
        //save or update the employee
        Employee dbEmployee = entityManager.merge(employee);
        
        //update with id from database so we can generate id for save/insert
        employee.setId(dbEmployee.getId());
        
        }

    @Override
    public void deleteById(long id) {
    //delete object with primary key

    Query theQuery = entityManager.createQuery("DELETE FROM Employee WHERE id=:employeeId");
    
    theQuery.setParameter("employeeId", id);
    
    theQuery.executeUpdate();
    }

}
