package com.ivanllamas.HibernateDemo;

import com.ivanllamas.HibernateDemo.entities.Student;
import com.ivanllamas.HibernateDemo.services.StudentService;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateDemoApplication {

    
           
	public static void main(String[] args) {
            
            String databaseURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
            
            String DBusername = "hbstudent";
            String DBpassword = "hbstudent";
            Student student = new Student("john", "wick", "test@Gmail.com");
            try{
            System.out.println("Connecting to database: " + databaseURL);
            
            Connection myConn = DriverManager.getConnection(databaseURL, DBusername, DBpassword);
            
            System.out.println("Connection successful!");
            
            }
            catch(Exception ex){
            System.out.println("Connection failed");
            }

		SpringApplication.run(HibernateDemoApplication.class, args);
	}
    
}

