
package com.ivanllamas.SpringMvcFormTagApp;


/*This student object will store data (firstName string and lastName String)*/
public class Student {
    
    //our student object variables
    private String firstName;
    private String lastName;
    
    //our default constructor
    public Student(){
    
    }
    
    
    
    /*getters and setters for our form to be able to set and get data.*/

    
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
