
package com.ivanllamas;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/*This Program demonstrates how to Create a configuration class, so that we can create beans and add them 
to our spring container without using an XML file. (Instead we're going to create a class specifically for storing beans)

*/



public class JavaConfigDemo {
    
        
        /*This program is used to demonstrate how to store beans to a Spring Container without using an xml file
        instead we can use a dedicated class, to store beans by using the @Configuration annotation, 
        and @ComponentScan("packageThatContainsComponents")*/
    
    public static void main(String[] args) {
       /*Read spring config class*/
       
       //read from an Annotation Config class instead of a ClassPathXML file
       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
       
       /*Get the bean from the spring container*/
       TennisCoach theCoach = context.getBean("tennisCoach", TennisCoach.class);
       
       /*Call a method from the bean*/
       
       System.out.println(theCoach.getDailyWorkout());
       
       
       System.out.println(theCoach.getDailyFortune());
       
     
       
       

       
       /*close the context*/
       context.close();
    }
    
}
