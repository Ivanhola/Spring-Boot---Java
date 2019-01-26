
package com.ivanllamas.Service;

import com.ivanllamas.Dao.StudentDao;
import com.ivanllamas.Entity.Student;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    @Autowired
    private StudentDao studentDao;
    //will get the collection of the hashmap from our studentDao static initializer
    public Collection<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }
    
}
