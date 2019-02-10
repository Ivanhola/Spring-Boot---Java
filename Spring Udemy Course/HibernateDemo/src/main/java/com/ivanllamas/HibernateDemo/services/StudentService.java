
package com.ivanllamas.HibernateDemo.services;

import com.ivanllamas.HibernateDemo.entities.Student;
import com.ivanllamas.HibernateDemo.repos.StudentRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*Student Service that takes in a StudentRepo dependency so we can use CRUD methods*/
@Component
public class StudentService {

    /*Will inject our repo*/
    @Autowired
    StudentRepo repo;
    
    public void add(Student dto){
        repo.save(dto);
    }
    
    public void delete(long id){
        repo.deleteById(id);
    }
    
    public void deleteAll(){
        repo.deleteAll();
    }
    
    public List<Student> getStudents(){
        return (List<Student>) repo.findAll();
    }
    
    public Student getStudentById(long id){
        Optional<Student> optionalStudent = repo.findById(id);
        return optionalStudent.get();
    }
    
    public StudentService(){
        
    }
    
}
