package com.ivanllamas.SpringBootCRUD.DAO;

import com.ivanllamas.SpringBootCRUD.entity.Employee;
import java.util.List;

/*DAO For our employee Entity*/
public interface EmployeeDAO {
    public List<Employee> findall();
}
