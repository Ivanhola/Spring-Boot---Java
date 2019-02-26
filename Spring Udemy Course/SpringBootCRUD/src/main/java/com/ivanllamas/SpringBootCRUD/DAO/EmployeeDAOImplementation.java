
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
    @Transactional
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

}
