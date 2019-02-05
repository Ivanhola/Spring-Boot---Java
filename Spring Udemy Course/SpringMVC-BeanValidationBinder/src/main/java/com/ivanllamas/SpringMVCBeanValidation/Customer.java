
package com.ivanllamas.SpringMVCBeanValidation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/*This class will store our customer information like firstName and lastName*/


public class Customer {

    private String firstName;
    
    //add bean validation rules to our lastName variable
    //if the validation fails, 'is required' will be displayed on our html page
    
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName;
    
    
    
    
                                     /* Getters and Setters */

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
