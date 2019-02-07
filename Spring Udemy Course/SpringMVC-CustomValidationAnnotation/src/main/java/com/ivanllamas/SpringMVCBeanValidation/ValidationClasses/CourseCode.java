package com.ivanllamas.SpringMVCBeanValidation.ValidationClasses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


/*Create a new annotation called @CourseCode*/

/* 
@Constraint will tell spring what Class will be used to apply validation rules to this Annotation 
(CourseCodeConstraintValidator.java class)

@Target will tell us where we can apply this annotation to (methods and variables)

@Retention how long the annotation will be used for (retain this annotation in the byte code, and use it at run time
by the JVM)

We now need to define the attributes that we can pass in our annotation (value, message), if the user doesnt enter
any attributes, the default values and messages will be what we set in this class



*/


@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //define default course code
    public String value() default "RCC";
    
    //define default error message
    public String message() default "Must start with RCC";
    
    //define default groups
    public Class<?>[] groups() default {};
    
    //define default payloads (this provides custom details about validation failure such as severe level, error code)
    public Class<? extends Payload>[] payload() default {};
    
}
