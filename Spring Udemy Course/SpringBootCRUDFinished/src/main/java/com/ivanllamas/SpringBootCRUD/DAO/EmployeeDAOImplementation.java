
package com.ivanllamas.SpringBootCRUD.DAO;

import com.ivanllamas.SpringBootCRUD.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*This would be our 'service' class, that uses the EmployeeDAO*/
@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

    //Define variable for EntityManager
    
    private EntityManager entityManager;
    
    //injecttion for our constructor, the entity manager is automatically created by spring boot, and we inject that
    //entity into this constructor
    
    @Autowired
    public EmployeeDAOImplementation(EntityManager entManager){
     this.entityManager = entManager;   
    }
    
    
    //method from our DAO interface to retrieve stuff from our entityManager(database)
    //the @Transactional annotation handles the transaction management so we don't have to manually start and commit transactions
    @Override
    //@Transactional
    public List<Employee> findall() {
        
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        
        //create a query
        Query<Employee> theQuery= currentSession.createQuery("FROM Employee", Employee.class);
        
        //execute query and get result list
        List<Employee> employees = theQuery.getResultList();
        //return the results
        
     return employees;   
    }

    
    
    //Find an employee by passing in an id value
    @Override
    public Employee findById(long id) {
        //Current Hibernate Session
        Session currentSession = entityManager.unwrap(Session.class);
        //get the employee
        Employee employee = currentSession.get(Employee.class, id);
        
        //return the employee
        return employee;
       }

    //Save or update an employee by passing in an Employee Object
    @Override
    public void save(Employee employee) {
        //get the hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        
        //save employee
        //If the id is 0, it will save, or else if its not 0, it will perfom an UPDATE on the employee
        currentSession.saveOrUpdate(employee);
        
    }

    //Delete an Employee by passing in Id value
    @Override
    public void deleteById(long id) {
    //get the current hibernate session
    Session currentSession = entityManager.unwrap(Session.class);
    
    //delete object with primary key
    Query query = currentSession.createQuery("DELETE from employee WHERE id=:employeeId");
    query.setParameter("employeeId", id);
    query.executeUpdate();
    
    
    }
    
    

}
