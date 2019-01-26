
package com.ivanllamas.Dao;

import com.ivanllamas.Entity.Student;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
 private static Map<Integer,Student> students;  


    static{
        /*Create a hashmap that takes in an Int, and a Student object*/
        students = new HashMap<Integer, Student>(){
        
            {
                put(1, new Student(1, "Ivan", "Computer Science"));
                put(1, new Student(1, "Angela Y.", "Art"));
                put(1, new Student(1, "Adrian", "CAD"));
                
            }
        
        };
    }
    
    //will get the collection of the hashmap and return it
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }
}
