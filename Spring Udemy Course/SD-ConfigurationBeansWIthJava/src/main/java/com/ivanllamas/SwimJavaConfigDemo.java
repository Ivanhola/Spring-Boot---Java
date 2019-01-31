
package com.ivanllamas;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/*This is a demo app for running our SwimCoach.java bean that we created in SportConfig.java
we manually created a bean, and injected dependency into the bean in the Config class.
*/



public class SwimJavaConfigDemo {
    
        
       
    
    public static void main(String[] args) {
       /*Read spring config class*/
       
       //read from an Annotation Config class instead of a ClassPathXML file
       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
       
       /*Get the bean from the spring container*/
       Coach theCoach = context.getBean("swimCoach", Coach.class);
       
       /*Call a method from the bean*/
       
       System.out.println(theCoach.getDailyWorkout());
       
       
       System.out.println(theCoach.getDailyFortune());
       
     
       
       

       
       /*close the context*/
       context.close();
    }
    
}
