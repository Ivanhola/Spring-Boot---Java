
package com.ivanllamas.SpringMVCBeanValidation.ValidationClasses;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/*This will serve as the validating rules for our CourseCode.java class, implements Constraints package from 
spring validation depencencies

*/
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {

    //this will be the string that we will be validating against
    private String coursePrefix;
    
    
    
    @Override
    public void initialize(CourseCode theCourseCode) {
        //setting coursePrefix to equal the value of the annotation that is passed in
        coursePrefix = theCourseCode.value();
    }
    
    
    //(our first argument is going to be HTML form data entered by the user, the second argument is used to give
    // additional error messages if we need to)
    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext cvc) {
        
        //does the HTML form passed in start with the coursePrefix that we have set in the annotation? 'RCC'
        boolean result;
        
        //if the user doesn't enter anything check the code, else result = true
        if(theCode!=null){
                
                result = theCode.startsWith(coursePrefix);
        }
        else {
        result = true;
        }
        
        return result;
    }

}
