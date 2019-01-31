
package com.ivanllamas;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*This Program demonstrates how to Create a configuration class, so that we can create beans and add them 
to our spring container without using an XML file. (Instead we're going to create a class specifically for storing beans)

*/



public class SpringDemoAnnotation {
    
        
        
    
    public static void main(String[] args) {
       /*Read spring config file*/
       
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       
       /*Get the bean from the spring container*/
       
       //will see an error if you don't use the default bean ID
       TennisCoach theCoach = context.getBean("tennisCoach", TennisCoach.class);
       
       /*Call a method from the bean*/
       
       System.out.println(theCoach.getDailyWorkout());
       
       
       System.out.println(theCoach.getDailyFortune());
       
     
       
       

       
       /*close the context*/
       context.close();
    }
    
}
