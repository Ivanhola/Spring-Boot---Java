
package com.ivanllamas;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/* Added Change log to show whats added and changed for each program starting from this one onward.
*/



public class SwimJavaConfigDemo {
    
        
       
    
    public static void main(String[] args) {
       /*Read spring config class*/
       
       //read from an Annotation Config class instead of a ClassPathXML file
       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
       
       /*Get the bean from the spring container*/
       SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
       
       /*Call a method from the bean*/
       
       System.out.println(theCoach.getDailyWorkout());
       
       
       System.out.println(theCoach.getDailyFortune());
       
       System.out.println("Email: " + theCoach.getEmail());
       
       System.out.println("Name: " + theCoach.getName());


       
     
       
       

       
       /*close the context*/
       context.close();
    }
    
}
