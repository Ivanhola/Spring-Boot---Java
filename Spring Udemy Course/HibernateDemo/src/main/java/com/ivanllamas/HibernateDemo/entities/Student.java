
package com.ivanllamas.HibernateDemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*Entity Class mapped to "student" table in our database*/

@Entity
@Table(name="student")
public class Student {
    
    /*Create variables that will map to our database columns*/
    
    @Id
    @Column(name="id")
    private long id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="email")
    private String email;
    
    
    /*no-arg constructor*/
    public Student() {
        
    }

    /*Constructor that takes a first name, lastname, email*/
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    
    /*Getters and Setters*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName=" + firstName + 
                ", lastName=" + lastName + ", email=" + email + '}';
    }
    
    
    
    
    
}
