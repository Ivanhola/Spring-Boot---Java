
package com.ivanllamas.SpringMVCBeanValidation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/*This class will store our customer information like firstName and lastName*/


public class Customer {

    private String firstName;
    
    //add bean validation rules to our lastName variable
    //if the validation fails, 'is required' will be displayed on our html page
    
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName;
    
    //add a variable for free passes
    //add validation rules to this variable using @Min for minimum value and
    //@Max for our maximum value
    @NotNull(message="Must enter a number")
    @Min(value = 0, message = "Value must be greater than or equal to 0")
    @Max(value = 10, message = "Value must be less than or equal to 10")
    private Integer freePasses;
    
    
    //add variable to apply validation rules too
    @Pattern(regexp="^[a-zA-Z0-9]{5}", message = "Only 5 Characters/Digits")
    private String postalCode;
    
    
    
    
    
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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    
    
    
}
