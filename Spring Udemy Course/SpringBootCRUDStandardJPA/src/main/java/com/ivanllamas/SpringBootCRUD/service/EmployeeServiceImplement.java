
package com.ivanllamas.SpringBootCRUD.service;

import com.ivanllamas.SpringBootCRUD.DAO.EmployeeDAO;
import com.ivanllamas.SpringBootCRUD.entity.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*Create a service class that will use @Transactional annotation*/
@Service
public class EmployeeServiceImplement implements EmployeeService {

    private EmployeeDAO employeeDao;
    
    //set up constructor injection
    @Autowired
    public EmployeeServiceImplement(@Qualifier("employeeDAOJpaImplementation")EmployeeDAO employeeDAO){
        this.employeeDao = employeeDAO;
    }
    
    /*We will delegate the calls to the DAO*/
    @Override
    @Transactional
    public List<Employee> finaAll() {
    return employeeDao.findall();
    }

    @Override
    @Transactional
    public Employee findById(long id) {
        return employeeDao.findById(id);
        }

    @Override
    @Transactional
    public void save(Employee employee) {
       employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        employeeDao.deleteById(id);
         }

}
