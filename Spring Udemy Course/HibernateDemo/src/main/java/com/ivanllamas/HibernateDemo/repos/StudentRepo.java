package com.ivanllamas.HibernateDemo.repos;

import com.ivanllamas.HibernateDemo.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long>{
    
    
}
