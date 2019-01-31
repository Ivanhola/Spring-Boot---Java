
package com.ivanllamas;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*This Program demonstrates how to manually create beans in our new Config class SportConfig.java
we created +SadFortuneService.java as well as +SwimCoach.java

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
