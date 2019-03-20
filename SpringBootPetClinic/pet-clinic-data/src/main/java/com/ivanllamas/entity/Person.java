
package com.ivanllamas.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/*Base class for our Owner/Vet */

//Won't be added to database, but other entitys will extend from this class.

@MappedSuperclass
public class Person extends BaseEntity{

    //name of the columns in the database
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;

 
    /*Constructors*/

    
    public Person() {
        
    }
    
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
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
    
    
}
