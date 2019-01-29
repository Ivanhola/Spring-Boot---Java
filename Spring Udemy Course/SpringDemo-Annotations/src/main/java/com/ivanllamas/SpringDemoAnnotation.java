
package com.ivanllamas;

import org.springframework.context.support.ClassPathXmlApplicationContext;

                    /*This program is to demonstrate the use of @Component with our classes.
                    Using this annotation will enable us to create Spring beans, without using an xml file to reference them from
                    (Alternative method to doing the same thing as using a .xml <beans> etc...)*/

public class SpringDemoAnnotation {
    
        
        /*Steps needed to Add component scanning: Add xml file and enable component scanning <context:component-scan.../>
          add annotation with @Component to our class(es)*/
    
    public static void main(String[] args) {
       /*Read spring config file*/
       
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       
       /*Get the bean from the spring container*/
       
       Coach theCoach = context.getBean("thatCoolCoach", Coach.class);
       
       /*Call a method from the bean*/
       
       System.out.println(theCoach.getDailyWorkout());
       
       /*close the context*/
       context.close();
    }
    
}
